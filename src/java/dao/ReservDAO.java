package dao;

import java.sql.*;
import java.util.logging.*;
import util.CSDB;

public class ReservDAO {
    
    public String insertBooking(int studentId, int courseId)  {
        Connection conn = null;
        try {
            conn = CSDB.getConnection();
            conn.setAutoCommit(false); // [START TRANSACTION]

            // 1. เช็คก่อนว่าวิชานี้ที่นั่งเต็มหรือยัง
            String checkSql = "SELECT (course_maxseat - (SELECT COUNT(*) FROM enroll e JOIN session s ON e.session_id = s.session_id WHERE s.course_id = ?)) as available FROM course WHERE course_id = ?";
            PreparedStatement psCheck = conn.prepareStatement(checkSql);
            psCheck.setInt(1, courseId);
            psCheck.setInt(2, courseId);
            ResultSet rs = psCheck.executeQuery();
            
            if (rs.next() && rs.getInt("available") <= 0) {
                return "Full"; // ที่นั่งเต็ม
            }

            // 2. หา session_id จาก course_id (สมมติว่า 1 วิชาเปิดแค่ 1 session ในตอนนี้)
            String sessionSql = "SELECT session_id FROM session WHERE course_id = ? LIMIT 1";
            PreparedStatement psSess = conn.prepareStatement(sessionSql);
            psSess.setInt(1, courseId);
            ResultSet rsSess = psSess.executeQuery();
            
            if (rsSess.next()) {
                int sessionId = rsSess.getInt("session_id");

                // 3. บันทึกการจองลงตาราง enroll
                String enrollSql = "INSERT INTO enroll (student_id, session_id, enroll_date) VALUES (?, ?, NOW())";
                PreparedStatement psEnroll = conn.prepareStatement(enrollSql);
                psEnroll.setInt(1, studentId);
                psEnroll.setInt(2, sessionId);
                psEnroll.executeUpdate();

                conn.commit(); // [COMMIT] บันทึกสำเร็จทั้งหมด
                return "Success";
            }
            
            return "Error";

       } catch (SQLException e) { // ดักจับ SQLException ที่นี่
        if (conn != null) try { conn.rollback(); } catch (SQLException ex) {}
        e.printStackTrace();
        return "Fail: " + e.getMessage(); // ส่งข้อความ error กลับไปแทน
    }   catch (Exception ex) {
            System.getLogger(ReservDAO.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        } finally {
        if (conn != null) try { conn.close(); } catch (SQLException ex) {}
    }
        return null;
    }
}
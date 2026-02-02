package dao;

import java.sql.*;
import java.util.logging.*;
import util.CSDB;

public class ReservDAO {
    
    public String insertBooking(int studentId, int sessionId) {
    Connection conn = null;
    try {
        conn = CSDB.getConnection();
        conn.setAutoCommit(false); 

        // 1. เช็คที่นั่งว่าง (SQL ตามที่คุณเขียนไว้)
        String checkSql = "SELECT (s.max_seat - (SELECT COUNT(*) FROM enroll WHERE session_id = ?)) as available " +
                          "FROM session s WHERE s.session_id = ?";
        PreparedStatement psCheck = conn.prepareStatement(checkSql);
        psCheck.setInt(1, sessionId);
        psCheck.setInt(2, sessionId);
        ResultSet rs = psCheck.executeQuery();
        
        if (rs.next() && rs.getInt("available") <= 0) {
            return "Full"; 
        }

        // 2. บันทึกการจอง (SQL ตามที่คุณเขียนไว้)
        String enrollSql = "INSERT INTO enroll (student_id, session_id, enroll_date) VALUES (?, ?, NOW())";
        PreparedStatement psEnroll = conn.prepareStatement(enrollSql);
        psEnroll.setInt(1, studentId);
        psEnroll.setInt(2, sessionId);
        psEnroll.executeUpdate();

        conn.commit(); 
        return "Success";

    } catch (Exception e) { // นี่คือการ "สั่งสอน" รับผิดชอบข้อผิดพลาด
        if (conn != null) {
            try { conn.rollback(); } catch (SQLException ex) { ex.printStackTrace(); }
        }
        e.printStackTrace();
        return "Fail: " + e.getMessage();
    } finally {
        if (conn != null) {
            try { conn.close(); } catch (SQLException ex) { ex.printStackTrace(); }
        }
    }
}
}
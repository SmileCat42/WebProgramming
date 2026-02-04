package dao;

import java.sql.*;
import java.util.logging.*;
import util.CSDB;

public class ReservDAO {
    
    public String insertBooking(int studentId, int sessionId) {
    Connection conn = null;
    try {
        conn = CSDB.getConnection();
        conn.setAutoCommit(false); //transaction อย่าเพิ่งบันทึกน้าาาา

        String checkSql = "SELECT (s.session_max - (SELECT COUNT(*) FROM enroll WHERE session_id = ?)) as available " +
                          "FROM session s WHERE s.session_id = ?";
        PreparedStatement psCheck = conn.prepareStatement(checkSql);
        psCheck.setInt(1, sessionId);
        psCheck.setInt(2, sessionId);
        ResultSet rs = psCheck.executeQuery();                     // ตั้งแต่บรรทัด 15-24 คือเช็คที่นั่งว่างหมดเรย
        
        if (rs.next() && rs.getInt("available") <= 0) {
            return "Full"; 
        }

        // 2. บันทึกการจอง 
        String enrollSql = "INSERT INTO enroll (student_id, session_id, enroll_time) VALUES (?, ?, NOW())";
        PreparedStatement psEnroll = conn.prepareStatement(enrollSql);
        psEnroll.setInt(1, studentId);
        psEnroll.setInt(2, sessionId);
        psEnroll.executeUpdate();

        conn.commit(); 
        return "Success";

    } catch (Exception e) { // หากไม่สำเร็จ จะยกเลิกการกระทำทุกอย่าง (วีน)
        if (conn != null) {
            try { conn.rollback(); } catch (SQLException ex) { ex.printStackTrace(); } //rollback = ยกเลิก วีน
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
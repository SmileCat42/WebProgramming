package dao;
import java.sql.*;
import java.util.*;
import model.Session;
import util.CSDB;

public class SessionDAO {
    public List<Session> getSessionsByCourse(int courseId) {
        List<Session> list = new ArrayList<>();
        String sql = "SELECT session_id, session_date, session_time FROM session WHERE course_id = ?";
        
        try (Connection conn = CSDB.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, courseId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Session s = new Session();
                s.setSessionId(rs.getInt("session_id"));
                s.setSessionDate(rs.getString("session_date"));
                s.setSessionTime(rs.getString("session_time"));
                list.add(s);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception ex) {
            System.getLogger(SessionDAO.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
        return list;
    }
}
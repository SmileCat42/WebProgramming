package dao;
import java.sql.*;
import java.util.*;
import model.Student;
import util.CSDB;

public class EnrollmentDAO {

public int countAllEnroll() throws Exception {
    int total = 0;
    Connection c = CSDB.getConnection();
    String sql = "SELECT COUNT(*) AS total FROM enroll"; // สมมติว่าตารางชื่อ course
    PreparedStatement p = c.prepareStatement(sql);
    ResultSet rs = p.executeQuery();
    
    if (rs.next()) {
        total = rs.getInt("total");
    }
    c.close();
    return total;
}
}
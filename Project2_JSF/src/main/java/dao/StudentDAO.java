package dao;
import java.sql.*;
import java.util.*;
import model.Student;
import util.CSDB;

public class StudentDAO {

public int countAllStudents() throws Exception {
    int total = 0;
    Connection c = CSDB.getConnection();
    String sql = "SELECT COUNT(*) AS total FROM student"; // นัดจำนวนแถวทั้งหมด
    PreparedStatement p = c.prepareStatement(sql);
    ResultSet rs = p.executeQuery();
    
    if (rs.next()) {
        total = rs.getInt("total");
    }
    c.close();
    return total;
}
}
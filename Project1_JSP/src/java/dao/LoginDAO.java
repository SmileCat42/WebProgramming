package dao;
import java.sql.*;
import java.util.*;
import model.Student;
import util.CSDB;

public class LoginDAO {

    public Student login(String user, String pass) throws Exception {

        Connection c = CSDB.getConnection();

        PreparedStatement p = c.prepareStatement(
            "SELECT * FROM student WHERE student_user=? AND student_pass=?"
        );
        p.setString(1, user);
        p.setString(2, pass);

        ResultSet rs = p.executeQuery();

        if (rs.next()) {
            Student s = new Student(
                rs.getInt("student_id"),
                rs.getString("student_fname"),
                rs.getString("student_lname"),
                rs.getString("student_user"),
                rs.getString("student_pass"),
                rs.getString("student_email")
            );
            c.close();
            return s;
        }

        c.close();
        return null;
    }
}
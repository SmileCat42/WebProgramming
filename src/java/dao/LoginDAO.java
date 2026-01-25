package dao;
import java.sql.*;
import java.util.*;
import model.Student;
import util.CSDB;

public class LoginDAO {

    public Student login(String user, String pass) throws Exception {

        Connection c = CSDB.getConnection();

        PreparedStatement p = c.prepareStatement(
            "SELECT * FROM student WHERE user=? AND pass=?"
        );
        p.setString(1, user);
        p.setString(2, pass);

        ResultSet rs = p.executeQuery();

        if (rs.next()) {
            Student s = new Student(
                rs.getInt("id"),
                rs.getString("fname"),
                rs.getString("lname"),
                rs.getString("user"),
                rs.getString("pass"),
                rs.getString("email")
            );
            c.close();
            return s;
        }

        c.close();
        return null;
    }
}
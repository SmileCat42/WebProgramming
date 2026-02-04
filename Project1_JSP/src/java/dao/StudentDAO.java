package dao;
import java.sql.*;
import java.util.*;
import model.Student;
import util.DBUtil;

public class StudentDAO {
    public List<Student> findAll() throws Exception{
        List<Student> list=new ArrayList<>();
        Connection c=DBUtil.getConnection();
        ResultSet rs=c.createStatement().executeQuery("SELECT * FROM student");
        while(rs.next()){
            list.add(new Student(rs.getInt("id"),
                rs.getString("fname"),
                rs.getString("lname"),
                rs.getString("user"),
                rs.getString("pass"),
                rs.getString("email")));
        }
        c.close();
        return list;
    }

    public void insert(Student r) throws Exception{
        Connection c=DBUtil.getConnection();
        PreparedStatement p=c.prepareStatement(
            "INSERT INTO student(student_fname, student_lname, student_user,"
                    + "student_pass, student_email) VALUES(?,?,?,?,?,?)");
        p.setString(1,r.getFname());
        p.setString(2,r.getLname());
        p.setString(3,r.getUser());
        p.setString(4,r.getPass());
        p.setString(5,r.getEmail());
        p.setString(6,"STUDENT");
        p.executeUpdate();
        c.close();
    }

    public void delete(int id) throws Exception{
        Connection c=DBUtil.getConnection();
        PreparedStatement p=c.prepareStatement(
            "DELETE FROM stu WHERE id=?");
        p.setInt(1,id);
        p.executeUpdate();
        c.close();
    }
}
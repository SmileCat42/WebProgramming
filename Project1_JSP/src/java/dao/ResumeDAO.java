package dao;

import java.sql.*;
import java.util.*;
import model.Resume;
import util.DBUtil;

public class ResumeDAO {

    public List<Resume> findAll() throws Exception {
        List<Resume> list = new ArrayList<>();
        Connection c = DBUtil.getConnection();
        ResultSet rs = c.createStatement().executeQuery("SELECT * FROM stu");
        while (rs.next()) {
            list.add(new Resume(rs.getInt("id"),
                    rs.getString("cc"),
                    rs.getString("fname"),
                    rs.getString("lname"),
                    rs.getDouble("grade")));
        }
        c.close();
        return list;
    }

    public void insert(Resume r) throws Exception {
        Connection c = DBUtil.getConnection();
        PreparedStatement p = c.prepareStatement(
                "INSERT INTO stu(id,cc,fname,lname,grade) VALUES(?,?,?,?,?)");
        p.setInt(1, r.getId());
        p.setString(2, r.getCC());
        p.setString(3, r.getName());
        p.setString(4, r.getSurname());
        p.setDouble(5, r.getGrade());
        p.executeUpdate();
        c.close();
    }

    public void delete(int id) throws Exception {
        Connection c = DBUtil.getConnection();
        PreparedStatement p = c.prepareStatement(
                "DELETE FROM stu WHERE id=?");
        p.setInt(1, id);
        p.executeUpdate();
        c.close();
    }

    public void update(Resume r) throws Exception {
        Connection c = DBUtil.getConnection();

        PreparedStatement p = c.prepareStatement(
                "UPDATE stu SET cc=?, fname=?, lname=?, grade=? WHERE id=?"
        );

        p.setString(1, r.getCC());
        p.setString(2, r.getName());
        p.setString(3, r.getSurname());
        p.setDouble(4, r.getGrade());
        p.setInt(5, r.getId());

        p.executeUpdate();
        c.close();
    }

    public Resume findById(int id) throws Exception {
        Connection c = DBUtil.getConnection();

        PreparedStatement p = c.prepareStatement(
                "SELECT * FROM stu WHERE id=?"
        );

        p.setInt(1, id);

        ResultSet rs = p.executeQuery();

        if (rs.next()) {
            return new Resume(
                    rs.getInt("id"),
                    rs.getString("cc"),
                    rs.getString("fname"),
                    rs.getString("lname"),
                    rs.getDouble("grade")
            );
        }

        c.close();
        return null;
    }
}

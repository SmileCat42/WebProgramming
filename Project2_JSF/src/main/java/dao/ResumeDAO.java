package dao;

import java.sql.*;
import java.util.*;
import model.Resume;
import util.DBUtil;

public class ResumeDAO {

    public List<Resume> findAll() throws Exception {
        List<Resume> list = new ArrayList<>();
        Connection c = DBUtil.getConnection();
        ResultSet rs = c.createStatement()
                .executeQuery("SELECT * FROM Resume");

        while (rs.next()) {
            list.add(new Resume(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getString("surname"),
                    rs.getString("address")));
        }
        c.close();
        return list;
    }

    public Resume findById(int id) throws Exception {
        Connection c = DBUtil.getConnection();
        PreparedStatement p = c.prepareStatement(
                "SELECT * FROM Resume WHERE id=?");
        p.setInt(1, id);
        ResultSet rs = p.executeQuery();

        Resume r = null;
        if (rs.next()) {
            r = new Resume(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getString("surname"),
                    rs.getString("address"));
        }
        c.close();
        return r;
    }

    public void insert(Resume r) throws Exception {
        Connection c = DBUtil.getConnection();
        PreparedStatement p = c.prepareStatement(
                "INSERT INTO Resume(name,surname,address) VALUES(?,?,?)");
        p.setString(1, r.getName());
        p.setString(2, r.getSurname());
        p.setString(3, r.getAddress());
        p.executeUpdate();
        c.close();
    }

    public void update(Resume r) throws Exception {
        Connection c = DBUtil.getConnection();
        PreparedStatement p = c.prepareStatement(
                "UPDATE Resume SET name=?,surname=?,address=? WHERE id=?");
        p.setString(1, r.getName());
        p.setString(2, r.getSurname());
        p.setString(3, r.getAddress());
        p.setInt(4, r.getId());
        p.executeUpdate();
        c.close();
    }

    public void delete(int id) throws Exception {
        Connection c = DBUtil.getConnection();
        PreparedStatement p = c.prepareStatement(
                "DELETE FROM Resume WHERE id=?");
        p.setInt(1, id);
        p.executeUpdate();
        c.close();
    }
}

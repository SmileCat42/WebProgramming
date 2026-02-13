package dao;

import java.sql.*;
import java.util.*;
import model.Course;
import model.Session;
import util.CSDB;

public class CourseDAO {

    public List<Course> getAllCourses() throws Exception {
        List<Course> list = new ArrayList<>();

        // ปรับการนับ (COUNT) ให้เชื่อมจาก enroll -> session -> course
        String sql = """
        SELECT 
                c.course_id, 
                c.course_name, 
                c.course_pic,
                SUM(s.session_max) AS total_max, 
                (SELECT COUNT(*) 
                 FROM enroll e 
                 JOIN session s2 ON e.session_id = s2.session_id 
                 WHERE s2.course_id = c.course_id) AS current_enrolled, 
                GROUP_CONCAT(DISTINCT s.session_date SEPARATOR ', ') AS days,
                GROUP_CONCAT(DISTINCT s.session_time SEPARATOR ', ') AS times
            FROM course c
            LEFT JOIN session s ON c.course_id = s.course_id
            GROUP BY c.course_id, c.course_name, c.course_pic;
        """;

        try (Connection c = CSDB.getConnection(); PreparedStatement p = c.prepareStatement(sql); ResultSet rs = p.executeQuery()) {

            while (rs.next()) {
                Course course = new Course();
                course.setCourseId(rs.getInt("course_id"));
                course.setCourseName(rs.getString("course_name"));
                course.setPicture(rs.getString("course_pic"));
                //ดึงวันที่ที่รวมกันแล้ว (ชื่อคอลัมน์ "days" ตรงกับ GROUP_CONCAT ใน SQL แล้ว)
                String dayStr = rs.getString("days");
                course.setDay(dayStr != null ? dayStr : "N/A");

                // maxseat จริงที่มี มาจากการบวกกันเก็บไว้ที่ตัวแปร สร้างไว้ข้างบน ไม่ใช่เป็นตัวเลข
                course.setMax(rs.getInt("total_max"));

                // ตรงนี้: ใช้ "current_enrolled" ตามชื่อ Alias ของ Subquery
                course.setCurrent(rs.getInt("current_enrolled"));

                // แถม: ถ้าในตาราง session มีคอลัมน์เวลา (เช่น session_time) 
                // คุณควรเพิ่ม GROUP_CONCAT(s.session_time) ใน SQL แล้วมาดึงตรงนี้
                course.setTime(rs.getString("times"));

                list.add(course);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }
        return list;
    }

    public List<Session> getSessionsByCourseId(int courseId) {
        List<Session> sessions = new ArrayList<>();
        String sql = "SELECT * FROM session WHERE course_id = ?";

        try (Connection conn = CSDB.getConnection(); // ใช้ชื่อ Class เชื่อมต่อของคุณ
                 PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, courseId);

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Session s = new Session();
                    s.setSessionId(rs.getInt("session_id"));
                    s.setSessionDate(rs.getString("session_date"));
                    s.setSessionTime(rs.getString("session_time"));
                    sessions.add(s);
                }
            }
            // --- เติมส่วนนี้เข้าไป สีแดงจะหายไปครับ ---
        } catch (Exception e) {
            e.printStackTrace();
        }
        // ---------------------------------------

        return sessions;
    }

    public int countAllCourses() throws Exception {
        int total = 0;
        String sql = "SELECT COUNT(*) AS total FROM course"; // นับจำนวนแถวทั้งหมดในตาราง course

        // ใช้ Try-with-resources เพื่อความปลอดภัยในการปิด Connection
        try (Connection c = CSDB.getConnection(); PreparedStatement p = c.prepareStatement(sql); ResultSet rs = p.executeQuery()) {

            if (rs.next()) {
                // ดึงค่าจากคอลัมน์ชื่อ "total" ที่เรา AS ไว้ใน SQL
                total = rs.getInt("total");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }
        return total;
    }

}

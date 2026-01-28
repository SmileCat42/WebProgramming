package dao;
import java.sql.*;
import java.util.*;
import model.ShowCourse;
import util.CSDB;

public class CourseDAO2 {

    public List<ShowCourse> getAllCourses() throws Exception {
    List<ShowCourse> list = new ArrayList<>();
    
    // ปรับการนับ (COUNT) ให้เชื่อมจาก enroll -> session -> course
    String sql = """
        SELECT 
            c.course_id, 
            c.course_name, 
            c.course_maxseat,
            GROUP_CONCAT(DISTINCT s.session_date SEPARATOR ', ') AS days,
            (SELECT COUNT(*) 
             FROM enroll e 
             JOIN session s2 ON e.session_id = s2.session_id 
             WHERE s2.course_id = c.course_id) AS current_enrolled
        FROM course c
        LEFT JOIN session s ON c.course_id = s.course_id
        GROUP BY c.course_id, c.course_name, c.course_maxseat
        """;

    try (Connection c = CSDB.getConnection();
         PreparedStatement p = c.prepareStatement(sql);
         ResultSet rs = p.executeQuery()) {

        while (rs.next()) {
            ShowCourse course = new ShowCourse();
            course.setId(rs.getInt("course_id"));
            course.setName(rs.getString("course_name"));
            
            // ดึงวันที่ที่รวมกันแล้ว (เช่น SUN, MON) มาใส่ใน setDay
            String dayStr = rs.getString("days");
            course.setDay(dayStr != null ? dayStr : "N/A");
            
            course.setTime("-"); // ถ้ามีคอลัมน์เวลาใน session ค่อยมาเพิ่มตรงนี้ครับ
            
            course.setMax(rs.getInt("course_maxseat"));
            course.setCurrent(rs.getInt("current_enrolled"));
            
            list.add(course);
        }
    } catch (SQLException e) {
        e.printStackTrace();
        throw e;
    }
    return list;
}
}
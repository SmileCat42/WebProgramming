package dao;
import java.sql.*;
import java.util.*;
import model.ShowCourse;
import util.CSDB;

public class CourseDAO {

    public List<ShowCourse> getAllCourses() throws Exception {

        List<ShowCourse> list = new ArrayList<>();
        Connection c = CSDB.getConnection();

        String sql = """
            SELECT
                        c.course_id,
                        c.course_name,
                        GROUP_CONCAT(DISTINCT d.date_day SEPARATOR ', ') AS days,
                        GROUP_CONCAT(DISTINCT d.date_time SEPARATOR ', ') AS times,
                        COUNT(e.enroll_id) AS current,
                        s.seat_max AS max
                    FROM course c
                    LEFT JOIN session s ON c.course_id = s.course_id
                    LEFT JOIN date d ON c.course_id = d.course_id
                    LEFT JOIN enroll e ON s.session_id = e.session_id
                    GROUP BY c.course_id, c.course_name, s.seat_max
                """;

        PreparedStatement p = c.prepareStatement(sql);
        ResultSet rs = p.executeQuery();

        while (rs.next()) {
            System.out.println("7777777777showcard77777777777777777");
            ShowCourse course = new ShowCourse(
                rs.getInt("course_id"),
                rs.getString("course_name"),
                rs.getString("days"),
                rs.getString("times")
                    
            );
            course.setCurrent(rs.getInt("current"));
            course.setMax(rs.getInt("max"));
            list.add(course);
        }

        c.close();
        return list;
    }
}
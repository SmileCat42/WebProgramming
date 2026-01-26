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
                GROUP_CONCAT(d.date_day SEPARATOR ', ') AS days,
                GROUP_CONCAT(d.date_time SEPARATOR ', ') AS times
            FROM course c
            JOIN date d ON c.course_id = d.course_id
            GROUP BY c.course_id, c.course_name
        """;

        PreparedStatement p = c.prepareStatement(sql);
        ResultSet rs = p.executeQuery();

        while (rs.next()) {
            ShowCourse course = new ShowCourse(
                rs.getInt("course_id"),
                rs.getString("course_name"),
                rs.getString("days"),
                rs.getString("times")
            );
            list.add(course);
        }

        c.close();
        return list;
    }
}
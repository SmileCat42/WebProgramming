package controller;

import dao.CourseDAO;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.SessionScoped;
import model.Course;
import jakarta.faces.view.ViewScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Named;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;
import model.Session;
import util.CSDB;

@Named("courseBean")
@SessionScoped
public class CourseBean implements Serializable {

    private List<Course> courseList; // ใช้ ShowCourse ตามที่เขียนใน DAO2
    private CourseDAO dao = new CourseDAO(); // เรียกใช้ DAO ตัวเก่ง
    private Course course = new Course(); //ใช้ตอนจะ add

    // ส่วนที่ขาดไป: Method นี้จะทำงานอัตโนมัติเมื่อเปิดหน้าเว็บ
    @PostConstruct
    public void init() {
        try {
            // ไปดึงข้อมูลมาจาก Database ผ่าน DAO ที่เขียนไว้
            courseList = dao.getAllCourses();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Course> getCourseList() {
        return courseList;
    }

    public String deleteCourse(int id) {
        try {
            // เพิ่ม Logic การลบจริงผ่าน DAO ถ้าทำไว้
            // dao.delete(id); 
            init(); // โหลดข้อมูลใหม่หลังจากลบเสร็จเพื่อให้ตารางอัปเดต
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    //ใช้สำหรับ add
    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }
    
    public void removeSession(Session s) {
    course.getSessions().remove(s);
}
    
     public void addSession() {
        course.getSessions().add(new Session());
    }

    public void saveCourse() {
        System.out.println("SAVE METHOD CALLED !!!!!");
        Connection conn = null;

        try {
            conn = CSDB.getConnection();
            conn.setAutoCommit(false); // 🔥 เริ่ม transaction
            System.out.println("++++++++++++Course name++++++++++: " + course.getCourseName());
            System.out.println("+++++++++++++++Session size+++++++++++: " + course.getSessions().size());
            // 1️⃣ insert course
            String sqlCourse = "INSERT INTO course (course_name, course_price, course_pic) VALUES (?, ?, ?)";

            PreparedStatement ps1 = conn.prepareStatement(
                    sqlCourse,
                    Statement.RETURN_GENERATED_KEYS
            );

            ps1.setString(1, course.getCourseName());
            ps1.setInt(2, 2000);
            ps1.setString(3, "default.png");
            ps1.executeUpdate();

            //เป็นการให้ course สร้าง id ก่อน แล้วจึงส่ง id ไปให้ session บันทึก
            ResultSet rs = ps1.getGeneratedKeys();
            int generatedId = 0;
            if (rs.next()) {
                generatedId = rs.getInt(1);
            }

            String sqlSession = "INSERT INTO session (course_id, session_date, session_max, session_time) VALUES (?, ?, ?, ?)";
            PreparedStatement ps2 = conn.prepareStatement(sqlSession);
            System.out.println("+++++++++++++Session size+++++++++++++ = " + course.getSessions().size());
            System.out.println("********************Generated ID = " + generatedId);
            for (Session s : course.getSessions()) {

                ps2.setInt(1, generatedId);      // course_id
                ps2.setString(2, s.getSessionDate());    // day
                ps2.setInt(3, s.getMax());       // max seat
                ps2.setString(4, s.getSessionTime());   // time

                ps2.executeUpdate();
            }

            conn.commit(); // ✅ สำเร็จ commit
            courseList = dao.getAllCourses();
            
            FacesContext.getCurrentInstance()
                    .addMessage(null,
                            new FacesMessage("Course added successfully"));

        } catch (Exception e) {
            try {
                if (conn != null) {
                    conn.rollback(); // ❌ fail rollback
                }
            } catch (Exception ex) {
            }

            FacesContext.getCurrentInstance()
                    .addMessage(null,
                            new FacesMessage(FacesMessage.SEVERITY_ERROR,
                                    "Error saving course", null));
        }
    }
}

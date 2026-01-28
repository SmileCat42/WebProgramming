package controller;
import dao.CourseDAO2;
import model.ShowCourse;
import model.Student;
import java.util.List;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/course")
public class CourseController2 extends HttpServlet {

    protected void doGet(HttpServletRequest r, HttpServletResponse s)
    throws ServletException, IOException {
        try {
            CourseDAO2 dao = new CourseDAO2();
            List<ShowCourse> courses = dao.getAllCourses();
            r.setAttribute("courses", courses);

            HttpSession session = r.getSession(false);
            Student user = (session != null) ? (Student) session.getAttribute("user") : null;

            if (user == null) {
                r.getRequestDispatcher("/course_G.jsp").forward(r, s);
            } else {
                r.getRequestDispatcher("/course_M.jsp").forward(r, s);
            }

        } catch (Exception ex) {
            // สำคัญมาก: ถ้าหน้าขาว ให้มาดู Error ที่ Console ของโปรแกรมเขียนโค้ด
            ex.printStackTrace(); 
            // หรือส่งไปหน้าแจ้งเตือน Error
            s.getWriter().println("เกิดข้อผิดพลาดในการเชื่อมต่อฐานข้อมูล: " + ex.getMessage());
        }
    }
}
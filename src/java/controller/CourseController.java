package controller;
import dao.CourseDAO;
import model.ShowCourse;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/course")
public class CourseController extends HttpServlet {

    protected void doGet(HttpServletRequest r, HttpServletResponse s)
    throws ServletException, IOException {

        try {
            CourseDAO dao = new CourseDAO();
            List<ShowCourse> courses = dao.getAllCourses();

            r.setAttribute("courses", courses);
            r.getRequestDispatcher("/course_M.jsp").forward(r, s);

        } catch (Exception e) {
            throw new ServletException(e);
        }
    }
}
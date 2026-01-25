package controller;
import dao.StudentDAO;
import model.Student;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/course")
public class CourseController extends HttpServlet {

    protected void doGet(HttpServletRequest r, HttpServletResponse s)
    throws ServletException, IOException {

        r.getRequestDispatcher("/course_M.jsp")
         .forward(r, s);
    }
}
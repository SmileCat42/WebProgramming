package controller;

import dao.ReservDAO;
import model.Student;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;

@WebServlet("/ReservController")
public class ReservController extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        response.setContentType("text/plain"); // ส่งกลับเป็นข้อความธรรมดาให้ AJAX
        
        HttpSession session = request.getSession(false);
        Student student = (Student) session.getAttribute("user");
        
        // รับค่า courseId ที่ส่งมาจาก AJAX
        String courseIdParam = request.getParameter("courseId");
        
        if (student != null && courseIdParam != null) {
            int studentId = student.getId();
            int courseId = Integer.parseInt(courseIdParam);
            
            // เรียกใช้ DAO
            ReservDAO dao = new ReservDAO();
            String result = dao.insertBooking(studentId, courseId);
            
            // ส่งผลลัพธ์กลับไปให้ AJAX (Success, Full, หรือ Fail)
            response.getWriter().write(result);
        } else {
            response.getWriter().write("AuthError");
        }
    }
}
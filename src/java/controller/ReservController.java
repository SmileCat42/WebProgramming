package controller;

import dao.ReservDAO;
import model.Student;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;

@WebServlet("/ReservController")
public class ReservController extends HttpServlet {

    // เปลี่ยนเป็น doGet เพื่อให้รองรับ fetch แบบปกติจาก JS
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        response.setContentType("text/plain");
        response.setCharacterEncoding("UTF-8");
        
        HttpSession session = request.getSession(false);
        Student student = (session != null) ? (Student) session.getAttribute("user") : null; //ดึงข้อมูลจาก session ที่ฝังลงไป
        
        // รับค่า sessionId (ที่ส่งมาจาก fetch('ReservController?sessionId=' + id))
        String sessionIdParam = request.getParameter("sessionId");
        
        if (student != null && sessionIdParam != null) {
            try {
                int studentId = student.getId(); // จัดเก็บเลข id ไว้ที่ตัวแปรใหม่
                int sessionId = Integer.parseInt(sessionIdParam); //เก็บ id session ที่มาจาก
                
                ReservDAO dao = new ReservDAO();
                // เรียกใช้ DAO ที่เราทำ Transaction ไว้
                String result = dao.insertBooking(studentId, sessionId);
                
                response.getWriter().write(result);
            } catch (Exception e) {
                response.getWriter().write("Error: " + e.getMessage());
            }
        } else {
            response.getWriter().write("AuthError");
        }
    }
}
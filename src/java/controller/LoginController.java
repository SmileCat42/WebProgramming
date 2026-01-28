package controller;
import dao.LoginDAO;
import model.Student;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/login")
public class LoginController extends HttpServlet {

    protected void doGet(HttpServletRequest r, HttpServletResponse s)
            throws ServletException, IOException {
        System.out.println("777777login777777777777777777777777777777777777");
        // เข้ามาครั้งแรก → แสดงหน้า login
        r.getRequestDispatcher("/Login.html").forward(r, s);
    }

    protected void doPost(HttpServletRequest r, HttpServletResponse s)
            throws ServletException, IOException {
        System.out.println("777777login777777777777777777777777777777777777");
        String user = r.getParameter("uname");
        String pass = r.getParameter("pass");

        try {
            LoginDAO dao = new LoginDAO();
            Student st = dao.login(user, pass);

            if (st != null) {
                HttpSession session = r.getSession();
                session.setAttribute("user", st);
                s.sendRedirect("course");
            } else {
                r.setAttribute("error", "Username หรือ Password ไม่ถูกต้อง");
                r.getRequestDispatcher("/Login.html").forward(r, s);
            }

        } catch (Exception e) {
            throw new ServletException(e);
        }
    }
}
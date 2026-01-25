package controller;
import dao.ResumeDAO;
import model.Resume;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/home")
public class HomeController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest r, HttpServletResponse s)
            throws ServletException, IOException {

        HttpSession session = r.getSession(false);

        // === GUEST ===
        if (session == null || session.getAttribute("student") == null) {
            r.getRequestDispatcher("FrontPageF_G.html")
             .forward(r, s);
            return;
        }

        // === MEMBER ===
        r.getRequestDispatcher("FrontPageF_M.html")
         .forward(r, s);
    }
}
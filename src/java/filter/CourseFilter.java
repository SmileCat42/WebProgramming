package filter;
import controller.*;
import dao.StudentDAO;
import model.Student;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;

@WebFilter("/course")
public class CourseFilter implements Filter {

    public void doFilter(ServletRequest req, ServletResponse res,
                         FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest r = (HttpServletRequest) req;
        HttpServletResponse s = (HttpServletResponse) res;

        HttpSession session = r.getSession(false);

        if (session == null || session.getAttribute("user") == null) {
            s.sendRedirect("/login"); // หรือ course_guest
            return;
        }
        chain.doFilter(req, res);
    }
}
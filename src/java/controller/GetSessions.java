package controller;

import dao.SessionDAO;
import model.Student;
import model.Session;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/GetSessions")
public class GetSessions extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        
        int courseId = Integer.parseInt(request.getParameter("courseId"));
        SessionDAO dao = new SessionDAO();
        List<Session> sessions = dao.getSessionsByCourse(courseId);
        
        // แปลง List เป็น JSON (แบบ Manual ถ้าไม่มี Library GSON)
        StringBuilder json = new StringBuilder("[");
        for (int i = 0; i < sessions.size(); i++) {
            Session s = sessions.get(i);
            json.append(String.format(
                "{\"sessionId\":%d, \"sessionDate\":\"%s\", \"sessionTime\":\"%s\"}",
                s.getSessionId(), s.getSessionDate(), s.getSessionTime()
            ));
            if (i < sessions.size() - 1) json.append(",");
        }
        json.append("]");
        
        response.getWriter().write(json.toString());
    }
}
package controller;
import dao.ResumeDAO;
import model.Resume;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/resume")
public class ResumeController extends HttpServlet {
    ResumeDAO dao=new ResumeDAO();

    protected void doGet(HttpServletRequest r,HttpServletResponse s)
    throws ServletException,IOException{
        try{
            if("delete".equals(r.getParameter("action"))){
                dao.delete(Integer.parseInt(r.getParameter("id")));
                s.sendRedirect("resume");
                return;
            }
            r.setAttribute("list", dao.findAll());
            r.getRequestDispatcher("/WEB-INF/jsp/list.jsp")
             .forward(r,s);
        }catch(Exception e){throw new ServletException(e);}
    }

    protected void doPost(HttpServletRequest r,HttpServletResponse s)
    throws ServletException,IOException{ 
        try{
            Resume x=new Resume();
            x.setName(r.getParameter("name"));
            x.setSurname(r.getParameter("surname"));
            x.setAddress(r.getParameter("address"));
            dao.insert(x);
            s.sendRedirect("resume");
        }catch(Exception e){throw new ServletException(e);}
    }
}
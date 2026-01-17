package controller;
import dao.ResumeDAO;
import model.Resume;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/mvc")
public class ResumeController extends HttpServlet {
    ResumeDAO dao=new ResumeDAO();
    
    protected void doGet(HttpServletRequest r,HttpServletResponse s)
    throws ServletException,IOException{
        System.out.println("444444444444444444");
        try{
            if("delete".equals(r.getParameter("action"))){
                dao.delete(Integer.parseInt(r.getParameter("id")));
                s.sendRedirect("mvc");
                return;
            }
            r.setAttribute("list", dao.findAll());
            r.getRequestDispatcher("/Chapter8_MVC/DataBase.jsp")
             .forward(r,s);
        }catch(Exception e){throw new ServletException(e);}
    }
    
    

    protected void doPost(HttpServletRequest r,HttpServletResponse s)
    throws ServletException,IOException{ 
        try{
            Resume x=new Resume();
            x.setCC(r.getParameter("gender"));
            x.setName(r.getParameter("fname"));
            x.setSurname(r.getParameter("lname"));
            x.setGrade(Double.parseDouble(r.getParameter("grade")));
            dao.insert(x);
            s.sendRedirect("mvc");
        }catch(Exception e){throw new ServletException(e);}
    }
}
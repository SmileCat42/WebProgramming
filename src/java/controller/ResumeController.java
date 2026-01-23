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
        r.setCharacterEncoding("UTF-8");
        try{
            System.out.println("3333333333333333333333");
            if ("delete".equals(r.getParameter("action")) && r.getParameter("id") == null) {
            r.setAttribute("list", dao.findAll());
            r.getRequestDispatcher("/Chapter8_MVC/ShowDel.jsp")
             .forward(r, s);
            return;
        }
            
            if("delete".equals(r.getParameter("action")) && r.getParameter("id") != null){
                System.out.println("5555555555555555555555555555555");
                dao.delete(Integer.parseInt(r.getParameter("id")));
                s.sendRedirect("/JSPHtml/mvc");
                return;
            }
            r.setAttribute("list", dao.findAll());
            r.getRequestDispatcher("/Chapter8_MVC/DataBase.jsp")
             .forward(r,s);
        }catch(Exception e){throw new ServletException(e);}
    }
    /* สาเหตุที่ต้องมี delete 2 อัน เพราะ เราไม่สามารถเข้าถึงตารางโชว์ ShowDel โดยตรงได้ ต้องเปิดผ่าน controller ซึ่ง เราได้ตั้งค่าหน้าหลักไปแล้วว่า
    ถ้าเปิดโปรเจคขึ้นมาครั้งแรกให้โชว์ตารางหลักก่อนซึ่งไม่ใช่อันนี้ (DataBase.jsp) ดังนั้น การเปิดหน้าไฟล์ครั้งแรกของตารางลบ ก็จำเป็นต้องมีด้วยเช่นกัน
    จึงต้องสร้างเงื่อนไขว่า ถ้ามีการกดลิ้งค์เข้ามาด้วยคีย์เวิดคำว่า delete แต่ไม่เจอ id นั่นหมายความว่าเข้ามาครั้งแรก ให้ส่งกลับไปหน้า ShowDel แบบดึงข้อมูล
    จาก DB ได้เลย แต่ถ้ามี id ติดมาด้วยนั่นหมายความว่า ส่งมาจากหน้าตารางที่ผู้ใช้กดลบเข้ามา ถึงจะทำฟังก์ชั่น DAO del*/
    

    protected void doPost(HttpServletRequest r,HttpServletResponse s)
    throws ServletException,IOException{ 
        r.setCharacterEncoding("UTF-8");
        try{
            System.out.println("444444444444444444444");
            Resume x=new Resume();
            x.setId(Integer.parseInt(r.getParameter("id")));
            x.setCC(r.getParameter("gender"));
            x.setName(r.getParameter("fname"));
            x.setSurname(r.getParameter("lname"));
            x.setGrade(Double.parseDouble(r.getParameter("grade")));
            dao.insert(x);
            s.sendRedirect("mvc");
        }catch(Exception e){throw new ServletException(e);}
    }
}
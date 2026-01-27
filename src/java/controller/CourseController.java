package controller;
import dao.CourseDAO;
import model.ShowCourse;
import model.Student;
import java.util.List;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/course")
public class CourseController extends HttpServlet {

    protected void doGet(HttpServletRequest r, HttpServletResponse s)
    throws ServletException, IOException {

        try {
            CourseDAO dao = new CourseDAO();
            List<ShowCourse> courses = dao.getAllCourses();
            r.setAttribute("courses", courses);
            
            HttpSession session = r.getSession(false); //ดึงข้อมูลจาก session ตอน login อ่ะ ใส่false เพื่อกันกรณีที่ session ไม่มีข้อมูล (user ยังไม่ login)
        Student user = null; //สร้าง user ขึ้นมา ก่อนเปล่าๆ ยังยัดข้อมูลเลยไม่ได้ ต้องไปเช็คก่อนว่า session ว่างไหม

        if (session != null) {
            user = (Student) session.getAttribute("user"); //พอไม่ว่างค่อยยัดลงบน user เห้ออ เหนื่อยยยยย555
        }
            
            if (user == null) { 
                // guest
                r.getRequestDispatcher("/course_G.jsp").forward(r, s);
            } else { //หมายความว่า session มีข้อมูลแล้ว มีคน login แล้ว ปล่อยให้ไปหน้า member ได้
                // member
                r.getRequestDispatcher("/course_M.jsp").forward(r, s);
            }
        } catch (Exception ex) {
            System.getLogger(CourseController.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
    }
}
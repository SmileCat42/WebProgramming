package controller;

import dao.StudentDAO;
import dao.CourseDAO;
import dao.EnrollmentDAO;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.RequestScoped;
import model.Student;
import jakarta.faces.view.ViewScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Named;

import java.io.Serializable;
import java.util.List;

@Named(value = "dashboardBean")
@RequestScoped // ใช้ RequestScoped เพราะข้อมูลสถิติต้องการการอัปเดตทุกครั้งที่เข้าหน้าจอ
public class DashboardBean {
    
    private int totalStudents;
    private int totalCourses;
    private int totalEnroll;

    @PostConstruct
    public void init() {
        try {
            StudentDAO sdao = new StudentDAO();
            totalStudents = sdao.countAllStudents();
            
            CourseDAO cDao = new CourseDAO();
            totalCourses = cDao.countAllCourses();
            
            EnrollmentDAO eDao = new EnrollmentDAO();
            totalEnroll = eDao.countAllEnroll();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Getter & Setter
    public int getTotalStudents() { return totalStudents; }
    public int getTotalCourses() { return totalCourses; }
    public int getTotalEnroll() { return totalEnroll; }
}
package controller;

import dao.CourseDAO;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.SessionScoped;
import model.Course;
import jakarta.faces.view.ViewScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Named;

import java.io.Serializable;
import java.util.List;

@Named("courseBean")
@SessionScoped 
public class CourseBean implements Serializable {
    
    private List<Course> courseList; // ใช้ ShowCourse ตามที่คุณเขียนใน DAO2
    private CourseDAO dao = new CourseDAO(); // เรียกใช้ DAO ตัวเก่งของคุณ

    // ส่วนที่ขาดไป: Method นี้จะทำงานอัตโนมัติเมื่อเปิดหน้าเว็บ
    @PostConstruct
    public void init() {
        try {
            // ไปดึงข้อมูลมาจาก Database ผ่าน DAO ที่คุณเขียนไว้
            courseList = dao.getAllCourses(); 
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Course> getCourseList() {
        return courseList;
    }

    public String deleteCourse(int id) {
        try {
            // เพิ่ม Logic การลบจริงผ่าน DAO ถ้าคุณทำไว้
            // dao.delete(id); 
            init(); // โหลดข้อมูลใหม่หลังจากลบเสร็จเพื่อให้ตารางอัปเดต
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null; 
    }
}
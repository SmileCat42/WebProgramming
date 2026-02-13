package controller;

import jakarta.annotation.Resource;
import jakarta.enterprise.context.RequestScoped;
import model.Course;
import model.Session;
import jakarta.inject.Named;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.UserTransaction;

import java.io.Serializable;

@Named
@RequestScoped
public class CourseBean2 implements Serializable {
    
    @PersistenceContext(unitName = "coursePer") // ดูชื่อได้ในไฟล์ persistence.xml
    private EntityManager em;
    
    @Resource
    private UserTransaction utx; // ใช้สำหรับจัดการ Transaction (การยืนยันการบันทึก)

    private Course course = new Course();       // สำหรับตาราง Course
    private Session newSession = new Session(); // สำหรับตาราง Session

    // Getters and Setters
    public Course getCourse() { return course; }
    public void setCourse(Course course) { this.course = course; }
    public Session getNewSession() { return newSession; }
    public void setNewSession(Session newSession) { this.newSession = newSession; }

    public String saveCourseWithSession() {
    try {
        // บันทึกวิชาลงตาราง course
        em.persist(course); 
        
        // ผูก ID ของวิชาเข้ากับ session แล้วบันทึก
        newSession.setSessionId(course.getCourseId());
        em.persist(newSession);
        
        // หากไม่ได้ตั้งค่าอัตโนมัติ ต้องสั่ง flush ด้วย
        em.flush(); 
        utx.commit();
        
        return "list.xhtml?faces-redirect=true";
    } catch (Exception e) {
        return null;
    }
}
}
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import jakarta.persistence.*; // ใช้ * เพื่อรวบ Entity, Table, Id ฯลฯ
import java.io.Serializable;

@Entity
@Table(name = "course") // ระบุชื่อตารางในฐานข้อมูล comsci
public class CoursePer implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // ใช้ IDENTITY เพื่อให้ตรงกับ Auto Increment ใน MySQL
    private int courseId;

    private String courseName; // ตัวแปรสำหรับเก็บชื่อวิชา

    // Getter และ Setter (สำคัญมากเพื่อให้ JSF ดึงข้อมูลไปแสดงได้)
    public int getCourseId() { return courseId; }
    public void setCourseId(int courseId) { this.courseId = courseId; }

    public String getCourseName() { return courseName; }
    public void setCourseName(String courseName) { this.courseName = courseName; }

    @Override
    public int hashCode() {
        return Integer.hashCode(courseId);
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Course)) return false;
        Course other = (Course) object;
        return this.courseId == other.getCourseId();
    }

    @Override
    public String toString() {
        return "model.Course[ id=" + courseId + " ]";
    }
}
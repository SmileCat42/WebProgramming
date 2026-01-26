/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author 66944
 */
public class ShowCourse{
   private int courseId;
    private String courseName;
    private String days;   // Mon, Wed
    private String times;  // 09:00-12:00

    public ShowCourse(int courseId, String courseName, String days, String times){
        this.courseId = courseId;
        this.courseName = courseName;
        this.days = days;
        this.times = times;
    }

    // getter
    public int getCourseId() { return courseId; }
    public String getCourseName() { return courseName; }
    public String getDays() { return days; }
    public String getTimes() { return times; }
}
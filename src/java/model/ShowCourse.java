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
    private String days;  
    private String times;  
    private int current;
    private int max;
    private String picture;
    
    public ShowCourse(){}
    public ShowCourse(int courseId, String courseName, String days, String times){
        this.courseId = courseId;
        this.courseName = courseName;
        this.days = days;
        this.times = times;
    }
public void setId(int a) { courseId=a; }
public void setName(String a) { courseName=a; }
public void setDay(String a) { days=a; }
public void setTime(String a) { times=a; }
    public void setCurrent(int a) { current=a; }
    public void setMax(int a) { max=a; }
    public void setPicture(String a){picture=a;}
    // getter
    public int getCourseId() { return courseId; }
    public String getCourseName() { return courseName; }
    public String getDays() { return days; }
    public String getTimes() { return times; }
    public int getCurrent() { return current; }
    public int getMax() { return max; }
    public String getPicture(){return picture;}
}
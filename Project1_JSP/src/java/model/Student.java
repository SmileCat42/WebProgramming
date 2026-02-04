/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author 66944
 */
public class Student {

    private int id;
    private String fname, lname, user, pass, email;

    public Student() {
    }

    public Student(int a, String b, String c, String d, String e, String f) {
        this.id = a;
        this.fname=b;
        this.lname = c;
        this.user = d; 
        this.pass=e;
        this.email=f;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFname() {
        return fname;
    }
    
    public String getLname() {
        return lname;
    }
    
    public String getPass() {
        return pass;
    }
    
    public String getUser() {
        return user;
    }
    
    public String getEmail() {
        return email;
    }

    public void setFname(String n) {
        this.fname = n;
    }

    public void setLname(String s) {
        this.lname = s;
    }

    public void setUser(String a) {
        this.user = a;
    }
    
    public void setPass(String a){
        this.pass=a;
    }
    
     public void setEmail(String a){
        this.email=a;
    }
}

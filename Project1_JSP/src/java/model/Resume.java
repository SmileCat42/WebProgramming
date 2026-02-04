/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author 66944
 */
public class Resume {

    private int id;
    private String name, surname, cc;
    private double grade;

    public Resume() {
    }

    public Resume(int id, String c, String n, String s,double b) {
        this.id = id;
        this.cc=c;
        this.name = n;
        this.surname = s; 
        this.grade=b;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    
    public double getGrade() {
        return grade;
    }

    public void setName(String n) {
        this.name = n;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String s) {
        this.surname = s;
    }

    public String getCC() {
        return cc;
    }

    public void setCC(String a) {
        this.cc = a;
    }
    
    public void setGrade(double a){
        this.grade=a;
    }
}

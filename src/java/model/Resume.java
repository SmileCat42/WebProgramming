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
    private String name, surname, address;

    public Resume() {
    }

    public Resume(int id, String n, String s, String a) {
        this.id = id;
        this.name = n;
        this.surname = s;
        this.address = a;
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

    public void setName(String n) {
        this.name = n;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String s) {
        this.surname = s;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String a) {
        this.address = a;
    }
}

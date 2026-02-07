package model;

public class Resume {

    private int id;
    private String name, surname, address;

    public Resume() {}

    public Resume(int id, String n, String s, String a) {
        this.id = id;
        this.name = n;
        this.surname = s;
        this.address = a;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String n) { this.name = n; }

    public String getSurname() { return surname; }
    public void setSurname(String s) { this.surname = s; }

    public String getAddress() { return address; }
    public void setAddress(String a) { this.address = a; }
}

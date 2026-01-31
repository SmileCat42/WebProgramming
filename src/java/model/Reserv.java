package model;

import java.io.Serializable;
import java.sql.Timestamp;

public class Reserv implements Serializable {
    private int enrollId;
    private int studentId;
    private int sessionId;
    private Timestamp enrollDate;

    // Constructors
    public Reserv() {}

    // Getters and Setters
    public int getEnrollId() { return enrollId; }
    public void setEnrollId(int enrollId) { this.enrollId = enrollId; }

    public int getStudentId() { return studentId; }
    public void setStudentId(int studentId) { this.studentId = studentId; }

    public int getSessionId() { return sessionId; }
    public void setSessionId(int sessionId) { this.sessionId = sessionId; }
}
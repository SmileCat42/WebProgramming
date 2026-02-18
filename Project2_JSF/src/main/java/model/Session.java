package model;

import java.io.Serializable;
import java.sql.Timestamp;

public class Session implements Serializable {
    private int sessionid;
    private String date;
    private String time;
    private int max;

    // Constructors
    public Session() {}

    // Getters and Setters
    public int getSessionId() { return sessionid; }
    public void setSessionId(int a) { this.sessionid = a; }

    public String getSessionDate() { return date; }
    public void setSessionDate(String b) { this.date = b; }

    public String getSessionTime() { return time; }
    public void setSessionTime(String c) { this.time = c; }
    
    public int getMax() { return max; }
    public void setMax(int a) { this.max = a; }
}
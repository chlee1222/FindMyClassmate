package com.example.findmyclassmate;

public class Course {
    private String cName;
    private String section;
    private String session;
    private int size;
    private int registered;
    private String time;
    private String days;
    private String location;
    private String professor;
    private String creditType;
    // need to include rating >>

    public Course(String cName, String section, String session, int size, int registered, String time, String days, String location, String professor, String creditType) {
        this.cName = cName;
        this.section = section;
        this.session = session;
        this.size = size;
        this.registered = registered;
        this.time = time;
        this.days = days;
        this.location = location;
        this.professor = professor;
        this.creditType = creditType;
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public String getSession() {
        return session;
    }

    public void setSession(String session) {
        this.session = session;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getRegistered() {
        return registered;
    }

    public void setRegistered(int registered) {
        this.registered = registered;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDays() {
        return days;
    }

    public void setDays(String days) {
        this.days = days;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getProfessor() {
        return professor;
    }

    public void setProfessor(String professor) {
        this.professor = professor;
    }

    public String getCreditType() {
        return creditType;
    }

    public void setCreditType(String creditType) {
        this.creditType = creditType;
    }
}

package com.example.findmyclassmate;

public class RegisteredCourse {
    private String cName;
    private String credit;
    private String days;
    private String location;
    private String professor;
    private int registered;
    private String section;
    private String session;
    private int size;
    private String time;
    private String type;

    // Default constructor required for Firebase
    public RegisteredCourse() {
    }

    public RegisteredCourse(String cName, String credit, String days, String location, String professor,
                            int registered, String section, String session, int size, String time, String type) {
        this.cName = cName;
        this.credit = credit;
        this.days = days;
        this.location = location;
        this.professor = professor;
        this.registered = registered;
        this.section = section;
        this.session = session;
        this.size = size;
        this.time = time;
        this.type = type;
    }

    public String getcName() {
        return cName;
    }

    public String getCredit() {
        return credit;
    }

    public String getDays() {
        return days;
    }

    public String getLocation() {
        return location;
    }

    public String getProfessor() {
        return professor;
    }

    public int getRegistered() {
        return registered;
    }

    public String getSection() {
        return section;
    }

    public String getSession() {
        return session;
    }

    public int getSize() {
        return size;
    }

    public String getTime() {
        return time;
    }

    public String getType() {
        return type;
    }
}


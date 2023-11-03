package com.example.findmyclassmate;

import java.util.ArrayList;
import java.util.List;

public class Department {
    private String name;
    private List<Course> courses;

    public Department(String name, List<Course> marketingDepartmentCourses) {
        this.name = name;
        this.courses = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    public void addCourse(Course course) {
        courses.add(course);
    }
}

package com.example.findmyclassmate;

import android.content.Context;
import android.widget.ArrayAdapter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Department implements Serializable {
    private String name;
    private List<Course> courses;

    public Department(String name, List<Course> Courses) {
        this.name = name;
        this.courses = Courses ;
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

    public String toString() {
        return name; // Return the department name for display in the Spinner
    }

}


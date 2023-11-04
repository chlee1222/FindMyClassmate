package com.example.findmyclassmate;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class School implements Serializable {
    private String name;
    private List<Department> departments;

    public School(String name, List<Department> Departments) {
        this.name = name;
        this.departments = Departments;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Department> getDepartments() {
        return departments;
    }

    public void setDepartments(List<Department> departments) {
        this.departments = departments;
    }

    public void addDepartment(Department department) {
        departments.add(department);
    }

    @Override
    public String toString() {
        return name; // Return the school name to be displayed in the Spinner
    }
}

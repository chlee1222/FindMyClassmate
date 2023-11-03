package com.example.findmyclassmate;

import java.util.ArrayList;
import java.util.List;

public class School {
    private String name;
    private List<Department> departments;

    public School(String name, List<Department> businessDepartments) {
        this.name = name;
        this.departments = new ArrayList<>();
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
}

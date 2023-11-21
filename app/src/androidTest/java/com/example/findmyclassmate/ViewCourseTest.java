package com.example.findmyclassmate;

import org.junit.Test;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ViewCourseTest {

    @Test
    public void testCourseCreation() {
        Course course = new Course("Test Course", "COURSE101", "Fall 2023", 30, 10, "9:00 AM - 10:30 AM", "MWF", "Room 101", "Prof. Test", "Elective", "4.0");
        assertEquals("Course name should match", "Test Course", course.getcName());
        assertEquals("Course section should match", "COURSE101", course.getSection());
        // Additional assertions for other fields
    }

    @Test
    public void testDepartmentInitialization() {
        List<Course> courses = new ArrayList<>();
        courses.add(new Course("Course1", "CODE1", "Term1", 30, 15, "Time1", "Days1", "Room1", "Prof1", "Type1", "4.0"));
        Department department = new Department("Test Department", courses);
        assertEquals("Department name should match", "Test Department", department.getName());
        assertFalse("Courses list should not be empty", department.getCourses().isEmpty());
    }

    @Test
    public void testSchoolInitialization() {
        List<Department> departments = new ArrayList<>();
        departments.add(new Department("Test Department", new ArrayList<>()));
        School school = new School("Test School", departments);
        assertEquals("School name should match", "Test School", school.getName());
        assertFalse("Departments list should not be empty", school.getDepartments().isEmpty());
    }

    // Additional tests for other aspects of the ViewCourse class
}
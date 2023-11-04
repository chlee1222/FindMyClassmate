package com.example.findmyclassmate;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

public class ViewCourse extends AppCompatActivity {
    Spinner schoolSpinner, departmentSpinner, courseSpinner;
    ArrayAdapter<School> schoolAdapter;
    ArrayAdapter<Course> courseAdapter;
    DepartmentArrayAdapter departmentAdapter;
    List<School> schoolArray;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_course);
        // Inside the onItemSelected method
        Log.d("ViewCourse", "test");
        // Hard code instances of Course
        Course course1 = new Course("Digital Marketing", "MKT101", "Fall 2023", 30, 10, "9:00 AM - 10:30 AM", "Mon, Wed, Fri", "Room 101", "Prof. Smith", "Elective");
        Course course2 = new Course("Social Media Strategy", "MKT102", "Fall 2023", 25, 15, "11:00 AM - 12:30 PM", "Tue, Thu", "Room 102", "Prof. Johnson", "Elective");
        Course course3 = new Course("Market Research and Analysis", "MKT103", "Fall 2023", 35, 20, "2:00 PM - 3:30 PM", "Mon, Wed", "Room 103", "Prof. Davis", "Core");
        Course course4 = new Course("Consumer Behavior", "MKT104", "Fall 2023", 30, 10, "4:00 PM - 5:30 PM", "Tue, Thu", "Room 104", "Prof. Wilson", "Elective");
        Course course5 = new Course("Advertising and Promotion", "MKT105", "Fall 2023", 30, 20, "10:00 AM - 11:30 AM", "Mon, Wed", "Room 105", "Prof. Brown", "Core");
        Course course6 = new Course("Marketing Management", "MKT106", "Fall 2023", 40, 25, "1:00 PM - 2:30 PM", "Tue, Thu", "Room 106", "Prof. Lee", "Core");

        // Create a list of Course objects for the Marketing Department
        List<Course> marketingDepartmentCourses = new ArrayList<>();
        marketingDepartmentCourses.add(course1);
        marketingDepartmentCourses.add(course2);
        marketingDepartmentCourses.add(course3);
        marketingDepartmentCourses.add(course4);
        marketingDepartmentCourses.add(course5);
        marketingDepartmentCourses.add(course6);

        // Create the Marketing Department
        Department marketingDepartment = new Department("Marketing Department", marketingDepartmentCourses);

        // Create a list of Department objects for the School of Business
        List<Department> businessDepartments = new ArrayList<>();
        businessDepartments.add(marketingDepartment);
        Log.d("ViewCourse", businessDepartments.get(0).getName());

        // Create the School of Business
        School schoolOfBusiness = new School("School of Business", businessDepartments);
        School schoolOfEngineering = new School("School of Engineering", businessDepartments);
        // Create a list of School objects and add the School of Business
        schoolArray = new ArrayList<>();
        schoolArray.add(schoolOfBusiness);
        schoolArray.add(schoolOfEngineering);
        // Initialize the spinners
        schoolSpinner = findViewById(R.id.schoolSpinner);
        departmentSpinner = findViewById(R.id.departmentSpinner);
        courseSpinner = findViewById(R.id.courseSpinner);

        // Create an adapter for the School Spinner
        schoolAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, schoolArray);
        schoolAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        schoolSpinner.setAdapter(schoolAdapter);

        // Create an adapter for the Department Spinner
        departmentAdapter = new DepartmentArrayAdapter(this, R.layout.spinner_dropdown_item, new ArrayList<Department>());
        departmentAdapter.setDropDownViewResource(R.layout.spinner_dropdown_item);
        departmentSpinner.setAdapter(departmentAdapter);

        // Create an adapter for the Course Spinner
        courseAdapter = new ArrayAdapter<Course>(this, R.layout.spinner_item, new ArrayList<Course>());
        courseAdapter.setDropDownViewResource(R.layout.spinner_item);
        courseSpinner.setAdapter(courseAdapter);

        // Set listeners for Spinner selection events
        schoolSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {

                // Handle the selection of a school
                School selectedSchool = schoolArray.get(position);
// Inside the onItemSelected method
                Log.d("ViewCourse", "Selected School: " + selectedSchool.getName());
                Log.d("ViewCourse", "Departments: " + selectedSchool.getDepartments().get(0).getName());

                // Clear and populate the departmentSpinner with the departments of the selected school
                departmentAdapter.clear();
                departmentAdapter.addAll(selectedSchool.getDepartments());

                // Initialize the courseSpinner with the courses of the first department of the selected school
                if (!selectedSchool.getDepartments().isEmpty()) {
                    departmentSpinner.setSelection(0); // Select the first department by default
                    Department firstDepartment = selectedSchool.getDepartments().get(0);
                    courseAdapter.clear();
                    courseAdapter.addAll(firstDepartment.getCourses());
                    departmentAdapter.notifyDataSetChanged();
                } else {
                    // Handle the case where there are no departments
                    courseAdapter.clear();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // Do nothing here
            }
        });
    }
}
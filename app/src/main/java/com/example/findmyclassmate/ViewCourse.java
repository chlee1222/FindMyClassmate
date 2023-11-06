package com.example.findmyclassmate;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import com.example.findmyclassmate.R;

public class ViewCourse extends AppCompatActivity {
    Spinner schoolSpinner, departmentSpinner, courseSpinner;
    ArrayAdapter<School> schoolAdapter;
    ArrayAdapter<Course> courseAdapter;
    DepartmentArrayAdapter departmentAdapter;
    List<School> schoolArray;
    ConstraintLayout courseDetailsLayout;
    TextView courseSection, courseSession, courseType, courseRegister, courseTime;
    TextView courseLocation, courseInstructor, courseRating, courseCredit, courseDays;
    Button addButton, reviewButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_course);


        // Inside the onItemSelected method
        Log.d("ViewCourse", "test");
        // Hard code instances of Course
        Course course1 = new Course("Digital Marketing", "MKT101", "Fall 2023", 30, 10, "9:00 AM - 10:30 AM", "MWF", "Room 101", "Prof. Smith", "Elective", "4.0");
        Course course2 = new Course("Social Media Strategy", "MKT102", "Fall 2023", 25, 15, "11:00 AM - 12:30 PM", "TTh", "Room 102", "Prof. Johnson", "Elective","4.0");
        Course course3 = new Course("Market Research and Analysis", "MKT103", "Fall 2023", 35, 20, "2:00 PM - 3:30 PM", "MW", "Room 103", "Prof. Davis", "Core","4.0");
        Course course4 = new Course("Consumer Behavior", "MKT104", "Fall 2023", 30, 10, "4:00 PM - 5:30 PM", "TTh", "Room 104", "Prof. Wilson", "Elective","4.0");
        Course course5 = new Course("Advertising and Promotion", "MKT105", "Fall 2023", 30, 20, "10:00 AM - 11:30 AM", "MW", "Room 105", "Prof. Brown", "Core","4.0");
        Course course6 = new Course("Marketing Management", "MKT106", "Fall 2023", 40, 25, "1:00 PM - 2:30 PM", "TTh", "Room 106", "Prof. Lee", "Core","4.0");

        // Create a list of Course objects for the Marketing Department
        List<Course> marketingDepartmentCourses = new ArrayList<>();
        marketingDepartmentCourses.add(course1);
        marketingDepartmentCourses.add(course2);
        marketingDepartmentCourses.add(course3);
        marketingDepartmentCourses.add(course4);
        marketingDepartmentCourses.add(course5);
        marketingDepartmentCourses.add(course6);

        //rest
        // Create courses for Department 2 (Finance)
        Course financeCourse1 = new Course("Investment Banking", "FIN201", "Fall 2023", 30, 10, "9:00 AM - 10:30 AM", "MWF", "Room 201", "Prof. Anderson", "Core", "4.0");
        Course financeCourse2 = new Course("Financial Derivatives", "FIN202", "Fall 2023", 25, 15, "11:00 AM - 12:30 PM", "TTh", "Room 202", "Prof. Baker", "Elective", "4.0");
        Course financeCourse3 = new Course("Corporate Finance", "FIN203", "Fall 2023", 35, 20, "2:00 PM - 3:30 PM", "MW", "Room 203", "Prof. Clark", "Core", "4.0");
        Course financeCourse4 = new Course("Risk Management", "FIN204", "Fall 2023", 30, 10, "4:00 PM - 5:30 PM", "TTh", "Room 204", "Prof. Davis", "Elective", "4.0");
        Course financeCourse5 = new Course("Financial Planning", "FIN205", "Fall 2023", 30, 20, "10:00 AM - 11:30 AM", "MW", "Room 205", "Prof. Edwards", "Core", "4.0");
        Course financeCourse6 = new Course("Real Estate Finance", "FIN206", "Fall 2023", 40, 25, "1:00 PM - 2:30 PM", "TTh", "Room 206", "Prof. Fisher", "Elective", "4.0");

        List<Course> financeCourses = new ArrayList<>();
        financeCourses.add(financeCourse1);
        financeCourses.add(financeCourse2);
        financeCourses.add(financeCourse3);
        financeCourses.add(financeCourse4);
        financeCourses.add(financeCourse5);
        financeCourses.add(financeCourse6);
// Create Department 2 (Finance)
        Department financeDepartment = new Department("Finance", financeCourses);

// Create courses for Department 3 (Entrepreneurship)
        Course entreCourse1 = new Course("Business Innovation", "ENT201", "Fall 2023", 30, 10, "9:00 AM - 10:30 AM", "MWF", "Room 201", "Prof. Garcia", "Core", "4.0");
        Course entreCourse2 = new Course("Startup Fundamentals", "ENT202", "Fall 2023", 25, 15, "11:00 AM - 12:30 PM", "TTh", "Room 202", "Prof. Hernandez", "Elective", "4.0");
        Course entreCourse3 = new Course("Entrepreneurial Finance", "ENT203", "Fall 2023", 35, 20, "2:00 PM - 3:30 PM", "MW", "Room 203", "Prof. Johnson", "Core", "4.0");
        Course entreCourse4 = new Course("Innovation Strategy", "ENT204", "Fall 2023", 30, 10, "4:00 PM - 5:30 PM", "TTh", "Room 204", "Prof. Lee", "Elective", "4.0");
        Course entreCourse5 = new Course("Social Entrepreneurship", "ENT205", "Fall 2023", 30, 20, "10:00 AM - 11:30 AM", "MW", "Room 205", "Prof. Martinez", "Core", "4.0");
        Course entreCourse6 = new Course("Product Development", "ENT206", "Fall 2023", 40, 25, "1:00 PM - 2:30 PM", "TTh", "Room 206", "Prof. Nguyen", "Elective", "4.0");

        List<Course> EntrepreneurshipCourses = new ArrayList<>();
        EntrepreneurshipCourses.add(entreCourse1);
        EntrepreneurshipCourses.add(entreCourse2);
        EntrepreneurshipCourses.add(entreCourse3);
        EntrepreneurshipCourses.add(entreCourse4);
        EntrepreneurshipCourses.add(entreCourse5);
        EntrepreneurshipCourses.add(entreCourse6);

// Create Department 3 (Entrepreneurship)
        Department entreDepartment = new Department("Entrepreneurship", EntrepreneurshipCourses);

// Create courses for Department 4 (Accounting)
        Course acctCourse1 = new Course("Financial Accounting", "ACC201", "Fall 2023", 30, 10, "9:00 AM - 10:30 AM", "MWF", "Room 201", "Prof. Oliver", "Core", "4.0");
        Course acctCourse2 = new Course("Managerial Accounting", "ACC202", "Fall 2023", 25, 15, "11:00 AM - 12:30 PM", "TTh", "Room 202", "Prof. Parker", "Elective", "4.0");
        Course acctCourse3 = new Course("Auditing and Assurance", "ACC203", "Fall 2023", 35, 20, "2:00 PM - 3:30 PM", "MW", "Room 203", "Prof. Quinn", "Core", "4.0");
        Course acctCourse4 = new Course("Taxation", "ACC204", "Fall 2023", 30, 10, "4:00 PM - 5:30 PM", "TTh", "Room 204", "Prof. Robinson", "Elective", "4.0");
        Course acctCourse5 = new Course("Forensic Accounting", "ACC205", "Fall 2023", 30, 20, "10:00 AM - 11:30 AM", "MW", "Room 205", "Prof. Smith", "Core", "4.0");
        Course acctCourse6 = new Course("Cost Accounting", "ACC206", "Fall 2023", 40, 25, "1:00 PM - 2:30 PM", "TTh", "Room 206", "Prof. Turner", "Elective", "4.0");

        List<Course> AccountingCourses = new ArrayList<>();
        AccountingCourses.add(acctCourse1);
        AccountingCourses.add(acctCourse2);
        AccountingCourses.add(acctCourse3);
        AccountingCourses.add(acctCourse4);
        AccountingCourses.add(acctCourse5);
        AccountingCourses.add(acctCourse6);
// Create Department 4 (Accounting)
        Department acctDepartment = new Department("Accounting", AccountingCourses);

        // Create the Marketing Department
        Department marketingDepartment = new Department("Marketing Department", marketingDepartmentCourses);

        // Create a list of Department objects for the School of Business
        List<Department> businessDepartments = new ArrayList<>();
        businessDepartments.add(marketingDepartment);
        businessDepartments.add(financeDepartment);
        businessDepartments.add(entreDepartment);
        businessDepartments.add(acctDepartment);




        // Create the School of Business
        School schoolOfBusiness = new School("School of Business", businessDepartments);
        // Create a list of School objects and add the School of Business
        schoolArray = new ArrayList<>();
        schoolArray.add(schoolOfBusiness);

        // Initialize the spinners
        schoolSpinner = findViewById(R.id.schoolSpinner);
        departmentSpinner = findViewById(R.id.departmentSpinner);
        courseSpinner = findViewById(R.id.courseSpinner);

        // Create an adapter for the School Spinner
        schoolAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, schoolArray);
        schoolAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        schoolSpinner.setAdapter(schoolAdapter);

        // Create an adapter for the Department Spinner
        departmentAdapter = new DepartmentArrayAdapter(this, R.layout.spinner_dropdown_item, new ArrayList<>());
        departmentAdapter.setDropDownViewResource(R.layout.spinner_dropdown_item);
        departmentSpinner.setAdapter(departmentAdapter);

        // Create an adapter for the Course Spinner
        courseAdapter = new ArrayAdapter<>(this, R.layout.spinner_item, new ArrayList<>());
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
                departmentAdapter.notifyDataSetChanged();
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
                    courseAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // Do nothing here
            }
        });

        departmentSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            Department selectedDepartment;
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                selectedDepartment = departmentAdapter.getItem(position); // Update the selected department
                courseAdapter.clear();
                courseAdapter.addAll(selectedDepartment.getCourses());
                departmentAdapter.notifyDataSetChanged();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // Handle nothing selected
            }
        });

        addButton = findViewById(R.id.addButton);
        reviewButton = findViewById(R.id.reviewButton);
        courseSection = findViewById(R.id.courseSection);
        courseSession = findViewById(R.id.courseSession);
        courseType = findViewById(R.id.courseType);
        courseRegister = findViewById(R.id.courseRegistered);
        courseLocation = findViewById(R.id.courseLocation);
        courseTime = findViewById(R.id.courseTime);
        courseInstructor = findViewById(R.id.courseInstructor);
        courseRating = findViewById(R.id.courseRating);
        courseCredit = findViewById(R.id.courseCredit);
        courseDays = findViewById(R.id.courseDays);
        // Set an item selection listener for the courseSpinner
        courseSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                Course selectedCourse = courseAdapter.getItem(position);
                // Populate course details
                populateCourseDetails(selectedCourse);
                // Make the courseDetailsLayout visible
                showCourseDetails();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // Handle nothing selected
            }
        });

        // Set click listeners for the buttons
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Implement the logic for adding a course
            }
        });

        reviewButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Implement the logic for reviewing a course
                Course selectedCourse = (Course) courseSpinner.getSelectedItem(); // Get the selected course
                Intent reviewIntent = new Intent(ViewCourse.this, rateClass.class);
                reviewIntent.putExtra("course", selectedCourse); // Pass the selected course to the ReviewCourse activity
                startActivity(reviewIntent);
            }
        });
    }

    private void populateCourseDetails(Course course) {
        courseSection.setText("Section: " + course.getSection());
        courseType.setText("Type: "+ course.getType());
        courseRegister.setText("Registered: " + course.getRegistered() + " of" + course.getSize());
        courseTime.setText("Time: " + course.getTime());
        courseLocation.setText("Location "+ course.getLocation());
        courseInstructor.setText("Instructor: " + course.getProfessor());
        courseSession.setText("Session: " + course.getSession());
        courseCredit.setText("Credit " + course.getCredit());
        courseDays.setText("Days: " + course.getDays());

        // Populate other TextViews with course details
    }

    private void showCourseDetails() {
        findViewById(R.id.courseDetails).setVisibility(View.VISIBLE);
    }
}

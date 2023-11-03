package com.example.findmyclassmate;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

public class ViewCourse extends AppCompatActivity {




    Spinner schoolSpinner, departmentSpinner, courseSpinner;
    ArrayAdapter<String> schoolAdapter, departmentAdapter, courseAdapter;
    String[] schoolArray = {"Viterbi School of Engineering", "Another School"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_course);

    schoolSpinner = findViewById(R.id.schoolSpinner);
    departmentSpinner = findViewById(R.id.departmentSpinner);
    courseSpinner = findViewById(R.id.courseSpinner);

        schoolAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, schoolArray);
        schoolAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        schoolSpinner.setAdapter(schoolAdapter);

        // Set listeners for Spinner selection events
        schoolSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                // Handle the selection of a school
                String selectedSchool = schoolArray[position];
                // TODO: Populate the departmentSpinner with the departments of the selected school
                // You'll need to create a method to retrieve and set the departments based on the selected school.
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // Do nothing here
            }
        });

        // Set up the adapters and listeners for the department and course Spinners
        departmentAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, new String[]{});
        departmentAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        departmentSpinner.setAdapter(departmentAdapter);

        courseAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, new String[]{});
        courseAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        courseSpinner.setAdapter(courseAdapter);
    }

}



//public class MainActivity extends AppCompatActivity {
//    Spinner schoolSpinner, departmentSpinner, courseSpinner;
//    ArrayAdapter<String> schoolAdapter, departmentAdapter, courseAdapter;
//
//    // Define your arrays or lists of data here
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//        schoolSpinner = findViewById(R.id.schoolSpinner);
//        departmentSpinner = findViewById(R.id.departmentSpinner);
//        courseSpinner = findViewById(R.id.courseSpinner);
//
//        // Create adapters for each Spinner
//        schoolAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, schoolArray);
//        schoolAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        schoolSpinner.setAdapter(schoolAdapter);
//
//        // Set listeners for Spinner selection events
//        schoolSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
//                // Handle the selection of a school
//                String selectedSchool = schoolArray[position];
//                // Populate the departmentSpinner with the departments of the selected school
//            }
//
//            @Override
//            public void onNothingSelected(AdapterView<?> parentView) {
//                // Do nothing here
//            }
//        });
//
//        // Set up the adapters and listeners for the department and course Spinners in a similar manner
//    }
//}
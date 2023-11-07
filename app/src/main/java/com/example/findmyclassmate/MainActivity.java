package com.example.findmyclassmate;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.findmyclassmate.databinding.ActivityMainBinding;
import com.google.firebase.FirebaseApp;
import com.google.firebase.appcheck.FirebaseAppCheck;

import android.view.Menu;
import android.view.MenuItem;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        FirebaseApp.initializeApp(this);
//        FirebaseAppCheck firebaseAppCheck = FirebaseAppCheck.getInstance();
//        FirebaseAppCheckProviderFactory providerFactory = new YourCustomAppCheckProvider.Factory();
//        firebaseAppCheck.installAppCheckProviderFactory(providerFactory);
//
//// Optionally, you can also use the SafetyNetAppCheckProviderFactory for extra protection.
//        firebaseAppCheck.installAppCheckProviderFactory(SafetyNetAppCheckProviderFactory.getInstance());
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.toolbar);

        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        appBarConfiguration = new AppBarConfiguration.Builder(navController.getGraph()).build();
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);

        binding.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });



//        Course course1 = new Course("Digital Marketing", "MKT101", "Fall 2023", 30, 10, "9:00 AM - 10:30 AM", "Mon, Wed, Fri", "Room 101", "Prof. Smith", "Elective");
//        Course course2 = new Course("Social Media Strategy", "MKT102", "Fall 2023", 25, 15, "11:00 AM - 12:30 PM", "Tue, Thu", "Room 102", "Prof. Johnson", "Elective");
//        Course course3 = new Course("Market Research and Analysis", "MKT103", "Fall 2023", 35, 20, "2:00 PM - 3:30 PM", "Mon, Wed", "Room 103", "Prof. Davis", "Core");
//        Course course4 = new Course("Consumer Behavior", "MKT104", "Fall 2023", 30, 10, "4:00 PM - 5:30 PM", "Tue, Thu", "Room 104", "Prof. Wilson", "Elective");
//        Course course5 = new Course("Advertising and Promotion", "MKT105", "Fall 2023", 30, 20, "10:00 AM - 11:30 AM", "Mon, Wed", "Room 105", "Prof. Brown", "Core");
//        Course course6 = new Course("Marketing Management", "MKT106", "Fall 2023", 40, 25, "1:00 PM - 2:30 PM", "Tue, Thu", "Room 106", "Prof. Lee", "Core");
//
//
//
//        // Create a list of Course objects for the Marketing Department
//        List<Course> marketingDepartmentCourses = new ArrayList<>();
//        marketingDepartmentCourses.add(course1);
//        marketingDepartmentCourses.add(course2);
//        marketingDepartmentCourses.add(course3);
//        marketingDepartmentCourses.add(course4);
//        marketingDepartmentCourses.add(course5);
//        marketingDepartmentCourses.add(course6);
//
//        // Create the Marketing Department
//        Department marketingDepartment = new Department("Marketing Department", marketingDepartmentCourses);
//
//        // Create a list of Department objects for the School of Business
//        List<Department> businessDepartments = new ArrayList<>();
//        businessDepartments.add(marketingDepartment);
//
//        // Create the School of Business
//        School schoolOfBusiness = new School("School of Business", businessDepartments);
//
//        List<School> schoolArray = new ArrayList<School>();
//        schoolArray.add(schoolOfBusiness);

//        Intent intent = new Intent(this, ViewCourse.class);
//        Bundle args = new Bundle();
//        args.putSerializable("ARRAYLIST",(Serializable)schoolArray);
//        intent.putExtra("BUNDLE",args);
//        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        return NavigationUI.navigateUp(navController, appBarConfiguration)
                || super.onSupportNavigateUp();
    }
}
package com.example.findmyclassmate;

import androidx.test.core.app.ActivityScenario;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import android.view.View;

import java.util.ArrayList;
import java.util.List;

@RunWith(AndroidJUnit4.class)
public class DepartmentArrayAdapterTest {

    @Rule
    public ActivityScenarioRule<ViewCourse> activityScenarioRule = new ActivityScenarioRule<>(ViewCourse.class);

    @Test
    public void testDepartmentArrayAdapter() {
        ActivityScenario<ViewCourse> scenario = activityScenarioRule.getScenario();

        // Perform actions to display the view containing the DepartmentArrayAdapter

        scenario.onActivity(activity -> {
            // Get the adapter from your activity
            DepartmentArrayAdapter adapter = activity.getDepartmentArrayAdapter();

            // Create a sample list of departments
            List<Department> departments = new ArrayList<>();
            departments.add(new Department("Department A", new ArrayList<>()));
            departments.add(new Department("Department B", new ArrayList<>()));
            departments.add(new Department("Department C", new ArrayList<>()));

            // Set the adapter with the sample data
            activity.runOnUiThread(() -> adapter.setData(departments));

            // Test the adapter's functionality
            assertEquals(3, adapter.getCount()); // Check if the adapter has the correct number of items

            // Test getting an item from the adapter
            Department department = adapter.getItem(1);
            assertNotNull(department); // Check if the retrieved item is not null
            assertEquals("Department B", department.getName()); // Check if the retrieved item matches the expected department

            // Test the view creation (you may need to adapt this based on the adapter's implementation)
            View view = adapter.getView(0, null, null);
            assertNotNull(view); // Check if the view is not null

        });
    }
}

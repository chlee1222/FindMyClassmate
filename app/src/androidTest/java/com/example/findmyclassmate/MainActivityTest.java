package com.example.findmyclassmate;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    @Rule
    public ActivityScenarioRule<MainActivity> activityScenarioRule = new ActivityScenarioRule<>(MainActivity.class);

    @Test
    public void testMainActivityInitialization() {
        activityScenarioRule.getScenario().onActivity(activity -> {
            // Replace these assertions with actual default values and states you expect from MainActivity
            assertNotNull("MainActivity is not initialized", activity);
            // Example: Check if a member variable is initialized with a default value
            // assertEquals("Default value is not set correctly", expectedValue, activity.getSomeVariable());

            // Add more assertions here based on the specific initialization logic of MainActivity
        });
    }
}
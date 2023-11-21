package com.example.findmyclassmate;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.espresso.Espresso;
import static androidx.test.espresso.action.ViewActions.*;
import static androidx.test.espresso.matcher.ViewMatchers.*;
import static androidx.test.espresso.assertion.ViewAssertions.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class RegistrationLoginLogoutTests {

    @Rule
    public ActivityScenarioRule<Registration> activityRule = new ActivityScenarioRule<>(Registration.class);

    @Test
    public void testEmptyEmailAndPassword() {
        // Check if the registration button is clickable
        Espresso.onView(withId(R.id.btn_register)).check(matches(isClickable()));

        // Simulate empty email and password input and button click
        Espresso.onView(withId(R.id.idid)).perform(typeText(""), closeSoftKeyboard());
        Espresso.onView(withId(R.id.passwordpassword)).perform(typeText(""), closeSoftKeyboard());
        Espresso.onView(withId(R.id.btn_register)).perform(click());

        // Check for Toast message indicating empty email or password (requires a Toast matcher implementation)
        // Note: Toast validation requires additional setup
    }

    @Test
    public void testValidEmailAndPassword() {
        // Simulate valid email and password input and button click
        Espresso.onView(withId(R.id.idid)).perform(typeText("test@example.com"), closeSoftKeyboard());
        Espresso.onView(withId(R.id.passwordpassword)).perform(typeText("password123"), closeSoftKeyboard());
        Espresso.onView(withId(R.id.btn_register)).perform(click());

        // Additional assertions can be added here based on expected behavior
    }

    // Additional tests can be written for other scenarios like invalid email formats, password strength, etc.
}
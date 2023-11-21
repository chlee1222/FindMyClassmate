package com.example.findmyclassmate;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.scrollTo;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.filters.LargeTest;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
@LargeTest
public class RegistrationPageTests {

    @Rule
    public ActivityScenarioRule<Registration> activityRule =
            new ActivityScenarioRule<>(Registration.class);

    @Test
    public void usernameregistration() throws InterruptedException {
        // Type in user email
        Thread.sleep(5000);
        onView(withId(R.id.idid)).perform(typeText("hello@usc.edu"));
        Thread.sleep(2000);
        onView(withId(R.id.idid)).perform(closeSoftKeyboard());
        Thread.sleep(2000);
        // Check that the user email was recorded.
        onView(withId(R.id.idid)).check(matches(withText("hello@usc.edu")));
    }
    @Test
    public void passwordRegistration() throws InterruptedException {
        // Type in user email
        Thread.sleep(5000);
        onView(withId(R.id.passwordpassword)).perform(typeText("password1234"));
        Thread.sleep(2000);
        onView(withId(R.id.passwordpassword)).perform(closeSoftKeyboard());
        Thread.sleep(2000);
        onView(withId(R.id.passwordpassword)).check(matches(withText("password1234")));
        Thread.sleep(2000);

    }

    @Test
    public void RegistrationCheck() throws InterruptedException {
        Thread.sleep(5000);
        onView(withId(R.id.idid)).perform(typeText("hello@usc.edu"), closeSoftKeyboard());
        Thread.sleep(2000);
        onView(withId(R.id.passwordpassword)).perform(typeText("password1234"), closeSoftKeyboard());
        Thread.sleep(2000);
        onView(withId(R.id.btn_register)).perform(click());
        Thread.sleep(2000);

    }
}
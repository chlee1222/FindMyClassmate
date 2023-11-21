package com.example.findmyclassmate;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
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
public class LoginPageTests {

    @Rule
    public ActivityScenarioRule<Login> activityRule =
            new ActivityScenarioRule<>(Login.class);

    @Test
    public void usernamelogin() throws InterruptedException {
        // Type in user email
        Thread.sleep(6000);
        onView(withId(R.id.two2)).perform(typeText("hello@usc.edu"));
        Thread.sleep(3000);
        onView(withId(R.id.two2)).check(matches(withText("hello@usc.edu")));
        Thread.sleep(3000);

    }
    @Test
    public void passwordlogin() throws InterruptedException {
        // Type in user email
        Thread.sleep(6000);
        onView(withId(R.id.three3)).perform(typeText("password1234"));
        Thread.sleep(3000);
        // Check that the user email was recorded.
        onView(withId(R.id.three3)).check(matches(withText("password1234")));
        Thread.sleep(3000);
    }

    @Test
    public void loginValidation() throws InterruptedException {
        // Type in user email
        Thread.sleep(6000);
        onView(withId(R.id.two2)).perform(typeText("hi@usc.edu"), closeSoftKeyboard());
        Thread.sleep(3000);

        onView(withId(R.id.three3)).perform(typeText("hello1234"), closeSoftKeyboard());
        Thread.sleep(3000);

        onView(withId(R.id.btn_login)).perform(click());
        Thread.sleep(2000);

    }

    @Test
    public void invalidloginValidation() throws InterruptedException {
        // Type in user email
        Thread.sleep(6000);
        onView(withId(R.id.two2)).perform(typeText("hi@usc.edu"), closeSoftKeyboard());
        Thread.sleep(3000);

        onView(withId(R.id.three3)).perform(typeText("wrongpassword1234"), closeSoftKeyboard());
        Thread.sleep(3000);

        onView(withId(R.id.btn_login)).perform(click());
        Thread.sleep(2000);
    }
}
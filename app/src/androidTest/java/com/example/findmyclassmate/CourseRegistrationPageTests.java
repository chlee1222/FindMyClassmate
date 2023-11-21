package com.example.findmyclassmate;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isClickable;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.filters.LargeTest;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import com.google.firebase.auth.FirebaseAuth;

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
public class CourseRegistrationPageTests {

    FirebaseAuth mAuth;


//    FirebaseAuth.AuthStateListener.
//            .createUserWithEmailAndPassword("test0011@gmail.com", "test0011");

    @Rule
    public ActivityScenarioRule<ViewCourse> activityRule =
            new ActivityScenarioRule<>(ViewCourse.class);

    @Test
    public void checkAddButton() throws InterruptedException {
        // Type in user email
        Thread.sleep(5000);
        onView(withId(R.id.addButton)).check(matches(isClickable()));
        Thread.sleep(2000);
    }
    @Test
    public void checkReviewButton() throws InterruptedException {
        // Type in user email
        Thread.sleep(5000);
        onView(withId(R.id.reviewButton)).check(matches(isClickable()));
        Thread.sleep(2000);
    }

    @Test
    public void checkSpinnerWorking() throws InterruptedException {
        // Type in user email
        Thread.sleep(5000);
        onView(withId(R.id.schoolSpinner)).check(matches(isClickable()));
//        onView(withId(R.id.schoolSpinner)).perform(click());
        Thread.sleep(2000);
    }
}
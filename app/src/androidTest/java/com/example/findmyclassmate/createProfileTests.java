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
public class createProfileTests {

    @Rule
    public ActivityScenarioRule<createProfile> activityRule =
            new ActivityScenarioRule<>(createProfile.class);

    @Test
    public void uploadname() throws InterruptedException {
        // Type in user email
        Thread.sleep(5000);
        onView(withId(R.id.uploadName)).perform(typeText("John"));
        Thread.sleep(2000);
        onView(withId(R.id.uploadName)).perform(closeSoftKeyboard());
        Thread.sleep(2000);
        // Check that the user email was recorded.
        onView(withId(R.id.uploadName)).check(matches(withText("John")));
    }
    @Test
    public void uploadtype() throws InterruptedException {
        // Type in user email
        Thread.sleep(5000);
        onView(withId(R.id.uploadtype)).perform(typeText("undergraduate"));
        Thread.sleep(2000);
        onView(withId(R.id.uploadtype)).perform(closeSoftKeyboard());
        Thread.sleep(2000);
        onView(withId(R.id.uploadtype)).check(matches(withText("undergraduate")));
        Thread.sleep(2000);

    }

    @Test
    public void CreateProfileErrorNoPhoto() throws InterruptedException {
        Thread.sleep(5000);
        onView(withId(R.id.uploadName)).perform(typeText("Jack"), closeSoftKeyboard());
        Thread.sleep(2000);
        onView(withId(R.id.uploadtype)).perform(closeSoftKeyboard());
        Thread.sleep(2000);
        onView(withId(R.id.uploadtype)).perform(typeText("undergraduate"));
        Thread.sleep(2000);
        onView(withId(R.id.uploadtype)).perform(closeSoftKeyboard());
        Thread.sleep(2000);
        onView(withId(R.id.uploadButton)).perform(click());
        Thread.sleep(2000);
    }
    @Test
    public void CreateProfileErrorNoInformation() throws InterruptedException {
        Thread.sleep(5000);
        onView(withId(R.id.uploadButton)).perform(click());
        Thread.sleep(2000);
    }
}
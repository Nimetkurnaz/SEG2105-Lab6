package com.example.lab6;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.espresso.Espresso;

import static androidx.test.espresso.action.ViewActions.clearText;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class LoginActivityTest {

    @Rule
    public ActivityScenarioRule<LoginActivity> activityRule =
            new ActivityScenarioRule<>(LoginActivity.class);

    @Test
    public void testInvalidName_ShowsNameIsInvalid() {
        // typing an invalid name having numbers into the username field
        Espresso.onView(withId(R.id.edtUsername))
                .perform(typeText("Maria123"), closeSoftKeyboard());

        // checking to see of login button works
        Espresso.onView(withId(R.id.btnLogin)).perform(click());

        // verifying textview (loginTxt) contains "Name is invalid"
        Espresso.onView(withId(R.id.loginTxt))
                .check(matches(withText("Name is invalid")));
    }

    @Test
    public void testInvalidLastName_ShowsLastNameIsInvalid() {
        // entering a valid first name first but make it fail the last name validation format
        Espresso.onView(withId(R.id.edtUsername))
                .perform(clearText(), typeText(""), closeSoftKeyboard());

        // clicking the login button
        Espresso.onView(withId(R.id.btnLogin)).perform(click());

        // verifying your textview (loginTxt) contains "Last name is invalid"
        Espresso.onView(withId(R.id.loginTxt))
                .check(matches(withText("Last name is invalid")));
    }
}
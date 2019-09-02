package org.matt.calculatorapp;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.matt.calculatorapp.AppView.MainActivity;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.longClick;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

@RunWith(AndroidJUnit4.class)
public class FunctionalButtonsTest {

    @Rule
    public ActivityScenarioRule<MainActivity> activityScenarioRule
            = new ActivityScenarioRule<>(MainActivity.class);


    @Test
    public void ClearTest() {
        onView(withId(R.id.btn_2)).perform(click());
        onView(withId(R.id.btn_add)).perform(click());
        onView(withId(R.id.btn_2)).perform(click());
        onView(withId(R.id.btn_clear)).perform(click());
        onView(withId(R.id.tv_userInput)).check(matches(withText("")));
        onView(withId(R.id.tv_userResult)).check(matches(withText("")));
    }

    @Test
    public void SpaceTest() {
        onView(withId(R.id.btn_decimal)).perform(longClick());
        onView(withId(R.id.tv_userInput)).check(matches(withText(" ")));
    }

}

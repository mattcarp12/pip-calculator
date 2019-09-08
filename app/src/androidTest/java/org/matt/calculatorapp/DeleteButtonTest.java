package org.matt.calculatorapp;

import androidx.test.InstrumentationRegistry;
import androidx.test.core.app.ApplicationProvider;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.matt.calculatorapp.AppView.MainActivity;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.Espresso.openActionBarOverflowOrOptionsMenu;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.longClick;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static androidx.test.platform.app.InstrumentationRegistry.getInstrumentation;

@RunWith(AndroidJUnit4.class)
public class DeleteButtonTest {

    @Rule
    public ActivityScenarioRule<MainActivity> activityScenarioRule
            = new ActivityScenarioRule<>(MainActivity.class);

    @Test
    public void PostfixCalculationThenDeleteTest() {
        // Switch to postfix mode
        openActionBarOverflowOrOptionsMenu(ApplicationProvider.getApplicationContext());
        onView(withText("Postfix")).perform(click());

        // Do calculation 3 3 + and check it equals 6
        onView(withId(R.id.btn_3)).perform(click());
        onView(withId(R.id.btn_decimal)).perform(longClick());
        onView(withId(R.id.btn_3)).perform(click());
        onView(withId(R.id.btn_add)).perform(click());
        onView(withId(R.id.tv_userInput)).check(matches(withText("3 3+")));
        onView(withId(R.id.tv_userResult)).check(matches(withText("6")));

        // delete the + sign
        onView(withId(R.id.btn_del)).perform(click());

        // Verify input is 3 3 and result is blank
        onView(withId(R.id.tv_userInput)).check(matches(withText("3 3")));
        onView(withId(R.id.tv_userResult)).check(matches(withText("")));
    }

}

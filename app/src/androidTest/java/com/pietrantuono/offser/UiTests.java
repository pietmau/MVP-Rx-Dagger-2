package com.pietrantuono.offser;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.pietrantuono.offser.view.main.MainActivity;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

@RunWith(AndroidJUnit4.class)

public class UiTests {

//    @Rule
//    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule<>(
//            MainActivity.class);

    @Test
    public void given_BottomNavigationView_whenClickOnFilms_thenFimsFragmentShows() {
        onView(withId(R.id.people)).perform(click());
    }
}

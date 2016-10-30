package com.pietrantuono.offser;

import android.app.Application;
import android.support.test.InstrumentationRegistry;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.pietrantuono.offser.dagger.main.StarWarsApiMock;
import com.pietrantuono.offser.view.main.MainActivity;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.doesNotExist;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

@RunWith(AndroidJUnit4.class)

public class UiTests {
    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule<>(
            MainActivity.class);

    @Test
    public void given_BottomNavigationView_whenClickOnpersons_thenPersonsFragmentShows() {
        onView(withId(R.id.people)).perform(click());
        onView(withText(StarWarsApiMock.PERSON_NAME)).check(matches(isDisplayed()));
        onView(withText(StarWarsApiMock.FILM_TITLE)).check(doesNotExist());
    }

    @Test
    public void given_ManiActivity_whenStarts_thenFilmFragmentShows() {
        onView(withText(StarWarsApiMock.FILM_TITLE)).check(matches(isDisplayed()));
        onView(withText(StarWarsApiMock.PERSON_NAME)).check(doesNotExist());
    }

    @Test
    public void given_BottomNavigationView_whenGoBeckToFilms_thenFilmsFragmentShows() {
        onView(withId(R.id.people)).perform(click());
        onView(withId(R.id.films)).perform(click());
        onView(withText(StarWarsApiMock.PERSON_NAME)).check(doesNotExist());
        onView(withText(StarWarsApiMock.FILM_TITLE)).check(matches(isDisplayed()));
    }
}

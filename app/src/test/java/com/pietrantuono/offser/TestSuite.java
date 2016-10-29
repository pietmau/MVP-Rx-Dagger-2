package com.pietrantuono.offser;

import com.pietrantuono.offser.tests.StarWarsFilmPresenterTests;
import com.pietrantuono.offser.tests.StarWarsMainViewPresenterTests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        StarWarsMainViewPresenterTests.class,
        StarWarsFilmPresenterTests.class
})
public class TestSuite {
}
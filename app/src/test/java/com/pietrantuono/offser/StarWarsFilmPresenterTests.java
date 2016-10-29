package com.pietrantuono.offser;

import android.os.Bundle;

import com.pietrantuono.offser.presenter.main.StarWarsMainViewPresenter;
import com.pietrantuono.offser.view.main.MainView;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class StarWarsFilmPresenterTests {
    StarWarsMainViewPresenter starWarsMainViewPresenter;
    private Bundle bundle;
    @Mock
    MainView view;

    @Before
    public void setUp() {
        starWarsMainViewPresenter = new StarWarsMainViewPresenter();
        bundle = new Bundle();
    }

    @Test
    public void givenPresenter_whenOnCreteAndNoBundle_thenGoToFilms() throws Exception {
        // WHEN
        starWarsMainViewPresenter.onCreate(view, null);
        // THEN
        verify(view).navigateToFilms();
    }
}
package com.pietrantuono.offser.tests;

import com.pietrantuono.offser.model.StarWarsModel;
import com.pietrantuono.offser.model.api.pojos.AllFilms;
import com.pietrantuono.offser.model.api.pojos.Film;
import com.pietrantuono.offser.films.presenter.StarWarsFilmPresenter;
import com.pietrantuono.offser.films.view.FilmsView;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.Arrays;

import rx.Observer;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class StarWarsFilmPresenterTests {
    private StarWarsFilmPresenter presenter;
    @Mock
    StarWarsModel model;
    @Mock
    FilmsView view;
    private final ArgumentCaptor<Observer<? super AllFilms>> captor = ArgumentCaptor.forClass(Observer.class);
    private final AllFilms films = new AllFilms();
    private final ArrayList filmsList = new ArrayList<>(Arrays.asList(new Film()));

    @Before
    public void setUp() {
        presenter = new StarWarsFilmPresenter(model);
        presenter.setView(view);
        films.setFilms(filmsList);
    }

    @Test
    public void givenPresenter_whenOnResume_thenSubscribes() {
        // WHEN
        presenter.onResume();
        // THEN
        verify(model).subscribeToFilms(any(Observer.class));
    }

    @Test
    public void givenPresenter_whenOnPause_thenUnSubscribes() {
        // WHEN
        presenter.onPause();
        // THEN
        verify(model).unSubscribeToFilms();
    }

    @Test
    public void givenPresenter_whenOnNext_thenShowsFilms() {
        // GIVEN
        presenter.onResume();
        verify(model).subscribeToFilms(captor.capture());
        // WHEN
        captor.getValue().onNext(films);
        // THEN
        verify(view).showFilms(filmsList);
    }

    @Test
    public void givenPresenter_whenOnError_thenShowErrorCalled() {
        // GIVEN
        presenter.onResume();
        verify(model).subscribeToFilms(captor.capture());
        // WHEN
        String ERROR = "tis_is_an_error";
        captor.getValue().onError(new Throwable(ERROR));
        // THEN
        verify(view).showError(ERROR);
    }

}
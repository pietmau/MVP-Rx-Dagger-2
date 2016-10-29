package com.pietrantuono.offser.presenter.films;

import com.pietrantuono.offser.model.StarWarsModel;
import com.pietrantuono.offser.model.api.pojos.Film;
import com.pietrantuono.offser.view.films.FilmsView;

import java.util.List;

import rx.Observer;

/**
 * Created by Maurizio Pietrantuono, maurizio.pietrantuono@gmail.com.
 */
public class FilmPresenterImpl implements FilmsPresenter {
    private final StarWarsModel starWarsModel;
    private FilmsView view;
    private SimpleObserver simpleObserver;

    public FilmPresenterImpl(StarWarsModel starWarsModel) {
        this.starWarsModel = starWarsModel;
        simpleObserver = new SimpleObserver();
    }

    @Override
    public void setView(FilmsView filmsView) {
        this.view = filmsView;
    }

    @Override
    public void onPause() {
        starWarsModel.unSubscribeToFilms();
    }

    @Override
    public void onResume() {
        starWarsModel.subscribeToFilms(simpleObserver);
    }

    private class SimpleObserver implements Observer<List<Film>> {

        @Override
        public void onCompleted() {

        }

        @Override
        public void onError(Throwable e) {

        }

        @Override
        public void onNext(List<Film> films) {
            view.showFilms(films);
        }
    }
}


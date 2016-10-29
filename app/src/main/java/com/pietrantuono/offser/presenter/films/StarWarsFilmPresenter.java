package com.pietrantuono.offser.presenter.films;

import com.pietrantuono.offser.model.StarWarsModel;
import com.pietrantuono.offser.model.api.pojos.AllFilms;
import com.pietrantuono.offser.view.films.FilmsView;

import rx.Observer;

/**
 * Created by Maurizio Pietrantuono, maurizio.pietrantuono@gmail.com.
 */
public class StarWarsFilmPresenter implements FilmsPresenter {
    private final StarWarsModel starWarsModel;
    private FilmsView view;
    private final SimpleObserver simpleObserver;

    public StarWarsFilmPresenter(StarWarsModel starWarsModel) {
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

    private class SimpleObserver implements Observer<AllFilms> {

        @Override
        public void onCompleted() {
            starWarsModel.unSubscribeToFilms();
        }

        @Override
        public void onError(Throwable e) {
            view.showError(e.getMessage());
        }

        @Override
        public void onNext(AllFilms allFilms) {
            if (allFilms == null || allFilms.getFilms() == null) {
                return;
            }
            view.showFilms(allFilms.getFilms());
        }
    }
}


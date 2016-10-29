package com.pietrantuono.offser.presenter.films;

import android.util.Log;

import com.pietrantuono.offser.model.StarWarsModel;
import com.pietrantuono.offser.model.api.pojos.AllFilms;
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

    private class SimpleObserver implements Observer<AllFilms> {
        private final String TAG = SimpleObserver.class.getSimpleName();

        @Override
        public void onCompleted() {
            Log.d(TAG, "onCompleted");
        }

        @Override
        public void onError(Throwable e) {
            Log.d(TAG, "onError");
        }

        @Override
        public void onNext(AllFilms allFilms) {
            Log.d(TAG, "onNext");
            if (allFilms == null || allFilms.getFilms() == null) {
                return;
            }
            view.showFilms(allFilms.getFilms());
        }
    }
}


package com.pietrantuono.offser.films.presenter;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.pietrantuono.offser.model.StarWarsModel;
import com.pietrantuono.offser.model.api.pojos.AllFilms;
import com.pietrantuono.offser.films.view.FilmsView;

import rx.Observer;

/**
 * Created by Maurizio Pietrantuono, maurizio.pietrantuono@gmail.com.
 */
public class StarWarsFilmPresenter implements FilmsPresenter {
    @NonNull
    private final StarWarsModel starWarsModel;
    private FilmsView view;

    public StarWarsFilmPresenter(@NonNull StarWarsModel starWarsModel) {
        this.starWarsModel = starWarsModel;
    }

    @Override
    public void setView(@NonNull FilmsView filmsView) {
        this.view = filmsView;
    }

    @Override
    public void onPause() {
        starWarsModel.unSubscribeToFilms();
    }

    @Override
    public void onResume() {
        starWarsModel.subscribeToFilms(new Observer<AllFilms>() {
            @Override
            public void onCompleted() {
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
        });
    }

}


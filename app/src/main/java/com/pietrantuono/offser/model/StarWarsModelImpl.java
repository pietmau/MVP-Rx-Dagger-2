package com.pietrantuono.offser.model;

import android.app.Activity;

import com.pietrantuono.offser.model.api.StarWarsApi;
import com.pietrantuono.offser.model.api.pojos.AllFilms;
import com.pietrantuono.offser.model.api.pojos.Film;

import java.util.List;

import rx.Observable;
import rx.Observer;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Maurizio Pietrantuono, maurizio.pietrantuono@gmail.com.
 */
public class StarWarsModelImpl implements StarWarsModel {  //TODO change name
    private final StarWarsApi starWarsApi;
    private static StarWarsModel instance;
    private final Observable<AllFilms> cahcedFilmsObservable;
    private Subscription filmsSubscription;

    public StarWarsModelImpl(StarWarsApi starWarsApi) {
        this.starWarsApi = starWarsApi;
        cahcedFilmsObservable = starWarsApi.getAllFilms().cache();
    }

    public static StarWarsModel getInstance(Activity activity, StarWarsApi starWarsApi) {
        if (instance == null) {
            instance = new StarWarsModelImpl(starWarsApi);
        }
        return instance;
    }

    @Override
    public void subscribeToFilms(Observer<? super AllFilms> observer) {
        filmsSubscription = cahcedFilmsObservable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(observer);
    }

    @Override
    public void unSubscribeToFilms() {
        if (filmsSubscription != null && !filmsSubscription.isUnsubscribed()) {//TODo we need this?
            filmsSubscription.unsubscribe();
        }
    }
}

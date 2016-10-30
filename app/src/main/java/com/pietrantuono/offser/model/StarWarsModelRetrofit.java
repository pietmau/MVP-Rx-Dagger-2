package com.pietrantuono.offser.model;

import android.util.Log;

import com.pietrantuono.offser.StarWarsApplication;
import com.pietrantuono.offser.model.api.pojos.AllFilms;
import com.pietrantuono.offser.model.api.pojos.AllPeople;

import rx.Observer;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Maurizio Pietrantuono, maurizio.pietrantuono@gmail.com.
 */
public class StarWarsModelRetrofit implements StarWarsModel {  //TODO change name
    private static final String TAG = StarWarsModelRetrofit.class.getSimpleName();
    private Subscription filmsSubscription;
    private Subscription peopleSubscription;
    private final StarWarsApplication app;
    private static StarWarsModelRetrofit instance;

    private StarWarsModelRetrofit(StarWarsApplication app) {
        this.app = app;
    }

    public static StarWarsModelRetrofit getInstance(StarWarsApplication app) {
        if (instance == null) {
            instance = new StarWarsModelRetrofit(app);
        }
        return instance;
    }

    @Override
    public void subscribeToFilms(Observer<? super AllFilms> observer) {
        filmsSubscription = app.getCachedFilmsObservable().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(observer);
    }

    @Override
    public void unSubscribeToFilms() {
            filmsSubscription.unsubscribe();

    }

    @Override
    public void unSubscribeToPeople() {
            peopleSubscription.unsubscribe();
    }

    @Override
    public void subscribeToPeople(Observer<? super AllPeople> observer) {
        peopleSubscription = app.getCachedPeopleObservable().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(observer);
    }
}

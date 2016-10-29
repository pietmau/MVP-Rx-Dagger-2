package com.pietrantuono.offser.model;

import android.util.Log;

import com.pietrantuono.offser.StarWarsApplication;
import com.pietrantuono.offser.model.api.StarWarsApi;
import com.pietrantuono.offser.model.api.pojos.AllFilms;
import com.pietrantuono.offser.model.api.pojos.AllPeople;

import rx.Observer;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Maurizio Pietrantuono, maurizio.pietrantuono@gmail.com.
 */
public class StarWarsModelImpl implements StarWarsModel {  //TODO change name
    private static final String TAG = StarWarsModelImpl.class.getSimpleName();
    private Subscription filmsSubscription;
    private Subscription peopleSubscription;
    private final StarWarsApplication app;
    private static StarWarsModelImpl instance;

    private StarWarsModelImpl(StarWarsApplication app) {
        this.app = app;
        Log.d(TAG, "setApis");
    }

    public static StarWarsModelImpl getInstance(StarWarsApi starWarsApi, StarWarsApplication app) {
        if (instance == null) {
            instance = new StarWarsModelImpl(app);
        }
        return instance;
    }


    @Override
    public void subscribeToFilms(Observer<? super AllFilms> observer) {
        Log.d(TAG, "subscribeToFilms");
        filmsSubscription = app.getCachedFilmsObservable().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(observer);
    }

    @Override
    public void unSubscribeToFilms() {
        Log.d(TAG, "unSubscribeToFilms");
        if (filmsSubscription != null) {//TODo we need this?
            filmsSubscription.unsubscribe();
        }
    }

    @Override
    public void unSubscribeToPeople() {
        Log.d(TAG, "unSubscribeToPeople");
        if (peopleSubscription != null) {//TODo we need this?
            peopleSubscription.unsubscribe();
        }
    }

    @Override
    public void subscribeToPeople(Observer<? super AllPeople> observer) {
        Log.d(TAG, "subscribeToPeople");
        peopleSubscription = app.getCachedPeopleObservable().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(observer);
    }
}

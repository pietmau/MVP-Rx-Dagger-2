package com.pietrantuono.offser.model;

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
public class StarWarsModelRetrofit implements StarWarsModel {
    private Subscription filmsSubscription;
    private Subscription peopleSubscription;
    private final StarWarsApplication app;

    public StarWarsModelRetrofit(StarWarsApplication app) {
        this.app = app;
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

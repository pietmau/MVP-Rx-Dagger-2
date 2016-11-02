package com.pietrantuono.offser.model;

import android.support.annotation.NonNull;

import com.pietrantuono.offser.StarWarsApplication;
import com.pietrantuono.offser.model.api.pojos.AllFilms;
import com.pietrantuono.offser.model.api.pojos.AllPeople;

import javax.inject.Inject;

import rx.Observable;
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
    private final Observable<AllPeople> allPeopleObservable;
    private final Observable<AllFilms> allFilmsObservable;

    public StarWarsModelRetrofit(Observable<AllPeople> allPeopleObservable, Observable<AllFilms> allFilmsObservable) {
        this.allPeopleObservable = allPeopleObservable;
        this.allFilmsObservable = allFilmsObservable;
    }

    @Override
    public void subscribeToFilms(@NonNull Observer<? super AllFilms> observer) {
        filmsSubscription = allFilmsObservable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(observer);
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
    public void subscribeToPeople(@NonNull Observer<? super AllPeople> observer) {
        peopleSubscription = allPeopleObservable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(observer);
    }
}

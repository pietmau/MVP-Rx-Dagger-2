package com.pietrantuono.offser.model;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

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
public class StarWarsModelImpl extends Fragment implements StarWarsModel {  //TODO change name
    private Observable<AllFilms> cahcedFilmsObservable;
    private Subscription filmsSubscription;
    private static final String RETAINED_FRAGMENT_TAG = "retained_frag";

    public static StarWarsModel getInstance(AppCompatActivity activity, StarWarsApi starWarsApi) {
        FragmentManager manager = activity.getSupportFragmentManager();
        StarWarsModelImpl starWarsModel = (StarWarsModelImpl) manager.findFragmentByTag(RETAINED_FRAGMENT_TAG);
        if (starWarsModel == null) {
            starWarsModel = new StarWarsModelImpl();
            starWarsModel.setApis(starWarsApi);
            manager.beginTransaction().add(starWarsModel, RETAINED_FRAGMENT_TAG).commit();
        }
        return starWarsModel;
    }

    private void setApis(StarWarsApi starWarsApi) {
        cahcedFilmsObservable = starWarsApi.getAllFilms().cache();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }

    @Override
    public void subscribeToFilms(Observer<? super AllFilms> observer) {
        filmsSubscription = cahcedFilmsObservable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(observer);
    }

    @Override
    public void unSubscribeToFilms() {
        if (filmsSubscription != null) {//TODo we need this?
            filmsSubscription.unsubscribe();
        }
    }
}

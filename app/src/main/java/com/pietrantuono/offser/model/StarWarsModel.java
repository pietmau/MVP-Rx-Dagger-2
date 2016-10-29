package com.pietrantuono.offser.model;

import android.app.Activity;

import com.pietrantuono.offser.model.api.pojos.AllFilms;
import com.pietrantuono.offser.model.api.pojos.Film;

import java.util.List;

import rx.Observer;

/**
 * Created by Maurizio Pietrantuono, maurizio.pietrantuono@gmail.com.
 */
public interface StarWarsModel {
    void subscribeToFilms(Observer<? super AllFilms> observer);

    void unSubscribeToFilms();
}

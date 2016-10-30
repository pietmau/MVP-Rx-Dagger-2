package com.pietrantuono.offser.model;

import android.support.annotation.NonNull;

import com.pietrantuono.offser.model.api.pojos.AllFilms;
import com.pietrantuono.offser.model.api.pojos.AllPeople;

import rx.Observer;

/**
 * Created by Maurizio Pietrantuono, maurizio.pietrantuono@gmail.com.
 */
public interface StarWarsModel {

    void subscribeToFilms(@NonNull Observer<? super AllFilms> observer);

    void unSubscribeToFilms();

    void unSubscribeToPeople();

    void subscribeToPeople(@NonNull Observer<? super AllPeople> observer);

}

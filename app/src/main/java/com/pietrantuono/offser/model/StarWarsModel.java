package com.pietrantuono.offser.model;

import com.pietrantuono.offser.model.api.pojos.AllFilms;
import com.pietrantuono.offser.model.api.pojos.AllPeople;

import rx.Observer;

/**
 * Created by Maurizio Pietrantuono, maurizio.pietrantuono@gmail.com.
 */
public interface StarWarsModel {

    void subscribeToFilms(Observer<? super AllFilms> observer);

    void unSubscribeToFilms();

    void unSubscribeToPeople();

    void subscribeToPeople(Observer<? super AllPeople> observer);

}

package com.pietrantuono.offser.model.api;

import com.pietrantuono.offser.model.api.pojos.AllFilms;
import com.pietrantuono.offser.model.api.pojos.AllPeople;

import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by Maurizio Pietrantuono, maurizio.pietrantuono@gmail.com.
 */

public interface StarWarsApi {

    @GET("films")
    Observable<AllFilms> getAllFilms();

    @GET("people")
    Observable<AllPeople> getAllPeople();
}

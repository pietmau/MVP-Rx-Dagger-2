package com.pietrantuono.offser.api;

import com.pietrantuono.offser.api.pojos.Film;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by Maurizio Pietrantuono, maurizio.pietrantuono@gmail.com.
 */

public interface StarWarsApi {

    @GET("films")
    Observable<List<Film>> getAllFilms();


}

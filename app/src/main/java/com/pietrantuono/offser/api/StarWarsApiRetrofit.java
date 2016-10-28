package com.pietrantuono.offser.api;

import com.pietrantuono.offser.api.pojos.Film;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;

/**
 * Created by Maurizio Pietrantuono, maurizio.pietrantuono@gmail.com.
 */

public class StarWarsApiRetrofit implements StarWarsApi {
    private static final String BASE_URL = "http://swapi.co/api/";
    private final StarWarsApi api;

    public StarWarsApiRetrofit() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create()) // TODO add custom converter
                .build();
        api = retrofit.create(StarWarsApi.class);
    }

    @Override
    public Observable<List<Film>> getAllFilms() {
        return api.getAllFilms();
    }
}

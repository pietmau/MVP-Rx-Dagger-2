package com.pietrantuono.offser.model.api;

import com.pietrantuono.offser.model.api.pojos.AllFilms;
import com.pietrantuono.offser.model.api.pojos.AllPeople;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
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
                .addConverterFactory(GsonConverterFactory.create()) // TODO would be nicer to use a custom converter to extract the list
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        api = retrofit.create(StarWarsApi.class);
    }

    @Override
    public Observable<AllFilms> getAllFilms() {
        return api.getAllFilms();
    }

    @Override
    public Observable<AllPeople> getAllPeople() {
        return api.getAllPeople();
    }
}

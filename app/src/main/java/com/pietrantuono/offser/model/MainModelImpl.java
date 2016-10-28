package com.pietrantuono.offser.model;

import android.app.Activity;

import com.pietrantuono.offser.model.api.StarWarsApi;

/**
 * Created by Maurizio Pietrantuono, maurizio.pietrantuono@gmail.com.
 */
public class MainModelImpl implements MainModel {  //TODO change name
    private final StarWarsApi starWarsApi;

    public MainModelImpl(StarWarsApi starWarsApi) {
        this.starWarsApi = starWarsApi;
    }

    public static MainModel getInstance(Activity activity, StarWarsApi starWarsApi) {
        return new MainModelImpl(starWarsApi);
    }
}

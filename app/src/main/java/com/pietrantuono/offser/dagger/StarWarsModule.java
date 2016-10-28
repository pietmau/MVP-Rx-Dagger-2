package com.pietrantuono.offser.dagger;

import android.app.Activity;

import com.pietrantuono.offser.MainModel;
import com.pietrantuono.offser.MainModelImpl;
import com.pietrantuono.offser.MainViewPresenter;
import com.pietrantuono.offser.MainViewPresenterImplementation;
import com.pietrantuono.offser.api.StarWarsApi;
import com.pietrantuono.offser.api.StarWarsApiRetrofit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Maurizio Pietrantuono, maurizio.pietrantuono@gmail.com.
 */
@Module
public class StarWarsModule {
    private Activity activity;

    public StarWarsModule(Activity activity) {
        this.activity = activity;
    }

    @Provides
    @Singleton
    MainViewPresenter provideMainViewPresenter(MainModel module) {
        return new MainViewPresenterImplementation(module);
    }

    @Provides
    @Singleton
    MainModel provideMainModel(StarWarsApi starWarsApi) {
        return MainModelImpl.getInstance(activity, starWarsApi);
    }

    @Provides
    @Singleton
    StarWarsApi provideStarWarsApi() {
        return new StarWarsApiRetrofit();
    }
}

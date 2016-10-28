package com.pietrantuono.offser.dagger.main;

import android.app.Activity;

import com.pietrantuono.offser.model.MainModel;
import com.pietrantuono.offser.model.MainModelImpl;
import com.pietrantuono.offser.presenter.MainViewPresenter;
import com.pietrantuono.offser.presenter.MainViewPresenterImplementation;
import com.pietrantuono.offser.model.api.StarWarsApi;
import com.pietrantuono.offser.model.api.StarWarsApiRetrofit;

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

    public StarWarsModule() {
    }

    @Provides
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

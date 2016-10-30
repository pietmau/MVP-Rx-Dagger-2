package com.pietrantuono.offser.dagger.main;

import android.support.annotation.NonNull;

import com.pietrantuono.offser.StarWarsApplication;
import com.pietrantuono.offser.model.StarWarsModel;
import com.pietrantuono.offser.model.StarWarsModelRetrofit;
import com.pietrantuono.offser.model.api.StarWarsApi;
import com.pietrantuono.offser.main.presenter.MainViewPresenter;
import com.pietrantuono.offser.main.presenter.StarWarsMainViewPresenter;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Maurizio Pietrantuono, maurizio.pietrantuono@gmail.com.
 */
@Module
public class MainModule {
    @NonNull
    private final StarWarsApplication application;

    public MainModule(@NonNull StarWarsApplication application) {
        this.application = application;
    }

    @Provides
    MainViewPresenter provideMainViewPresenter() {
        return new StarWarsMainViewPresenter();
    }

    @Singleton
    @Provides
    StarWarsModel provideMainModel(StarWarsApplication app) {
        return new StarWarsModelRetrofit(app);
    }

    @Provides
    @Singleton
    StarWarsApi provideStarWarsApi() {
        return new StarWarsApiMock();
    }

    @Provides
    StarWarsApplication provideStarWarsApplication() {
        return application;
    }
}

package com.pietrantuono.offser.dagger.main;

import com.pietrantuono.offser.StarWarsApplication;
import com.pietrantuono.offser.main.presenter.MainViewPresenter;
import com.pietrantuono.offser.main.presenter.StarWarsMainViewPresenter;
import com.pietrantuono.offser.model.StarWarsModel;
import com.pietrantuono.offser.model.StarWarsModelRetrofit;
import com.pietrantuono.offser.model.api.StarWarsApi;
import com.pietrantuono.offser.model.api.StarWarsApiRetrofit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Maurizio Pietrantuono, maurizio.pietrantuono@gmail.com.
 */
@Module
public class MainModule {
    private final StarWarsApplication application;

    public MainModule(StarWarsApplication application) {
        this.application = application;
    }

    @Provides
    MainViewPresenter provideMainViewPresenter() {
        return new StarWarsMainViewPresenter();
    }

    @Singleton
    @Provides
    StarWarsModel provideMainModel(StarWarsApi starWarsApi, StarWarsApplication app) {
        return StarWarsModelRetrofit.getInstance(app);
    }

    @Provides
    @Singleton
    StarWarsApi provideStarWarsApi() {
        return new StarWarsApiRetrofit();
    }

    @Provides
    StarWarsApplication provideStarWarsApplication() {
        return application;
    }
}

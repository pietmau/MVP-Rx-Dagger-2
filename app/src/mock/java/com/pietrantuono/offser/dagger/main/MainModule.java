package com.pietrantuono.offser.dagger.main;

import com.pietrantuono.offser.StarWarsApplication;
import com.pietrantuono.offser.model.StarWarsModel;
import com.pietrantuono.offser.model.StarWarsModelImpl;
import com.pietrantuono.offser.model.api.StarWarsApi;
import com.pietrantuono.offser.presenter.main.MainViewPresenter;
import com.pietrantuono.offser.presenter.main.StarWarsMainViewPresenter;

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
        return  StarWarsModelImpl.getInstance(app);
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

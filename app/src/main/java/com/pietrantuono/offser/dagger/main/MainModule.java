package com.pietrantuono.offser.dagger.main;

import android.app.Activity;

import com.pietrantuono.offser.model.StarWarsModel;
import com.pietrantuono.offser.model.StarWarsModelImpl;
import com.pietrantuono.offser.presenter.MainViewPresenter;
import com.pietrantuono.offser.presenter.MainViewPresenterImplementation;
import com.pietrantuono.offser.model.api.StarWarsApi;
import com.pietrantuono.offser.model.api.StarWarsApiRetrofit;
import com.pietrantuono.offser.view.films.FilmsFragment;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Maurizio Pietrantuono, maurizio.pietrantuono@gmail.com.
 */
@Module
public class MainModule {
    private Activity activity;

    public MainModule(Activity activity) {
        this.activity = activity;
    }

    @Provides
    MainViewPresenter provideMainViewPresenter(StarWarsModel module) {
        return new MainViewPresenterImplementation(module);
    }

    @Provides
    @Singleton
    StarWarsModel provideMainModel(StarWarsApi starWarsApi) {
        return StarWarsModelImpl.getInstance(activity, starWarsApi);
    }

    @Provides
    @Singleton
    StarWarsApi provideStarWarsApi() {
        return new StarWarsApiRetrofit();
    }

    @Provides
    @Singleton
    FilmsFragment provideFilmsFragment() {
        return FilmsFragment.newInstance();
    }
}

package com.pietrantuono.offser.dagger.films;

import com.pietrantuono.offser.model.api.StarWarsApi;
import com.pietrantuono.offser.presenter.films.FilmPresenterImpl;
import com.pietrantuono.offser.presenter.films.FilmsPresenter;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Maurizio Pietrantuono, maurizio.pietrantuono@gmail.com.
 */
@Module
public class FilmsModule {

    @Provides
    FilmsPresenter provideFilmsPresenter(StarWarsApi starWarsApi){
        return new FilmPresenterImpl(starWarsApi);
    }
}

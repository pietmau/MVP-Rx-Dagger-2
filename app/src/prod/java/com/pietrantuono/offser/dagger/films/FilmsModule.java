package com.pietrantuono.offser.dagger.films;

import com.pietrantuono.offser.model.StarWarsModel;
import com.pietrantuono.offser.presenter.films.FilmsPresenter;
import com.pietrantuono.offser.presenter.films.StarWarsFilmPresenter;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Maurizio Pietrantuono, maurizio.pietrantuono@gmail.com.
 */
@Module
public class FilmsModule {

    @Provides
    FilmsPresenter provideFilmsPresenter(StarWarsModel model){
        return new StarWarsFilmPresenter(model);
    }
}

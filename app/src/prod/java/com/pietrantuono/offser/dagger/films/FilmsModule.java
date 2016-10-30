package com.pietrantuono.offser.dagger.films;

import com.pietrantuono.offser.films.presenter.FilmsPresenter;
import com.pietrantuono.offser.films.presenter.StarWarsFilmPresenter;
import com.pietrantuono.offser.model.StarWarsModel;


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

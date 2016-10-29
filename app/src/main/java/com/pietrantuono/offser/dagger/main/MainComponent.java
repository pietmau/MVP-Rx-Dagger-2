package com.pietrantuono.offser.dagger.main;

import com.pietrantuono.offser.model.StarWarsModel;
import com.pietrantuono.offser.model.api.StarWarsApi;
import com.pietrantuono.offser.view.films.FilmsFragment;
import com.pietrantuono.offser.view.main.MainActivity;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Maurizio Pietrantuono, maurizio.pietrantuono@gmail.com.
 */
@Singleton
@Component(modules = {MainModule.class})
public interface MainComponent {

    void inject(MainActivity mainActivity);

    StarWarsApi provideStarWarsApi();

    StarWarsModel provideFilmsStarWarsModel();
}

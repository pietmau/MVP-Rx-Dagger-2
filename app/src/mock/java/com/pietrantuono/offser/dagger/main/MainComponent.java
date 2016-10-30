package com.pietrantuono.offser.dagger.main;

import com.pietrantuono.offser.StarWarsApplication;
import com.pietrantuono.offser.model.StarWarsModel;
import com.pietrantuono.offser.main.view.MainActivity;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Maurizio Pietrantuono, maurizio.pietrantuono@gmail.com.
 */
@Singleton
@Component(modules = {MainModule.class})
public interface MainComponent {

    void inject(MainActivity mainActivity);

    void inject(StarWarsApplication application);

    StarWarsModel provideFilmsStarWarsModel();
}

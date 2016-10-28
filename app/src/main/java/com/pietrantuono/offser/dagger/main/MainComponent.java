package com.pietrantuono.offser.dagger.main;

import com.pietrantuono.offser.model.api.StarWarsApi;
import com.pietrantuono.offser.view.main.MainActivity;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Maurizio Pietrantuono, maurizio.pietrantuono@gmail.com.
 */
@Singleton
@Component(modules = {StarWarsModule.class})
public interface MainComponent {

    void inject(MainActivity mainActivity);

    StarWarsApi provideStarWarsApi();
}

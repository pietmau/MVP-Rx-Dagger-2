package com.pietrantuono.offser.dagger;

import com.pietrantuono.offser.MainActivity;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Maurizio Pietrantuono, maurizio.pietrantuono@gmail.com.
 */
@Singleton // TODO sicuri???
@Component(modules = {StarWarsModule.class})
public interface MainComponent {

    void inject(MainActivity mainActivity);
}

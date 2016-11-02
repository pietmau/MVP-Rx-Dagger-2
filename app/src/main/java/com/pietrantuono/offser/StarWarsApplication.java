package com.pietrantuono.offser;

import android.app.Application;

import com.pietrantuono.offser.dagger.main.DaggerMainComponent;
import com.pietrantuono.offser.dagger.main.MainComponent;
import com.pietrantuono.offser.dagger.main.MainModule;

/**
 * Created by Maurizio Pietrantuono, maurizio.pietrantuono@gmail.com.
 */

public class StarWarsApplication extends Application {
    private MainComponent injector;

    @Override
    public void onCreate() {
        super.onCreate();
        injector = DaggerMainComponent.builder()
                .mainModule(new MainModule())
                .build();
        injector.inject(StarWarsApplication.this);
    }

    public MainComponent getInjector() {
        return injector;
    }
}

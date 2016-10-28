package com.pietrantuono.offser.dagger;

import android.app.Activity;

import com.pietrantuono.offser.MainModel;
import com.pietrantuono.offser.MainModelImpl;
import com.pietrantuono.offser.MainViewPresenter;
import com.pietrantuono.offser.MainViewPresenterImplementation;

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
    @Singleton
    MainViewPresenter provideMainViewPresenter(MainModel module){
        return new MainViewPresenterImplementation(module);
    }

    @Provides
    @Singleton
    MainModel provideMainModel(){
        return MainModelImpl.getInstance(activity);
    }
}

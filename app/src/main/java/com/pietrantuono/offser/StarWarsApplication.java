package com.pietrantuono.offser;

import android.app.Application;
import android.util.Log;

import com.pietrantuono.offser.dagger.main.DaggerMainComponent;
import com.pietrantuono.offser.dagger.main.MainComponent;
import com.pietrantuono.offser.dagger.main.MainModule;
import com.pietrantuono.offser.model.api.StarWarsApi;
import com.pietrantuono.offser.model.api.pojos.AllFilms;
import com.pietrantuono.offser.model.api.pojos.AllPeople;

import java.io.InterruptedIOException;

import javax.inject.Inject;

import rx.Observable;

/**
 * Created by Maurizio Pietrantuono, maurizio.pietrantuono@gmail.com.
 */

public class StarWarsApplication extends Application {
    private Observable<AllFilms> cachedFilmsObservable;
    private Observable<AllPeople> cachedPeopleObservable;
    private MainComponent injector;
    @Inject
    StarWarsApi starWarsApi;

    @Override
    public void onCreate() {
        super.onCreate();
        injector = DaggerMainComponent.builder()
                .mainModule(new MainModule(StarWarsApplication.this))
                .build();
        injector.inject(StarWarsApplication.this);
        cachedFilmsObservable = starWarsApi.getAllFilms().retryWhen(exceptions -> exceptions.flatMap(exception -> {
                    // We retry only in this case
                    if (exception instanceof InterruptedIOException) {
                        return Observable.just(null);
                    }
                    return Observable.error(exception);
                })
        ).cache();
        cachedPeopleObservable = starWarsApi.getAllPeople().retryWhen(exceptions -> exceptions.flatMap(exception -> {
                    // We retry only in this case
                    if (exception instanceof InterruptedIOException) {
                        return Observable.just(null);
                    }
                    return Observable.error(exception);
                })
        ).cache();
    }

    public MainComponent getInjector() {
        return injector;
    }

    public Observable<AllFilms> getCachedFilmsObservable() {
        return cachedFilmsObservable;
    }

    public Observable<AllPeople> getCachedPeopleObservable() {
        return cachedPeopleObservable;
    }

}

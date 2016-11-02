package com.pietrantuono.offser.dagger.main;

import android.support.annotation.NonNull;

import com.pietrantuono.offser.StarWarsApplication;
import com.pietrantuono.offser.main.presenter.MainViewPresenter;
import com.pietrantuono.offser.main.presenter.StarWarsMainViewPresenter;
import com.pietrantuono.offser.model.StarWarsModel;
import com.pietrantuono.offser.model.StarWarsModelRetrofit;
import com.pietrantuono.offser.model.api.StarWarsApi;
import com.pietrantuono.offser.model.api.StarWarsApiRetrofit;
import com.pietrantuono.offser.model.api.pojos.AllFilms;
import com.pietrantuono.offser.model.api.pojos.AllPeople;

import java.io.InterruptedIOException;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import rx.Observable;

/**
 * Created by Maurizio Pietrantuono, maurizio.pietrantuono@gmail.com.
 */
@Module
public class MainModule {
    @Provides
    MainViewPresenter provideMainViewPresenter() {
        return new StarWarsMainViewPresenter();
    }

    @Singleton
    @Provides
    StarWarsModel provideMainModel(Observable<AllPeople> allPeopleObservable, Observable<AllFilms> allFilmsObservable) {
        return new StarWarsModelRetrofit(allPeopleObservable, allFilmsObservable);
    }

    @Provides
    @Singleton
    StarWarsApi provideStarWarsApi() {
        return new StarWarsApiMock();
    }

    @Singleton
    @Provides
    Observable<AllFilms> provideAllFilms(StarWarsApi starWarsApi) {
        return starWarsApi.getAllFilms().retryWhen(exceptions -> exceptions.flatMap(exception -> {
                    // We retry only in this case
                    if (exception instanceof InterruptedIOException) {
                        return Observable.just(null);
                    }
                    return Observable.error(exception);
                })
        ).cache();
    }

    @Singleton
    @Provides
    Observable<AllPeople> provideAllPeople(StarWarsApi starWarsApi) {
        return starWarsApi.getAllPeople().retryWhen(exceptions -> exceptions.flatMap(exception -> {
                    // We retry only in this case
                    if (exception instanceof InterruptedIOException) {
                        return Observable.just(null);
                    }
                    return Observable.error(exception);
                })
        ).cache();
    }
}

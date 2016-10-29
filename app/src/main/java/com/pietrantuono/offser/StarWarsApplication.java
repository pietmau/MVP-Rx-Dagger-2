package com.pietrantuono.offser;

import android.app.Application;

import com.pietrantuono.offser.model.api.pojos.AllFilms;
import com.pietrantuono.offser.model.api.pojos.AllPeople;

import rx.Observable;

/**
 * Created by Maurizio Pietrantuono, maurizio.pietrantuono@gmail.com.
 */

public class StarWarsApplication extends Application {
    public Observable<AllFilms> cachedFilmsObservable;
    public Observable<AllPeople> cachedPeopleObservable;
}

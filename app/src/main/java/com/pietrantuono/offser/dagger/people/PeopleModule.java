package com.pietrantuono.offser.dagger.people;

import com.pietrantuono.offser.model.StarWarsModel;
import com.pietrantuono.offser.presenter.people.PeoplePresenter;
import com.pietrantuono.offser.presenter.people.PeoplePresenterImpl;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Maurizio Pietrantuono, maurizio.pietrantuono@gmail.com.
 */
@Module
public class PeopleModule {

    @Provides
    PeoplePresenter providePeoplePresenter(StarWarsModel model){
        return new PeoplePresenterImpl(model);
    }
}

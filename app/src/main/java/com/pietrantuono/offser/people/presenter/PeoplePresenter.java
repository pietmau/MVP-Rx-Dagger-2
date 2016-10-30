package com.pietrantuono.offser.people.presenter;

import com.pietrantuono.offser.people.view.PeopleView;

/**
 * Created by Maurizio Pietrantuono, maurizio.pietrantuono@gmail.com.
 */
public interface PeoplePresenter extends StarWarsListPresenter{

    void setView(PeopleView peopleView);
}

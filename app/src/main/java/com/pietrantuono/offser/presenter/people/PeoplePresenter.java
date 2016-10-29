package com.pietrantuono.offser.presenter.people;

import com.pietrantuono.offser.view.films.FilmsView;
import com.pietrantuono.offser.view.films.StarWarsListView;
import com.pietrantuono.offser.view.persons.PeopleView;

/**
 * Created by Maurizio Pietrantuono, maurizio.pietrantuono@gmail.com.
 */
public interface PeoplePresenter extends StarWarsListPresenter{

    void setView(PeopleView peopleView);
}

package com.pietrantuono.offser.view.persons;

import com.pietrantuono.offser.model.api.pojos.Film;
import com.pietrantuono.offser.model.api.pojos.Person;
import com.pietrantuono.offser.view.films.StarWarsListView;

import java.util.List;

/**
 * Created by Maurizio Pietrantuono, maurizio.pietrantuono@gmail.com.
 */

public interface PeopleView extends StarWarsListView{

    void showPersons(List<Person> persons);
}

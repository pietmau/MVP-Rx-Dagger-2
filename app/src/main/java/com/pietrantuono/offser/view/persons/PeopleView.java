package com.pietrantuono.offser.view.persons;

import com.pietrantuono.offser.model.api.pojos.Person;
import com.pietrantuono.offser.view.films.StarWarsView;

import java.util.List;

/**
 * Created by Maurizio Pietrantuono, maurizio.pietrantuono@gmail.com.
 */

public interface PeopleView extends StarWarsView {

    void showPersons(List<Person> persons);
}

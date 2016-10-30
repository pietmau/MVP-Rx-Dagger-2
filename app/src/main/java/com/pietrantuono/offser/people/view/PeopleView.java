package com.pietrantuono.offser.people.view;

import com.pietrantuono.offser.model.api.pojos.Person;
import com.pietrantuono.offser.films.view.StarWarsView;

import java.util.List;

/**
 * Created by Maurizio Pietrantuono, maurizio.pietrantuono@gmail.com.
 */

public interface PeopleView extends StarWarsView {

    void showPersons(List<Person> persons);
}

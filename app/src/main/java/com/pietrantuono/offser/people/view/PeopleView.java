package com.pietrantuono.offser.people.view;

import android.support.annotation.NonNull;

import com.pietrantuono.offser.model.api.pojos.Person;
import com.pietrantuono.offser.shared.StarWarsView;

import java.util.List;

/**
 * Created by Maurizio Pietrantuono, maurizio.pietrantuono@gmail.com.
 */

public interface PeopleView extends StarWarsView {

    void showPersons(@NonNull List<Person> persons);
}

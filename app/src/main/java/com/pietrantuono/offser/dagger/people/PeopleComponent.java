package com.pietrantuono.offser.dagger.people;

import com.pietrantuono.offser.dagger.films.FilmFragmentScope;
import com.pietrantuono.offser.dagger.films.FilmsModule;
import com.pietrantuono.offser.dagger.main.MainComponent;
import com.pietrantuono.offser.view.films.FilmsFragment;
import com.pietrantuono.offser.view.persons.PeopleFragment;

import dagger.Component;

/**
 * Created by Maurizio Pietrantuono, maurizio.pietrantuono@gmail.com.
 */
@PeopleFragmentScope
@Component(
        dependencies = MainComponent.class,
        modules = {PeopleModule.class}
)
public interface PeopleComponent {

    void inject(PeopleFragment peopleFragment);
}

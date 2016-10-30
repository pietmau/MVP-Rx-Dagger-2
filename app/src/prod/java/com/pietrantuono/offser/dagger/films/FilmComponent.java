package com.pietrantuono.offser.dagger.films;

import com.pietrantuono.offser.dagger.main.MainComponent;
import com.pietrantuono.offser.films.view.FilmsFragment;

import dagger.Component;

/**
 * Created by Maurizio Pietrantuono, maurizio.pietrantuono@gmail.com.
 */
@FilmFragmentScope
@Component(
        dependencies = MainComponent.class,
        modules = {FilmsModule.class}
)
public interface FilmComponent {

    void inject(FilmsFragment filmsFragment);
}

package com.pietrantuono.offser.films.presenter;

import com.pietrantuono.offser.films.view.FilmsView;
import com.pietrantuono.offser.people.presenter.StarWarsListPresenter;

/**
 * Created by Maurizio Pietrantuono, maurizio.pietrantuono@gmail.com.
 */
public interface FilmsPresenter extends StarWarsListPresenter {

    void setView(FilmsView filmsView);
}

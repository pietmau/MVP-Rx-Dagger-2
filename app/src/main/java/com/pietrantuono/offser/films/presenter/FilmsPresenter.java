package com.pietrantuono.offser.films.presenter;

import android.support.annotation.NonNull;

import com.pietrantuono.offser.films.view.FilmsView;
import com.pietrantuono.offser.shared.StarWarsPresenter;

/**
 * Created by Maurizio Pietrantuono, maurizio.pietrantuono@gmail.com.
 */
public interface FilmsPresenter extends StarWarsPresenter {

    void setView(@NonNull FilmsView filmsView);
}

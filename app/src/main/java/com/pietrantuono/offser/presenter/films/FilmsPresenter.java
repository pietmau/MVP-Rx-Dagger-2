package com.pietrantuono.offser.presenter.films;

import com.pietrantuono.offser.view.films.FilmsView;

/**
 * Created by Maurizio Pietrantuono, maurizio.pietrantuono@gmail.com.
 */
public interface FilmsPresenter {
    void onPause();

    void onResume();

    void setView(FilmsView filmsView);
}

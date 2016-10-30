package com.pietrantuono.offser.films.presenter;

import com.pietrantuono.offser.films.view.FilmsView;

/**
 * Created by Maurizio Pietrantuono, maurizio.pietrantuono@gmail.com.
 */
public interface FilmsPresenter {
    void onPause();

    void onResume();

    void setView(FilmsView filmsView);
}

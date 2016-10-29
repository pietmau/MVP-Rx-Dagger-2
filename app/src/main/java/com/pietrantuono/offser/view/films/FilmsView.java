package com.pietrantuono.offser.view.films;

import com.pietrantuono.offser.model.api.pojos.Film;

import java.util.List;

/**
 * Created by Maurizio Pietrantuono, maurizio.pietrantuono@gmail.com.
 */
public interface FilmsView {
    void showFilms(List<Film> films);

    void showError(String message);
}

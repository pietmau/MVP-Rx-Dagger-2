package com.pietrantuono.offser.films.view;

import android.support.annotation.NonNull;

import com.pietrantuono.offser.model.api.pojos.Film;
import com.pietrantuono.offser.shared.StarWarsView;

import java.util.List;

/**
 * Created by Maurizio Pietrantuono, maurizio.pietrantuono@gmail.com.
 */
public interface FilmsView extends StarWarsView {

    void showFilms(@NonNull List<Film> films);
}

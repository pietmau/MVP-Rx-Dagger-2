package com.pietrantuono.offser.view.films;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.pietrantuono.offser.R;
import com.pietrantuono.offser.dagger.films.DaggerFilmComponent;
import com.pietrantuono.offser.dagger.films.FilmsModule;
import com.pietrantuono.offser.presenter.films.FilmsPresenter;

import javax.inject.Inject;


public class FilmsFragment extends Fragment {
    public static final String FILMS_TAG = "films";
    @Inject
    FilmsPresenter filmsPresenter;

    public FilmsFragment() {
    }

    public static FilmsFragment newInstance() {
        return new FilmsFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_films, container, false);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DaggerFilmComponent.builder().
        foo();
    }

    private void foo() {

    }
}

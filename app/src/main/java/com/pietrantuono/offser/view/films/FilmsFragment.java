package com.pietrantuono.offser.view.films;


import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.pietrantuono.offser.R;
import com.pietrantuono.offser.dagger.films.DaggerFilmComponent;
import com.pietrantuono.offser.dagger.films.FilmsModule;
import com.pietrantuono.offser.dagger.main.MainComponent;
import com.pietrantuono.offser.presenter.films.FilmsPresenter;
import com.pietrantuono.offser.view.main.MainActivity;

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
        DaggerFilmComponent.builder()
                .mainComponent(getMainComponenet())
                .filmsModule(new FilmsModule())
                .build()
                .inject(FilmsFragment.this);
    }

    private MainComponent getMainComponenet() {
        return ((MainActivity) getActivity()).getMainComponent();
    }

    private void foo() {

    }
}

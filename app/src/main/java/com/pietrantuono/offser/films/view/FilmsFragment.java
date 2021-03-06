package com.pietrantuono.offser.films.view;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.ViewAnimator;

import com.pietrantuono.offser.R;
import com.pietrantuono.offser.dagger.films.DaggerFilmComponent;
import com.pietrantuono.offser.dagger.films.FilmsModule;
import com.pietrantuono.offser.dagger.main.MainComponent;
import com.pietrantuono.offser.model.api.pojos.Film;
import com.pietrantuono.offser.films.presenter.FilmsPresenter;
import com.pietrantuono.offser.main.view.MainActivity;

import java.util.List;

import javax.inject.Inject;


public class FilmsFragment extends Fragment implements FilmsView {
    public static final String FILMS_TAG = "films";
    @Inject
    FilmsPresenter filmsPresenter;
    private RecyclerView recyclerView;
    private ViewAnimator switcher;
    private TextView errorText;

    public FilmsFragment() {
    }

    public static FilmsFragment newInstance() {
        return new FilmsFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        switcher = (ViewAnimator) view.findViewById(R.id.switcher);
        errorText = (TextView) view.findViewById(R.id.error);
        return view;
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        DaggerFilmComponent.builder()
                .mainComponent(getMainComponent())
                .filmsModule(new FilmsModule())
                .build()
                .inject(FilmsFragment.this);
        filmsPresenter.setView(FilmsFragment.this);
    }

    @Override
    public void onPause() {
        super.onPause();
        filmsPresenter.onPause();
    }

    @Override
    public void onResume() {
        super.onResume();
        filmsPresenter.onResume();
    }

    private MainComponent getMainComponent() {
        return ((MainActivity) getActivity()).getInjector();
    }

    @Override
    public void showFilms(@NonNull List<Film> films) {
        switcher.setDisplayedChild(1);
        recyclerView.setAdapter(new FilmsAdapter(films));
    }

    @Override
    public void showError(@Nullable String message) {
        switcher.setDisplayedChild(2);
        if (message != null) {
            errorText.setText(message);
        }
    }
}

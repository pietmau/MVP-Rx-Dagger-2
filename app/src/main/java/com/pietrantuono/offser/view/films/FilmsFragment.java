package com.pietrantuono.offser.view.films;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.pietrantuono.offser.R;

import javax.inject.Inject;


public class FilmsFragment extends Fragment {
    @Inject FilmsPresenter filmsPresenter;

    public FilmsFragment() {
    }

    public static FilmsFragment newInstance() {
        return new FilmsFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_films, container, false);
    }

}

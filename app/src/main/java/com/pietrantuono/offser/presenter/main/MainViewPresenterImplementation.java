package com.pietrantuono.offser.presenter.main;

import android.app.Activity;
import android.os.Bundle;

import com.pietrantuono.offser.model.StarWarsModel;
import com.pietrantuono.offser.presenter.main.MainViewPresenter;
import com.pietrantuono.offser.view.main.MainView;

/**
 * Created by Maurizio Pietrantuono, maurizio.pietrantuono@gmail.com.
 */
public class MainViewPresenterImplementation implements MainViewPresenter {
    private MainView mainView;

    public MainViewPresenterImplementation() {
    }

    @Override
    public void onCreate(MainView mainView, Bundle savedInstanceState) {
        this.mainView = mainView;
        if (savedInstanceState == null) {
            mainView.navigateToFilms();
        }
    }

    @Override
    public void onGoToFilmsClicked() {
        mainView.navigateToFilms();
    }

    @Override
    public void onGoToPersonsClicked() {
        mainView.navigateToPersons();
    }

}

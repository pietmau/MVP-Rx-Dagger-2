package com.pietrantuono.offser.presenter;

import android.os.Bundle;

import com.pietrantuono.offser.model.MainModel;
import com.pietrantuono.offser.presenter.MainViewPresenter;
import com.pietrantuono.offser.view.main.MainView;

import rx.Observable;

/**
 * Created by Maurizio Pietrantuono, maurizio.pietrantuono@gmail.com.
 */
public class MainViewPresenterImplementation implements MainViewPresenter {
    private MainView mainView;

    public MainViewPresenterImplementation(MainModel mainModel) {
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

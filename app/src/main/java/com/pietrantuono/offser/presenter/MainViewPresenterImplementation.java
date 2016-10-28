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
    public MainViewPresenterImplementation(MainModel mainModel) {
    }

    @Override
    public void onCreate(MainView mainView, Bundle savedInstanceState) {

    }

    @Override
    public void onDestroy() {

    }

    @Override
    public void onPause() {

    }

    @Override
    public void onResume() {

    }

    @Override
    public void addGoToFilmsObservable(Observable<Void> goToFilms) {

    }

    @Override
    public void onGoToFilmsClicked() {

    }
}

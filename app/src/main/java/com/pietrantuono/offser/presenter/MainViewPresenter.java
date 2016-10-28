package com.pietrantuono.offser.presenter;

import android.os.Bundle;

import com.pietrantuono.offser.view.MainView;

import rx.Observable;

/**
 * Created by Maurizio Pietrantuono, maurizio.pietrantuono@gmail.com.
 */
public interface MainViewPresenter {

    void onCreate(MainView mainView, Bundle savedInstanceState);

    void onDestroy();

    void onPause();

    void onResume();

    void addGoToFilmsObservable(Observable<Void> goToFilms);
}

package com.pietrantuono.offser.presenter;

import android.os.Bundle;

import com.pietrantuono.offser.view.main.MainView;

import rx.Observable;

/**
 * Created by Maurizio Pietrantuono, maurizio.pietrantuono@gmail.com.
 */
public interface MainViewPresenter {

    void onCreate(MainView mainView, Bundle savedInstanceState);

    void onGoToFilmsClicked();

    void onGoToPersonsClicked();
    
}

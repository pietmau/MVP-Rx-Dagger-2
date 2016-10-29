package com.pietrantuono.offser.presenter.main;

import android.app.Activity;
import android.os.Bundle;

import com.pietrantuono.offser.view.main.MainActivity;
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

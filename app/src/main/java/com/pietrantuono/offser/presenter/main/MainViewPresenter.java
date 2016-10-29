package com.pietrantuono.offser.presenter.main;

import android.os.Bundle;
import android.view.MenuItem;

import com.pietrantuono.offser.view.main.MainView;

/**
 * Created by Maurizio Pietrantuono, maurizio.pietrantuono@gmail.com.
 */
public interface MainViewPresenter {

    void onCreate(MainView mainView, Bundle savedInstanceState);

    void onGoToFilmsClicked();

    void onGoToPersonsClicked();

    boolean onNavigationItemSelected(MenuItem item);
}

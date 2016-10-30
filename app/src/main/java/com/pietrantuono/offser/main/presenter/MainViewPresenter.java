package com.pietrantuono.offser.main.presenter;

import android.os.Bundle;
import android.view.MenuItem;

import com.pietrantuono.offser.main.view.MainView;

/**
 * Created by Maurizio Pietrantuono, maurizio.pietrantuono@gmail.com.
 */
public interface MainViewPresenter {

    void onCreate(MainView mainView, Bundle savedInstanceState);

    void onGoToFilmsClicked();

    void onGoToPersonsClicked();

    boolean onNavigationItemSelected(MenuItem item);
}

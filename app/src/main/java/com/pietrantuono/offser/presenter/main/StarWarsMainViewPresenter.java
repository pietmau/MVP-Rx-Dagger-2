package com.pietrantuono.offser.presenter.main;

import android.os.Bundle;
import android.view.MenuItem;

import com.pietrantuono.offser.R;
import com.pietrantuono.offser.presenter.main.MainViewPresenter;
import com.pietrantuono.offser.view.main.MainView;

/**
 * Created by Maurizio Pietrantuono, maurizio.pietrantuono@gmail.com.
 */
public class StarWarsMainViewPresenter implements MainViewPresenter {
    private MainView mainView;

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

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.people:
                onGoToPersonsClicked();
                break;
            case R.id.films:
                onGoToFilmsClicked();
                break;
        }
        return true;
    }

}

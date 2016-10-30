package com.pietrantuono.offser.main.presenter;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.MenuItem;

import com.pietrantuono.offser.main.view.MainView;

/**
 * Created by Maurizio Pietrantuono, maurizio.pietrantuono@gmail.com.
 */
public interface MainViewPresenter {

    void onCreate(@NonNull MainView mainView, @Nullable Bundle savedInstanceState);

    void onGoToFilmsClicked();

    void onGoToPersonsClicked();

    boolean onNavigationItemSelected(MenuItem item);
}

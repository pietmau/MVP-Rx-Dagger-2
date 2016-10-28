package com.pietrantuono.offser;

import android.os.Bundle;

/**
 * Created by Maurizio Pietrantuono, maurizio.pietrantuono@gmail.com.
 */
public interface MainViewPresenter {

    void onCreate(MainView mainView, Bundle savedInstanceState);

    void onDestroy();

    void onPause();

    void onResume();
}

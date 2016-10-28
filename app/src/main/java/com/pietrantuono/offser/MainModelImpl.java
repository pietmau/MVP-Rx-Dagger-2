package com.pietrantuono.offser;

import android.app.Activity;

/**
 * Created by Maurizio Pietrantuono, maurizio.pietrantuono@gmail.com.
 */
public class MainModelImpl implements MainModel {

    public static MainModel getInstance(Activity activity) {
        return new MainModelImpl();
    }
}

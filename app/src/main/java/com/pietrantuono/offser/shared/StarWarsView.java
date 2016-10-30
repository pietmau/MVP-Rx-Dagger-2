package com.pietrantuono.offser.shared;

import android.support.annotation.Nullable;

/**
 * A common interface for the Views
 */
public interface StarWarsView {

    void showError(@Nullable String message);

    void showLoading();

}

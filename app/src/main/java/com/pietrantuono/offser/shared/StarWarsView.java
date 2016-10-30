package com.pietrantuono.offser.shared;

/**
 * A common interface for the Views
 */
public interface StarWarsView {

    void showError(String message);

    void showLoading();

    void hideLoading();
}

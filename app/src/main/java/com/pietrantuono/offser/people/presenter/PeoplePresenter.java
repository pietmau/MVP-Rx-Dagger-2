package com.pietrantuono.offser.people.presenter;

import android.support.annotation.NonNull;

import com.pietrantuono.offser.people.view.PeopleView;
import com.pietrantuono.offser.shared.StarWarsPresenter;

/**
 * Created by Maurizio Pietrantuono, maurizio.pietrantuono@gmail.com.
 */
public interface PeoplePresenter extends StarWarsPresenter {

    void setView(@NonNull PeopleView peopleView);
}

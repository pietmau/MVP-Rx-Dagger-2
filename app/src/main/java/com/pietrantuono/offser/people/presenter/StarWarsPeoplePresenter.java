package com.pietrantuono.offser.people.presenter;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.pietrantuono.offser.model.StarWarsModel;
import com.pietrantuono.offser.model.api.pojos.AllPeople;
import com.pietrantuono.offser.people.view.PeopleView;

import rx.Observer;

/**
 * Created by Maurizio Pietrantuono, maurizio.pietrantuono@gmail.com.
 */
public class StarWarsPeoplePresenter implements PeoplePresenter {
    @NonNull private final StarWarsModel starWarsModel;
    private PeopleView view;

    public StarWarsPeoplePresenter(@NonNull StarWarsModel starWarsModel) {
        this.starWarsModel = starWarsModel;
    }

    @Override
    public void setView(@NonNull PeopleView peopleView) {
        this.view = peopleView;
    }

    @Override
    public void onPause() {
        starWarsModel.unSubscribeToPeople();
    }

    @Override
    public void onResume() {
        starWarsModel.subscribeToPeople(new Observer<AllPeople>() {
            @Override
            public void onCompleted() {
            }

            @Override
            public void onError(Throwable e) {
                view.showError(e.getMessage());
            }

            @Override
            public void onNext(@Nullable AllPeople allPeople) {
                if (allPeople == null || allPeople.getPersons() == null) {
                    return;
                }
                view.showPersons(allPeople.getPersons());
            }
        });
    }


}


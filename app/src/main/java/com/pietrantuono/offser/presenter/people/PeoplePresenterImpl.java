package com.pietrantuono.offser.presenter.people;

import com.pietrantuono.offser.model.StarWarsModel;
import com.pietrantuono.offser.model.api.pojos.AllFilms;
import com.pietrantuono.offser.model.api.pojos.AllPeople;
import com.pietrantuono.offser.presenter.films.FilmsPresenter;
import com.pietrantuono.offser.view.films.FilmsView;
import com.pietrantuono.offser.view.persons.PeopleView;

import rx.Observer;

/**
 * Created by Maurizio Pietrantuono, maurizio.pietrantuono@gmail.com.
 */
public class PeoplePresenterImpl implements PeoplePresenter {
    private final StarWarsModel starWarsModel;
    private PeopleView view;
    private SimpleObserver simpleObserver;

    public PeoplePresenterImpl(StarWarsModel starWarsModel) {
        this.starWarsModel = starWarsModel;
        simpleObserver = new SimpleObserver();
    }

    @Override
    public void setView(PeopleView peopleView) {
        this.view = peopleView;
    }

    @Override
    public void onPause() {
        starWarsModel.unSubscribeToPeople();
    }

    @Override
    public void onResume() {
        starWarsModel.subscribeToPeople(simpleObserver);
    }

    private class SimpleObserver implements Observer<AllPeople> {

        @Override
        public void onCompleted() {
        }

        @Override
        public void onError(Throwable e) {
            view.showError(e.getMessage());
        }

        @Override
        public void onNext(AllPeople allPeople) {
            if (allPeople == null || allPeople.getPersons() == null) {
                return;
            }
            view.showPersons(allPeople.getPersons());
        }
    }
}


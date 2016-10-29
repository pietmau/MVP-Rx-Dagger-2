package com.pietrantuono.offser.view.persons;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.pietrantuono.offser.R;
import com.pietrantuono.offser.dagger.main.MainComponent;
import com.pietrantuono.offser.dagger.people.DaggerPeopleComponent;
import com.pietrantuono.offser.dagger.people.PeopleModule;
import com.pietrantuono.offser.model.api.pojos.Film;
import com.pietrantuono.offser.model.api.pojos.Person;
import com.pietrantuono.offser.presenter.people.PeoplePresenter;
import com.pietrantuono.offser.view.films.FilmsAdapter;
import com.pietrantuono.offser.view.main.MainActivity;

import java.util.List;

import javax.inject.Inject;


public class PeopleFragment extends Fragment implements PeopleView {
    public static final String PEOPLE_TAG = "persons";
    @Inject
    PeoplePresenter peoplePresenter;
    private RecyclerView recyclerView;

    public PeopleFragment() {
    }

    public static PeopleFragment newInstance() {
        return new PeopleFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_films, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.films_recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        return view;
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        super.onCreate(savedInstanceState);
        DaggerPeopleComponent.builder()
                .mainComponent(getMainComponenet())
                .peopleModule(new PeopleModule())
                .build()
                .inject(PeopleFragment.this);
        peoplePresenter.setView(PeopleFragment.this);
    }

    @Override
    public void onPause() {
        super.onPause();
        peoplePresenter.onPause();
    }

    @Override
    public void onResume() {
        super.onResume();
        peoplePresenter.onResume();
    }

    private MainComponent getMainComponenet() {
        return ((MainActivity) getActivity()).getMainComponent();
    }

    @Override
    public void showPersons(List<Person> persons) {
        recyclerView.setAdapter(new PeopleAdapter(persons));
    }

    @Override
    public void showError(String message) {

    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }


}

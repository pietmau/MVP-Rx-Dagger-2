package com.pietrantuono.offser.view.main;

import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.pietrantuono.offser.StarWarsApplication;
import com.pietrantuono.offser.dagger.main.DaggerMainComponent;
import com.pietrantuono.offser.dagger.main.MainComponent;
import com.pietrantuono.offser.dagger.main.MainModule;
import com.pietrantuono.offser.presenter.main.MainViewPresenter;
import com.pietrantuono.offser.R;
import com.pietrantuono.offser.view.films.FilmsFragment;
import com.pietrantuono.offser.view.persons.PeopleFragment;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity implements MainView {
    @Inject
    MainViewPresenter mainViewpresenter;
    private FragmentManager fragmentManager;
    private MainComponent injector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initViews();
        fragmentManager = getSupportFragmentManager();
        initDependencyGraph();
        mainViewpresenter.onCreate(MainActivity.this, savedInstanceState);
    }

    private void initViews() {
        setContentView(R.layout.activity_main);
        ((BottomNavigationView) findViewById(R.id.navigation))
                .setOnNavigationItemSelectedListener(item -> {
                    switch (item.getItemId()) {
                        case R.id.people:
                            mainViewpresenter.onGoToPersonsClicked();
                            break;
                        case R.id.films:
                            mainViewpresenter.onGoToFilmsClicked();
                            break;
                    }
                    return true;
                });
    }

    private void initDependencyGraph() {
        getInjector().inject(MainActivity.this);
    }

    @Override
    public void navigateToFilms() {
        FilmsFragment filmsFragment = (FilmsFragment) fragmentManager.findFragmentByTag(FilmsFragment.FILMS_TAG);
        if (filmsFragment == null) {
            filmsFragment = FilmsFragment.newInstance();
        }
        FragmentTransaction ft = fragmentManager.beginTransaction().replace(R.id.container, filmsFragment, FilmsFragment.FILMS_TAG);
        ft.commit();
    }

    @Override
    public void navigateToPersons() {
        PeopleFragment personsFragment = (PeopleFragment) fragmentManager.findFragmentByTag(PeopleFragment.PEOPLE_TAG);
        if (personsFragment == null) {
            personsFragment = PeopleFragment.newInstance();
        }
        FragmentTransaction ft = fragmentManager.beginTransaction().replace(R.id.container, personsFragment, PeopleFragment.PEOPLE_TAG);
        ft.commit();
    }

    public MainComponent getInjector() {
        return ((StarWarsApplication)getApplication()).getInjector();
    }
}

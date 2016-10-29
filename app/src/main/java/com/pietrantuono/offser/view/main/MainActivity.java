package com.pietrantuono.offser.view.main;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.pietrantuono.offser.dagger.main.DaggerMainComponent;
import com.pietrantuono.offser.dagger.main.MainComponent;
import com.pietrantuono.offser.dagger.main.MainModule;
import com.pietrantuono.offser.presenter.MainViewPresenter;
import com.pietrantuono.offser.R;
import com.pietrantuono.offser.view.films.FilmsFragment;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity implements MainView {
    @Inject
    MainViewPresenter mainViewpresenter;
    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initViews(savedInstanceState);
        fragmentManager = getSupportFragmentManager();
        initDependancyGraph();
        mainViewpresenter.onCreate(MainActivity.this, savedInstanceState);
    }

    private void initViews(Bundle savedInstanceState) {
        setContentView(R.layout.activity_main);
        findViewById(R.id.gotofilms).setOnClickListener(view -> mainViewpresenter.onGoToFilmsClicked());
        findViewById(R.id.gotopersons).setOnClickListener(view -> mainViewpresenter.onGoToPersonsClicked());
    }

    private void initDependancyGraph() {
        MainComponent injector = DaggerMainComponent.builder()
                .mainModule(new MainModule(MainActivity.this))
                .build();
        injector.inject(MainActivity.this);
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
        PersonsFragment personsFragment = (PersonsFragment) fragmentManager.findFragmentByTag(PersonsFragment.PERSONS_TAG);
        if (personsFragment == null) {
            personsFragment = PersonsFragment.newInstance();
        }
        FragmentTransaction ft = fragmentManager.beginTransaction().replace(R.id.container, personsFragment, PersonsFragment.PERSONS_TAG);
        ft.commit();
    }
}

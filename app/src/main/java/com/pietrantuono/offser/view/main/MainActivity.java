package com.pietrantuono.offser.view.main;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.pietrantuono.offser.dagger.main.DaggerMainComponent;
import com.pietrantuono.offser.presenter.MainViewPresenter;
import com.pietrantuono.offser.R;
import com.pietrantuono.offser.dagger.main.StarWarsModule;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity implements MainView {
    @Inject
    MainViewPresenter mainViewpresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initViews(savedInstanceState);
        initGraph();
        mainViewpresenter.onCreate(MainActivity.this, savedInstanceState);
    }

    private void initViews(Bundle savedInstanceState) {
        setContentView(R.layout.activity_main);
        findViewById(R.id.gotofilms).setOnClickListener(view -> mainViewpresenter.onGoToFilmsClicked());
    }

    private void initGraph() {
        DaggerMainComponent.builder()
                .starWarsModule(new StarWarsModule(MainActivity.this))
                .build()
                .inject(MainActivity.this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (!isChangingConfigurations()) {
            mainViewpresenter.onDestroy();
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        mainViewpresenter.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        mainViewpresenter.onResume();
    }

    @Override
    public void navigateToFilms() {
    }

    @Override
    public void navigateToPersons() {
    }
}

package com.pietrantuono.offser.view.main;

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
    private MainComponent mainComponent;
    private FilmsFragment ff;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initViews(savedInstanceState);
        initDependancyGraph();
        mainViewpresenter.onCreate(MainActivity.this, savedInstanceState);
    }

    private void initViews(Bundle savedInstanceState) {
        setContentView(R.layout.activity_main);
        findViewById(R.id.gotofilms).setOnClickListener(view -> mainViewpresenter.onGoToFilmsClicked());
    }

    private void initDependancyGraph() {
        mainComponent = DaggerMainComponent.builder()
                .mainModule(new MainModule(MainActivity.this))
                .build();
        mainComponent.inject(MainActivity.this);
        ff=mainComponent.provideFilmsFragment();
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

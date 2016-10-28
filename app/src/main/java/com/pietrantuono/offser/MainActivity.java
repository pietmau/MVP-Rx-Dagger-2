package com.pietrantuono.offser;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.pietrantuono.offser.dagger.DaggerMainComponent;
import com.pietrantuono.offser.dagger.MainModule;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity implements MainView {
    @Inject
    MainViewPresenter mainViewpresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initGraph();
        if (mainViewpresenter == null) throw new RuntimeException("fff");
    }

    private void initGraph() {
        DaggerMainComponent.builder()
                .mainModule(new MainModule(MainActivity.this))
                .build()
                .inject(MainActivity.this);
    }
}

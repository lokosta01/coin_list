package com.example.sokol.cointest;
import android.app.Application;

import com.example.sokol.cointest.di.component.AppComponent;
import com.example.sokol.cointest.di.component.DaggerAppComponent;
import com.example.sokol.cointest.di.module.AppModule;


public class App extends Application {

    private AppComponent appComponent;

    private static App instance;

    public static App getInstance() {
        return instance;
    }


    public AppComponent getAppComponent() {
        return appComponent;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        instance = this;
        appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .build();

    }
}

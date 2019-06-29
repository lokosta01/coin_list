package com.example.sokol.cointest.di.module;

import android.app.Application;

import com.example.sokol.cointest.storage.AppDatabase;
import com.example.sokol.cointest.storage.dao.CoinDao;

import javax.inject.Singleton;

import android.app.NotificationManager;
import androidx.room.Room;
import android.content.Context;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {
    private Application application;

    public AppModule(Application application) {
        this.application = application;
    }

    @Provides
    @Singleton
    Application provideApplication(){
  return application;
    }


    @Provides
    @Singleton
    AppDatabase provideDatabase(Application application ){
        return Room.inMemoryDatabaseBuilder(application, AppDatabase.class)
                .build();
    }


    @Provides
    NotificationManager provideNotificationManager(Application application){
        return (NotificationManager) application.getSystemService(Context.NOTIFICATION_SERVICE);
    }

    @Provides
    CoinDao provideCoinDao(AppDatabase database){
        return database.coinDao();
    }



}

package com.example.sokol.cointest.di.component;

import com.example.sokol.cointest.di.module.AppModule;
import com.example.sokol.cointest.di.module.RepositoryModule;
import com.example.sokol.cointest.di.module.ViewModelModule;
import com.example.sokol.cointest.network.ApiModule;
import com.example.sokol.cointest.ui.activity.main.MainActivity;
import com.example.sokol.cointest.ui.fragment.coin_info.CoinInfoFragment;
import com.example.sokol.cointest.ui.fragment.coin_list.ListFragment;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {AppModule.class, ApiModule.class, RepositoryModule.class, ViewModelModule.class})
public interface AppComponent {

    void inject(ListFragment fragment);
    void inject(MainActivity activity);
    void inject(CoinInfoFragment fragment);
}

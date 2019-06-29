package com.example.sokol.cointest.di.module;

import com.example.sokol.cointest.network.ApiService;
import com.example.sokol.cointest.network.repository.NetworkCoinSource;
import com.example.sokol.cointest.repository.CoinRepository;
import com.example.sokol.cointest.repository.ICoinRepository;
import com.example.sokol.cointest.repository.Repository;
import com.example.sokol.cointest.repository.source.ICoinSource;
import com.example.sokol.cointest.storage.AppDatabase;
import com.example.sokol.cointest.storage.dao.CoinDao;
import com.example.sokol.cointest.storage.repository.DatabaseCoinSource;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

@Module
public class RepositoryModule {


    // Coin
    @Provides
    @Named(Repository.DATABASE)
    public ICoinSource provideDatabaseOrderSource(CoinDao coinDao,  AppDatabase database) {
        return new DatabaseCoinSource(coinDao, database);
    }

    @Provides
    @Named(Repository.NETWORK)
    public ICoinSource provideNetworkCoinSource(ApiService apiService) {
        return new NetworkCoinSource(apiService);
    }

    @Provides
    public ICoinRepository provideCoinRepository(@Named(Repository.DATABASE) ICoinSource dbSource,
                                                              @Named(Repository.NETWORK) ICoinSource networkSource) {
        return new CoinRepository (dbSource, networkSource);
    }
}

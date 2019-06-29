package com.example.sokol.cointest.network.repository;

import com.example.sokol.cointest.network.ApiService;
import com.example.sokol.cointest.network.response.CoinList;
import com.example.sokol.cointest.repository.source.ICoinSource;
import com.example.sokol.cointest.storage.entity.Coin;

import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.schedulers.Schedulers;

public class NetworkCoinSource implements ICoinSource {

    private final ApiService api;

    public NetworkCoinSource(ApiService api) {
        this.api = api;
    }

    @Override
    public Observable<CoinList> getCoins() {
        return api.getCointList()
                .subscribeOn(Schedulers.io());
    }

    @Override
    public Observable<Coin> getCoin(long id) {
        return null;
    }

    @Override
    public void saveCoins(Coin[] coins) {
        throw new IllegalStateException("not implemented");

    }

    @Override
    public void saveCoin(Coin coin) {
        throw new IllegalStateException("not implemented");
    }
}

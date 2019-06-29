package com.example.sokol.cointest.repository;

import com.example.sokol.cointest.network.response.CoinList;
import com.example.sokol.cointest.storage.entity.Coin;

import io.reactivex.Observable;

public interface ICoinRepository {
    Observable<CoinList> getCoins();

    Observable<Coin> getCoin(long id);
}

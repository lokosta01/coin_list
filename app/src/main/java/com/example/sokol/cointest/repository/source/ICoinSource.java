package com.example.sokol.cointest.repository.source;

import com.example.sokol.cointest.network.response.CoinList;
import com.example.sokol.cointest.storage.entity.Coin;

import io.reactivex.Observable;

public interface ICoinSource {

Observable<CoinList> getCoins();

Observable<Coin> getCoin(long id);

void saveCoins(Coin[] coins);

void saveCoin(Coin coin);


}

package com.example.sokol.cointest.repository;

import com.example.sokol.cointest.network.response.CoinList;
import com.example.sokol.cointest.repository.source.ICoinSource;
import com.example.sokol.cointest.storage.entity.Coin;

import java.util.concurrent.TimeUnit;

import javax.inject.Named;

import io.reactivex.Observable;

public class CoinRepository implements ICoinRepository {

    private final ICoinSource dbSource;
    private final ICoinSource networkSource;

    public CoinRepository(@Named(Repository.DATABASE) ICoinSource dbSource,
                          @Named(Repository.NETWORK) ICoinSource networkSource) {
        this.dbSource = dbSource;
        this.networkSource = networkSource;
    }

    @Override
    public Observable<CoinList> getCoins() {
        return Observable.concatArray(
                dbSource.getCoins(),
                networkSource.getCoins()
                .doOnNext(coinList -> dbSource.saveCoins(coinList.getCoins()))
        )       .debounce(500,TimeUnit.MILLISECONDS);
    }

    @Override
    public Observable<Coin> getCoin(long id) {

        return dbSource.getCoin(id)
                .doOnNext(dbSource::saveCoin);
    }
}

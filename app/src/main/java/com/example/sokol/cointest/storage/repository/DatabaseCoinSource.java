package com.example.sokol.cointest.storage.repository;

//import com.example.sokol.cointest.network.response.Coin;
import com.example.sokol.cointest.network.response.CoinList;
import com.example.sokol.cointest.repository.source.ICoinSource;
import com.example.sokol.cointest.storage.AppDatabase;
import com.example.sokol.cointest.storage.dao.CoinDao;
import com.example.sokol.cointest.storage.entity.Coin;

import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;

public class DatabaseCoinSource implements ICoinSource {

    private final CoinDao coinDao;
    private final AppDatabase database;

    public DatabaseCoinSource(CoinDao coinDao, AppDatabase database) {
        this.coinDao = coinDao;
        this.database = database;
    }

    @Override
    public Observable<CoinList> getCoins() {
        return coinDao.getCoins()
                .subscribeOn(Schedulers.io())  //указать Scheduler, в котором будет выполняться процесс Observable.
                .map(CoinList::new)
                .toObservable();
    }

    @Override
    public Observable<Coin> getCoin(long id) {
        return coinDao.getCoin(id)
                .subscribeOn(Schedulers.io())
                .toObservable();
    }

    @Override
    public void saveCoins(Coin[] coins) {
      coinDao.deleteAll();
      for(Coin coin: coins){
          coinDao.insert(coin);
      }

    }

    @Override
    public void saveCoin(Coin coin) {
    coinDao.insert(coin);
    }
}

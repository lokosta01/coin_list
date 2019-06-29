package com.example.sokol.cointest.storage.dao;

import androidx.room.Dao;
import androidx.room.Query;

import com.example.sokol.cointest.storage.entity.Coin;

import io.reactivex.Maybe;

@Dao
public interface CoinDao extends BaseDao<Coin> {

@Query("SELECT * FROM 'coin'")
    Maybe<Coin[]> getCoins();

@Query("SELECT * FROM 'coin' WHERE id=:id")
    Maybe<Coin> getCoin(long id);

@Query("DELETE FROM 'coin'")
    int deleteAll();
}

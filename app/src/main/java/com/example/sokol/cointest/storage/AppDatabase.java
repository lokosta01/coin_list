package com.example.sokol.cointest.storage;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.sokol.cointest.storage.dao.CoinDao;
import com.example.sokol.cointest.storage.entity.Coin;


@Database(exportSchema = false, entities = {Coin.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract CoinDao coinDao();

}

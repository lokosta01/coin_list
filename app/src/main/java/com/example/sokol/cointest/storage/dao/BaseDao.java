package com.example.sokol.cointest.storage.dao;

import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Update;

import java.util.Collection;

public interface BaseDao<E> {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    long insert(E entity);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    long[] insert(Collection<E> entity);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    long[] insert(E[] entity);

    @Update
    int update(E entity);

    @Update
    int update(Iterable<E> entity);

    @Delete
    int delete(E entity);

    @Delete
    int delete(Iterable<E> entity);
}

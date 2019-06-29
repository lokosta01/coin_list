package com.example.sokol.cointest.storage.entity;


import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import androidx.room.Embedded;

@Entity(tableName = "Coin")
public class Coin {

    @PrimaryKey
    @ColumnInfo(name = "id")
    @SerializedName("id")
    @Expose
    public long id;   //?


    @ColumnInfo(name = "name")
    @SerializedName("name")
    @Expose
    public String name;


    @ColumnInfo(name = "symbol")
    @SerializedName("symbol")
    @Expose
    public String symbol;

    @ColumnInfo(name = "circulating_supply")
    @SerializedName("circulating_supply")
    @Expose
    public String supply;


    @Embedded(prefix = "quote_")
    @SerializedName("quote")
    @Expose
    public Quote quote;

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSymbol() {
        return symbol;
    }

    public Quote getQuote() {
        return quote;
    }

    public String getSupply() {
        return supply;
    }
}
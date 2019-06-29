package com.example.sokol.cointest.network.response;

import com.example.sokol.cointest.storage.entity.Status;
import com.example.sokol.cointest.storage.entity.Coin;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class
CoinList {

    @Expose
    @SerializedName("data")
    private Coin[] coins;

    @Expose
    @SerializedName("status")
    private Status status;

    public CoinList() {}

    public CoinList(Coin[] coins) {
        this.coins = coins;
    }

    public Coin[] getCoins() {
        return coins;
    }

    public Status getStatus() {
        return status;
    }
}
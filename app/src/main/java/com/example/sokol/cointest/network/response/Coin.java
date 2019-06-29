package com.example.sokol.cointest.network.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Coin {

    @Expose
    @SerializedName("data")
    private Coin coin;

    public Coin getCoin() {
        return coin;
    }
}

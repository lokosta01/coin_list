package com.example.sokol.cointest.network;

import com.example.sokol.cointest.network.response.CoinList;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface ApiService {
    @GET("/v1/cryptocurrency/listings/latest")
    Observable<CoinList> getCointList();
}

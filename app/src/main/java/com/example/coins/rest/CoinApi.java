package com.example.coins.rest;

import com.example.coins.rest.entities.Coin;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface CoinApi {

    @GET("coins/markets")
    Call<List<Coin>> getCoinsList(@Query("vs_currency") String currency, @Query("per_page") int per_page);

}

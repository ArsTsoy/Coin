package com.example.coins.rest;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NetworkService {
    private static NetworkService networkService = null;
    private Retrofit retrofit = null;

    private NetworkService() {
        retrofit = new Retrofit.Builder()
                .baseUrl(Config.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(new OkHttpClient.Builder().build())
                .build();
    }

    public static NetworkService getInstance() {
        if (networkService == null) {
            networkService = new NetworkService();
        }
        return networkService;
    }

    public CoinApi getCoinApi() {
        return retrofit.create(CoinApi.class);
    }
}

package com.example.coins;

import android.os.Bundle;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import com.example.coins.adapters.CoinAdapter;
import com.example.coins.rest.CoinApi;
import com.example.coins.rest.NetworkService;
import com.example.coins.rest.entities.Coin;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private CoinAdapter coinAdapter;
    private List<Coin> allCoins ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.rvCoin);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        coinAdapter = new CoinAdapter();
        allCoins = new ArrayList<>();
        recyclerView.setAdapter(coinAdapter);
        coinAdapter.setCoinList(allCoins);

        loadData();
    }


    private void loadData(){
        NetworkService networkService = NetworkService.getInstance();
        CoinApi coinApi = networkService.getCoinApi();

//        List<Coin> newCoins = new ArrayList<>();

        Call<List<Coin>> call = coinApi.getCoinsList("usd", 100);


//        Thread thread = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                try {
//                    Response<List<Coin>> response = call.execute();
//                    if(response.isSuccessful()) {
//                        List<Coin> coins = response.body();
//                        Log.i("myTag", "size " + coins.size());
//                        coinAdapter.setCoinList(coins);
//                    }
//                } catch (IOException e) {
//                    Log.e("myTag", e.getMessage());
//                    e.printStackTrace();
//                }
//            }
//        });



        call.enqueue(new Callback<List<Coin>>() {
            @Override
            public void onResponse(Call<List<Coin>> call, Response<List<Coin>> response) {
                Log.i("myTag", "onResponse1");

//                newCoins.addAll(coins);
                allCoins = response.body();
                Log.i("myTag", "size " + allCoins.size());
                coinAdapter.setCoinList(allCoins);

//                Log.e("myTag", "onResponse2 " + coins.get(0).getName());
            }

            @Override
            public void onFailure(Call<List<Coin>> call, Throwable t) {
                Toast.makeText(recyclerView.getContext(), "Error " + t.getMessage(), Toast.LENGTH_SHORT).show();
                Log.e("myTag", t.getMessage());
            }
        });
//
//        coinAdapter.setCoinList(newCoins);
//        Log.e("myTag", "onResponse2 ");
    }
}

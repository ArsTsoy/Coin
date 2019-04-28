package com.example.coins.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.example.coins.R;
import com.example.coins.rest.entities.Coin;

import java.util.ArrayList;
import java.util.List;

public class CoinAdapter extends RecyclerView.Adapter<CoinVH> {

    private View view;

    private List<Coin> coinList;

    public CoinAdapter() {
        this.coinList = new ArrayList<>();
    }


    public void setCoinList(List<Coin> coinList) {
        this.coinList.clear();
        this.coinList.addAll(coinList);
        Log.i("myTag", "setCoinsList " + coinList.size());
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public CoinVH onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_coin2, viewGroup, false);
        return new CoinVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CoinVH coinVH, int position) {
        Coin coin = coinList.get(position);

        coinVH.tvCurrencySymbol.setText(coin.getSymbol());
        coinVH.tvCurrencyName.setText(coin.getName());

        Glide.with(view)
                .load(coin.getImageURL())
                .into(coinVH.imCurrencyImage);

        String marketCap = view.getResources().getString(R.string.market_cap);
        String price = view.getResources().getString(R.string.price);
        coinVH.tvCurrencyMarketCap
                .setText(String.format(marketCap, "$", String.valueOf(coin.getMarket_cap())));
        coinVH.tvCurrencyPrice
                .setText(String.format(price, "$", String.valueOf(coin.getCurrent_price())));
    }

    @Override
    public int getItemCount() {
        return coinList.size();
    }
}

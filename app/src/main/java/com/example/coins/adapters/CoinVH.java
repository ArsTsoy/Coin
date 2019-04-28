package com.example.coins.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.coins.R;

public class CoinVH extends RecyclerView.ViewHolder {

    TextView tvCurrencySymbol, tvCurrencyName, tvCurrencyPrice, tvCurrencyMarketCap;
    ImageView imCurrencyImage;

    public CoinVH(@NonNull View itemView) {
        super(itemView);

        tvCurrencySymbol = itemView.findViewById(R.id.tvCurrencySym);
        tvCurrencyName = itemView.findViewById(R.id.tvCurrencyName);
        tvCurrencyPrice = itemView.findViewById(R.id.tvCurrencyPrice);
        tvCurrencyMarketCap = itemView.findViewById(R.id.tvCurrencyMarketCap);

        imCurrencyImage = itemView.findViewById(R.id.ivCurrencyIcon);
    }
}

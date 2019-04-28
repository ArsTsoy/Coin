package com.example.coins.rest.entities;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Coin implements Serializable {
    @Expose
    @SerializedName("id")
    private String id;

    @Expose
    @SerializedName("symbol")
    private String symbol;

    @Expose
    @SerializedName("name")
    private String name;

    @Expose
    @SerializedName("image")
    private String imageURL;

    @Expose
    @SerializedName("current_price")
    private double current_price;

    @Expose
    @SerializedName("market_cap")
    private double market_cap;

    @Expose
    @SerializedName("market_cap_rank")
    private int market_cap_rank;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public double getCurrent_price() {
        return current_price;
    }

    public void setCurrent_price(int current_price) {
        this.current_price = current_price;
    }

    public double getMarket_cap() {
        return market_cap;
    }

    public void setMarket_cap(int market_cap) {
        this.market_cap = market_cap;
    }

    public int getMarket_cap_rank() {
        return market_cap_rank;
    }

    public void setMarket_cap_rank(int market_cap_rank) {
        this.market_cap_rank = market_cap_rank;
    }
}

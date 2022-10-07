package com.info.cryptotracker

import com.google.gson.annotations.SerializedName

data class CryptosItemDetail(

    @SerializedName("id")
    val id:String,
    @SerializedName("symbol")
    val symbol:String,
    @SerializedName("name")
    val name:String,
    @SerializedName("description")
    val description:Us,
    @SerializedName("links")
    val links:Homepage,
    @SerializedName("image")
    val image:Thumnb,
    @SerializedName("coingecko_rank")
    val coingecko_rank:Int,
    @SerializedName("market_data")
    val market_data:Market_data,

    )
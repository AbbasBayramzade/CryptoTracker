package com.info.cryptotracker

import com.google.gson.annotations.SerializedName

data class Current_price(
    @SerializedName("usd")
    val usd:Int
)
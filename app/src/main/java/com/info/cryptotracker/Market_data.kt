package com.info.cryptotracker

import com.google.gson.annotations.SerializedName

data class Market_data (
    @SerializedName("current_price")
    val current_price:Current_price
)
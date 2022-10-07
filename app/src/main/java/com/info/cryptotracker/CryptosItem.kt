package com.info.cryptotracker

import com.google.gson.annotations.SerializedName

data class CryptosItem (

    @SerializedName("id")
    val id:String,
    @SerializedName("symbol")
    val symbol:String,
    @SerializedName("name")
    val name:String

)


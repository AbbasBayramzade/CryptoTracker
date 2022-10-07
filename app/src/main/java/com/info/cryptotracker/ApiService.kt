package com.info.cryptotracker

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

    @GET("api/v3/coins/list")
    fun getCryptos(): Call<List<CryptosItem>>

    @GET("api/v3/coins/{id}")
    fun getCryptoDetails(@Path("id") id: String):Call<CryptosItemDetail>

}
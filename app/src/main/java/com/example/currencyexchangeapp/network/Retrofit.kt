package com.example.currencyexchangeapp.network

import com.example.currencyexchangeapp.methods.ApiMethods
import com.google.gson.Gson
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Retrofit {
    private val retrofitClient: Retrofit.Builder by lazy {
        Retrofit.Builder().baseUrl("https://currency-exchange.p.rapidapi.com/")
            .addConverterFactory(GsonConverterFactory.create(Gson()))
    }

    val apiCall: ApiMethods by lazy {
        retrofitClient.build().create(ApiMethods::class.java)
    }

}
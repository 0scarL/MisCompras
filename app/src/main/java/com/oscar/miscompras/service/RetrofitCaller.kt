package com.example.miscompras.service

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object RetrofitCaller {
    
    fun getRetrofit(): Retrofit{
        return Retrofit.Builder()
            .baseUrl("https://api.mercadolibre.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val service = getRetrofit().create(ProductoEndPoints::class.java )
}
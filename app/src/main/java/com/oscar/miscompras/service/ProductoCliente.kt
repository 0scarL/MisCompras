package com.example.miscompras.service

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object ProductoCliente {
    private val retrofit = Retrofit.Builder()
        .baseUrl("https://api.mercadolibre.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val service = retrofit.create(ProductoEndPoints::class.java )
}
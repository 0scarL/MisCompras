package com.example.miscompras.service

import com.example.miscompras.model.ProductModelResult


import retrofit2.http.GET
import retrofit2.http.Query

interface ProductoEndPoints {

    @GET("sites/MLA/search")
    suspend fun listarProductos(@Query("q") q : String) : ProductModelResult

}
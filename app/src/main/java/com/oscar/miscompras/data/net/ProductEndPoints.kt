package com.oscar.miscompras.data.net

import com.example.miscompras.model.ProductModelResult


import retrofit2.http.GET
import retrofit2.http.Query

interface ProductEndPoints {

    @GET("sites/MLA/search")
    suspend fun getAllProducts(@Query("q") q : String) : ProductModelResult

}
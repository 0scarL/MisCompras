package com.oscar.miscompras.data.net

import com.example.miscompras.model.ProductModel
import com.oscar.miscompras.utils.RetrofitCaller
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class ProductService @Inject constructor(){

    suspend fun getProducts(search: String): List<ProductModel> {
        return withContext(Dispatchers.IO) {
            val response = RetrofitCaller.service.getAllProducts(search)
            response.productModel?: emptyList()
        }
    }
}
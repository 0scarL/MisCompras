package com.oscar.miscompras.data.net

import com.example.miscompras.model.ProductModel
import com.example.miscompras.model.ProductModelResult
import com.oscar.miscompras.utils.RetrofitCaller
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ProductService {

    suspend fun getProducts(search: String): List<ProductModel> {
        return withContext(Dispatchers.IO) {
            val response = RetrofitCaller.service.getAllProducts(search)
            response.productModel?: emptyList()
        }
    }
}
package com.oscar.miscompras.data

import com.example.miscompras.model.ProductModel
import com.oscar.miscompras.data.net.ProductService
import com.oscar.miscompras.utils.ProductsCarrier

class Repository {

    private val productService = ProductService()

    suspend fun getAllProducts(search: String): List<ProductModel>{
        val response = productService.getProducts(search)
        ProductsCarrier.products = response
        return response
    }
}
package com.oscar.miscompras.data

import com.example.miscompras.model.ProductModel
import com.oscar.miscompras.data.net.ProductService
import com.oscar.miscompras.utils.ProductCarrier
import javax.inject.Inject

class Repository @Inject constructor(
    private val productService: ProductService,
    private val productCarrier: ProductCarrier) {

    suspend fun getAllProducts(search: String): List<ProductModel> {
        val response = productService.getProducts(search)
        productCarrier.products = response
        return response
    }

}
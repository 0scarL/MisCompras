package com.oscar.miscompras.utils

import com.example.miscompras.model.ProductModel
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ProductCarrier @Inject constructor(){

        var products: List<ProductModel> = emptyList()

        var search: String = ""

        lateinit var oneProduct: ProductModel

}
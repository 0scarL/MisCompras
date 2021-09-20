package com.oscar.miscompras.utils

import com.example.miscompras.model.ProductModel

object ProductsCarrier {
    var products : List<ProductModel> = emptyList()

    var search : String = ""

    lateinit var oneProduct: ProductModel
}
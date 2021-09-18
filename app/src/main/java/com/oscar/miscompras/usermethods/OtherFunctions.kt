package com.oscar.miscompras.usermethods

import com.example.miscompras.model.ProductModel
import com.oscar.miscompras.database.ProductoEntity

object OtherFunctions {

    fun corrigeLink (link: String):String{
        var link1 = link.substring(0,5)
        var linkfixed=""
        if (!link1.equals("https")) {
            var linkfixed = link.replaceFirst("http", "https")
            return linkfixed
        } else{ return link}
    }

//    fun getProductFormat(productModel: ProductModel): List<ProductoEntity>{
//        var resultado = mutableListOf<Any?>()
//
//        productModel.also {
//            resultado.add(it.title)
//            resultado.add(it.price)
//            resultado.add(it.accepts_mercadopago)
//
//        }
//        return resultado
//
//    }
}
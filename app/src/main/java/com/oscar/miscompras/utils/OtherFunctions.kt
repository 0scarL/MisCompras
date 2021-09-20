package com.oscar.miscompras.utils

import android.content.Context
import android.util.Log
import com.example.miscompras.model.ProductModel
import com.oscar.miscompras.databinding.ProductoItemLayoutBinding
import com.squareup.picasso.Picasso
import java.nio.file.attribute.AttributeView


object OtherFunctions {

    /**Obtiene Thumbnail seguro**/
    fun getThumbLink(link: String): String {
        var link1 = link.substring(0, 5)
        var linkfixed = ""
        if (!link1.equals("https")) {
            var linkfixed = link.replaceFirst("http", "https")
            return linkfixed
        } else {
            return link
        }
    }

    /**Cambia formato -I.Jpg**/
    fun getPicLink(link: String): String {
        var linkPic= getThumbLink(link)
        linkPic= linkPic.replaceAfterLast('-',"O.jpg")
        return linkPic

    }

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

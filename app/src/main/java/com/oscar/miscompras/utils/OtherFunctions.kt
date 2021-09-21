package com.oscar.miscompras.utils

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


    /**definicion de constantes**/

    const val NO_RESULTADO =
        "No hay resultados para esta busqueda, intente nuevamente."

    const val NO_CONNECTION_IMAGE: Int =
        com.oscar.miscompras.R.drawable.error_conexion2
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

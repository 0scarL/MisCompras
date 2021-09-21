package com.oscar.miscompras.utils

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import com.oscar.miscompras.ui.viewmodel.ProductViewModel


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

    fun isOnline(context: Context): Boolean {
        val cm = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            val n = cm.activeNetwork
            if (n != null) {
                val nc = cm.getNetworkCapabilities(n)
                //It will check for both wifi and cellular network
                return nc!!.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) || nc.hasTransport(
                    NetworkCapabilities.TRANSPORT_WIFI)
            }
            return false
        } else {
            val netInfo = cm.activeNetworkInfo
            return netInfo != null && netInfo.isConnectedOrConnecting
        }
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

package com.oscar.miscompras.usermethods

object OtherFunctions {

    fun corrigeLink (link: String):String{
        var link1 = link.substring(0,5)
        var linkfixed=""
        if (!link1.equals("https")) {
            var linkfixed = link.replaceFirst("http", "https")
            return linkfixed
        } else{ return link}
    }
}
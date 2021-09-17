package com.oscar.miscompras.usermethods

import junit.framework.TestCase

class OtherFunctionsTest : TestCase() {

    fun testCorrigeLink() {
        val a = "https://http2.mlstatic.com/"
        val b = "http://http2.mlstatic.com/"
        assertEquals(a, OtherFunctions.corrigeLink(b))
    }

    fun testCorrigeLinkIgual() {
        val a = "https://http2.mlstatic.com/"
        val b = "https://http2.mlstatic.com/"
        assertEquals(a, OtherFunctions.corrigeLink(b))
    }

}
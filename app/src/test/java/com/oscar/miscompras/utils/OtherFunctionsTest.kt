package com.oscar.miscompras.utils

import junit.framework.TestCase

class OtherFunctionsTest : TestCase() {

    fun testCorrigeLink() {
        val a = "https://http2.mlstatic.com/"
        val b = "http://http2.mlstatic.com/"
        assertEquals(a, OtherFunctions.getThumbLink(b))
    }

    fun testCorrigeLinkIgual() {
        val a = "https://http2.mlstatic.com/"
        val b = "https://http2.mlstatic.com/"
        assertEquals(a, OtherFunctions.getThumbLink(b))
    }

}
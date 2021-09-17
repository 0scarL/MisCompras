package com.oscar.miscompras.database

import android.app.Application
import androidx.room.Room

class InicioProductoDb: Application() {

    companion object{
        lateinit var IniciaDatabase : ProductoDataBase
    }

    override fun onCreate() {
        super.onCreate()
        InicioProductoDb.IniciaDatabase = Room.databaseBuilder(this,ProductoDataBase::class.java,"Producto-db").build()
    }

}
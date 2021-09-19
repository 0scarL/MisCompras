package com.oscar.miscompras.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.lifecycleScope
import com.oscar.miscompras.utils.RetrofitCaller
import com.oscar.miscompras.ui.adapter.ProductoAdapter

import com.oscar.miscompras.databinding.ActivityMainBinding
import com.oscar.miscompras.ui.viewmodel.ProductViewModel
import com.oscar.miscompras.utils.OtherFunctions
import com.oscar.miscompras.utils.ProductsCarrier
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    val search = MutableLiveData<String>()

    private val productViewModel : ProductViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {

        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)


        ProductsCarrier.search = "balon"
        productViewModel.onCreate()





        var productoAdapter = ProductoAdapter(

            { producto ->
                Toast.makeText(this@MainActivity, producto.title, Toast.LENGTH_SHORT).show()
            })
        binding.myRecycler.adapter = productoAdapter


        productViewModel.listProductModel.observe(this,
            androidx.lifecycle.Observer {

                binding.textViewMain.text = it[0].title
                productoAdapter.producto=it
        })



        var dateFormat = SimpleDateFormat("dd/M/yyyy hh:mm:ss")
//        val currentDate = dateFormat.format(Date())
//        binding.textMain01.text = currentDate




    }
}
//
//lifecycleScope.launch {
//    val productos = RetrofitCaller.service.getAllProducts("Motorola")
//    if (productos != null) {
//        //productoEntity = ProductoEntity(0, productos.productoDb)
//        /**carga la ultima busqueda en la db**/
//        //productoAdapter.producto = productoEntity.productoDB!!
//        /**lo puse comentado, la idea es q cuando hay red se muestre este**/
//        productoAdapter.producto = productos.productModel!!
//        //Log.d("productos","imagen link ${productos.productoDb[10].thumbnail}")
//    }
//
//}
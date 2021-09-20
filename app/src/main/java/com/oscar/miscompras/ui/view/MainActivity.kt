package com.oscar.miscompras.ui.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.oscar.miscompras.databinding.ActivityMainBinding
import com.oscar.miscompras.utils.ProductsCarrier

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)


        binding.imageViewBuscar.setOnClickListener {
            ProductsCarrier.search = binding.editTextSearch.text.toString()
            navigateTo()
        }

    }

    private fun navigateTo() {
        val intent = Intent(this, SearchResultActivity::class.java)
        startActivity(intent)
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


//        productViewModel.listProductModel.observe(this,
//            androidx.lifecycle.Observer {
//
//                binding.textViewMain.text = it[0].title
//
//        })

//var dateFormat = SimpleDateFormat("dd/M/yyyy hh:mm:ss")
//        val currentDate = dateFormat.format(Date())
//        binding.textMain01.text = currentDate
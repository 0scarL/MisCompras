package com.oscar.miscompras.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.lifecycleScope
import com.example.miscompras.service.ProductoCliente
import com.oscar.miscompras.adapter.ProductoAdapter
import com.oscar.miscompras.database.ProductoEntity
import com.oscar.miscompras.databinding.ActivityMainBinding
import com.oscar.miscompras.viewmodel.ProductViewModel
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    lateinit var productoEntity: ProductoEntity
    private val productViewModel : ProductViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {

        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        productViewModel.listProductModel.observe(this,
            androidx.lifecycle.Observer {

        })

        var dateFormat = SimpleDateFormat("dd/M/yyyy hh:mm:ss")
        val currentDate = dateFormat.format(Date())
        binding.textMain01.text = currentDate

        var productoAdapter = ProductoAdapter(

            { producto ->
                Toast.makeText(this@MainActivity, producto.title, Toast.LENGTH_SHORT).show()
            })
        binding.myRecycler.adapter = productoAdapter

        lifecycleScope.launch {
            val productos = ProductoCliente.service.listarProductos("Motorola")
            if (productos != null) {
                //productoEntity = ProductoEntity(0, productos.productoDb)
                /**carga la ultima busqueda en la db**/
                //productoAdapter.producto = productoEntity.productoDB!!
                /**lo puse comentado, la idea es q cuando hay red se muestre este**/
                productoAdapter.producto = productos.productModel!!
                //Log.d("productos","imagen link ${productos.productoDb[10].thumbnail}")
            }

        }
    }
}
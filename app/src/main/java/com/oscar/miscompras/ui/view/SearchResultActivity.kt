package com.oscar.miscompras.ui.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels
import androidx.core.view.isVisible
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import com.example.miscompras.model.ProductModel
import com.oscar.miscompras.databinding.ActivityMainBinding
import com.oscar.miscompras.databinding.ActivitySearchResultBinding
import com.oscar.miscompras.ui.adapter.ProductoAdapter
import com.oscar.miscompras.ui.viewmodel.ProductViewModel
import com.oscar.miscompras.utils.OtherFunctions
import com.oscar.miscompras.utils.ProductsCarrier
import com.squareup.picasso.Picasso

class SearchResultActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySearchResultBinding
    private val productViewModel : ProductViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivitySearchResultBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        setBarTitle()

        if(OtherFunctions.isOnline(this))
            productViewModel.onCreate()
        else{
            setNoConnectionImage()
        }

        var productoAdapter = ProductoAdapter { producto -> navigateTo(producto)}
        binding.myRecycler.adapter = productoAdapter


        productViewModel.loading.observe(this, Observer {
            binding.myProgressbar.isVisible = it
        })

        productViewModel.searchResult.observe(this, Observer { searchSuccess ->
            if (!searchSuccess)
                binding.itemSearchError.text = OtherFunctions.NO_RESULTADO
        })

        productViewModel.listProductModel.observe(this,
            androidx.lifecycle.Observer { productos ->
                if (!productos.isNullOrEmpty()){
                    productoAdapter.producto = ProductsCarrier.products
                }
            }
        )
    }


    private fun setBarTitle() {
        setTitle("Busqueda con: ${ProductsCarrier.search}")
    }

    private fun navigateTo(producto : ProductModel) {
        val intent = Intent(this, DetailActivity::class.java)
        ProductsCarrier.oneProduct = producto
        startActivity(intent)
    }

    private fun setNoConnectionImage(){
        Picasso.get()
            .load(OtherFunctions.NO_CONNECTION_IMAGE)
            .resize(360, 320)
            .centerInside()
            .into(this.binding.itemImageConnection)
    }
}
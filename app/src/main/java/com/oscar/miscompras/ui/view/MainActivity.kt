package com.oscar.miscompras.ui.view

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.oscar.miscompras.databinding.ActivityMainBinding
import com.oscar.miscompras.utils.IsOnlineChecker
import com.oscar.miscompras.utils.ProductCarrier
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    @Inject lateinit var productCarrier: ProductCarrier

    @Inject lateinit var isOnlineChecker: IsOnlineChecker

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)


        binding.editTextSearch.setOnClickListener {
            val conexion = isOnlineChecker.isOnline(this)
            Log.d("ActivityMain","hay conexion: ${conexion}")
            Toast.makeText(this, "har red: ${conexion}", Toast.LENGTH_SHORT).show()
        }

        binding.imageViewBuscar.setOnClickListener {
            val search = binding.editTextSearch.text
            if (!search.isNullOrEmpty()){
            productCarrier.search = binding.editTextSearch.text.toString()
            navigateTo()
            }else{
                Toast.makeText(this, "El Campo de busqueda esta vacio!", Toast.LENGTH_SHORT).show()
            }
        }

    }

    private fun navigateTo() {
        val intent = Intent(this, SearchResultActivity::class.java)
        startActivity(intent)
    }

}

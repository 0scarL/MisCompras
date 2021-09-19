package com.oscar.miscompras.ui.viewmodel

import android.app.Activity
import android.view.LayoutInflater
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.miscompras.model.ProductModel
import com.oscar.miscompras.databinding.ActivityMainBinding
import com.oscar.miscompras.domain.GetProductsUseCase
import com.oscar.miscompras.ui.view.MainActivity
import com.oscar.miscompras.utils.ProductsCarrier.search

import kotlinx.coroutines.launch

class ProductViewModel() : ViewModel() {

    val listProductModel = MutableLiveData<List<ProductModel>>()


    var getProductsUseCase = GetProductsUseCase()


    fun onCreate() {

        viewModelScope.launch {

            val result = getProductsUseCase(search)

            if (!result.isNullOrEmpty()) {
                listProductModel.postValue(result!!)
            }
        }
    }
}
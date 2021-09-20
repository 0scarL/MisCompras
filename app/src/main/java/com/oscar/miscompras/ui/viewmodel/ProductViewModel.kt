package com.oscar.miscompras.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.miscompras.model.ProductModel
import com.oscar.miscompras.domain.GetProductsUseCase
import com.oscar.miscompras.utils.ProductsCarrier
import com.oscar.miscompras.utils.ProductsCarrier.search

import kotlinx.coroutines.launch

class ProductViewModel() : ViewModel() {

    val listProductModel = MutableLiveData<List<ProductModel>>()
    val loading = MutableLiveData<Boolean>()
    var getProductsUseCase = GetProductsUseCase()


    fun onCreate() {
        onProgressBar()
        viewModelScope.launch {

            var result = getProductsUseCase(ProductsCarrier.search)

            if (!result.isNullOrEmpty()) {
                listProductModel.postValue(result!!)
            }
            offProgresBar()

        }
    }

    private fun onProgressBar() = loading.postValue(true)

    private fun offProgresBar() = loading.postValue(false)


}
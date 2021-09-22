package com.oscar.miscompras.ui.viewmodel

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.miscompras.model.ProductModel
import com.oscar.miscompras.domain.GetProductsUseCase
import com.oscar.miscompras.ui.view.MainActivity
import com.oscar.miscompras.utils.ProductCarrier
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductViewModel @Inject constructor(
    private val productCarrier: ProductCarrier,
    private val getProductsUseCase : GetProductsUseCase,

) : ViewModel() {

    val listProductModel = MutableLiveData<List<ProductModel>>()
    val loading = MutableLiveData<Boolean>()
    val searchResult = MutableLiveData<Boolean>()
    lateinit var isConnected : LiveData<Boolean>


    fun onCreate() {

        onProgressBar()
        viewModelScope.launch {


            val result = getProductsUseCase(productCarrier.search)

            if (!result.isNullOrEmpty()) {
                listProductModel.postValue(result)
                searchResult.postValue(true)
                Log.d("ProductViewModel","Asking Data: ${searchResult.toString()} ")
            }else{
                searchResult.postValue(false)
                Log.d("ProductViewModel","Asking Data: ${searchResult.toString()} ")
            }
            offProgresBar()

        }


    }

    private fun onProgressBar() = loading.postValue(true)

    private fun offProgresBar() = loading.postValue(false)


}
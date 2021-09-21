package com.oscar.miscompras.ui.viewmodel

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.miscompras.model.ProductModel
import com.oscar.miscompras.domain.GetProductsUseCase
import com.oscar.miscompras.utils.OtherFunctions
import com.oscar.miscompras.utils.ProductsCarrier
import com.oscar.miscompras.utils.ProductsCarrier.search

import kotlinx.coroutines.launch

class ProductViewModel() : ViewModel() {

    val listProductModel = MutableLiveData<List<ProductModel>>()
    val loading = MutableLiveData<Boolean>()
    var getProductsUseCase = GetProductsUseCase()
    val searchResult = MutableLiveData<Boolean>()
    lateinit var isConnected : LiveData<Boolean>


    fun onCreate() {



        onProgressBar()
        viewModelScope.launch {


            var result = getProductsUseCase(ProductsCarrier.search)

            if (!result.isNullOrEmpty()) {
                listProductModel.postValue(result!!)
                searchResult.postValue(true)
            }else{
                searchResult.postValue(false)
            }
            offProgresBar()

        }


    }

    private fun onProgressBar() = loading.postValue(true)

    private fun offProgresBar() = loading.postValue(false)

    fun isOnline(context: Context): Boolean {
        val cm = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            val n = cm.activeNetwork
            if (n != null) {
                val nc = cm.getNetworkCapabilities(n)
                //It will check for both wifi and cellular network
                return nc!!.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) || nc.hasTransport(
                    NetworkCapabilities.TRANSPORT_WIFI)
            }
            return false
        } else {
            val netInfo = cm.activeNetworkInfo
            return netInfo != null && netInfo.isConnectedOrConnecting
        }
    }


}
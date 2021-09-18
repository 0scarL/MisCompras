package com.oscar.miscompras.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.miscompras.model.ProductModel

class ProductViewModel: ViewModel() {

    val listProductModel = MutableLiveData<List<ProductModel>>()
}
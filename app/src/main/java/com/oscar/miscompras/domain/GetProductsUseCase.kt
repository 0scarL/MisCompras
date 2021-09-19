package com.oscar.miscompras.domain

import com.example.miscompras.model.ProductModel
import com.oscar.miscompras.data.Repository

class GetProductsUseCase {

    private val repository = Repository()

    suspend operator fun invoke(search: String): List<ProductModel>?{
        return repository.getAllProducts(search)
    }

}
package com.oscar.miscompras.domain

import com.example.miscompras.model.ProductModel
import com.oscar.miscompras.data.Repository
import javax.inject.Inject

class GetProductsUseCase @Inject constructor( private val repository : Repository) {

    suspend operator fun invoke(search: String): List<ProductModel> {
        return repository.getAllProducts(search)
    }

}
package com.example.miscompras.model

import com.google.gson.annotations.SerializedName

data class ProductoDBResult(
    val available_filters: List<AvailableFilter>?,
    val available_sorts: List<AvailableSort>?,
    val country_default_time_zone: String?,
    val filters: List<Any>?,
    val paging: Paging?,
    val query: String?,
    @SerializedName("results")
    val productoDb: List<ProductoDb>?,
    val site_id: String?,
    val sort: Sort?
)
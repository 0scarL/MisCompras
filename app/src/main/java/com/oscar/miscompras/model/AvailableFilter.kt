package com.example.miscompras.model

data class AvailableFilter(
    val id: String?,
    val name: String?,
    val type: String?,
    val values: List<Value>?
)
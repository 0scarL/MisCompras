package com.example.miscompras.model

data class Paging(
    val limit: Int?,
    val offset: Int?,
    val primary_results: Int?,
    val total: Int?
)
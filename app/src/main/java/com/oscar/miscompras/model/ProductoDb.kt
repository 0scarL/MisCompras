package com.example.miscompras.model

data class ProductoDb(
    val accepts_mercadopago: Boolean?,
    val address: Address?,
    val attributes: List<Attribute>?,
    val available_quantity: Int?,
    val buying_mode: String?,
    val catalog_product_id: Any?,
    val category_id: String?,
    val condition: String?,
    val currency_id: String?,
    val domain_id: String?,
    val id: String?,
    val installments: Installments?,
    val listing_type_id: String?,
    val offer_score: Any?,
    val offer_share: Any?,
    val official_store_id: Int?,
    val order_backend: Int?,
    val original_price: Any?,
    val permalink: String?,
    val price: Float?,
    val prices: Prices?,
    val sale_price: Any?,
    val seller: Seller?,
    val seller_address: SellerAddress?,
    val shipping: Shipping?,
    val site_id: String?,
    val sold_quantity: Int?,
    val stop_time: String?,
    val tags: List<String>?,
    val thumbnail: String?,
    val thumbnail_id: String?,
    val title: String?,
    val use_thumbnail_id: Boolean?
)
package com.example.futuratwo.dto.user.cart_item

data class CartItemResponse(
    val id: Long,
    val productId: Long,
    val productSkuId: Long,
    val quantity: Int
)

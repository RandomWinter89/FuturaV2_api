package com.example.futuratwo.dto.user.cart_item

data class AddCartItemRequest(
    val productId: Long,
    val productSkuId: Long,
    val quantity: Int
)

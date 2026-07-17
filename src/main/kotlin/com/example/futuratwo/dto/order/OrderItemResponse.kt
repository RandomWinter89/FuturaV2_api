package com.example.futuratwo.dto.order

data class OrderItemResponse(
    val id: Long,
    val productId: Long,
    val productSkuId: Long,
    val promotionId: Long?,
    val quantity: Int,
    val discount: Double?,
    val prodPrice: Double,
    val totalPrice: Double,
)
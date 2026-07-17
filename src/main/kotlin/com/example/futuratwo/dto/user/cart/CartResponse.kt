package com.example.futuratwo.dto.user.cart

import com.example.futuratwo.dto.user.cart_item.CartItemResponse
import java.util.UUID

data class CartResponse(
    val id: Long,
    val userId: UUID,
    val sumProduct: Int,
    val items: List<CartItemResponse>
)

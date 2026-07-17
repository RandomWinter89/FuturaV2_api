package com.example.futuratwo.repository.user

import com.example.futuratwo.model.user.CartItem
import org.springframework.data.jpa.repository.JpaRepository

interface CartItemRepository : JpaRepository<CartItem, Long> {
    fun findByCartId(cartId: Long): List<CartItem>
    fun findByIdAndCartId(id: Long, cartId: Long): CartItem?
}
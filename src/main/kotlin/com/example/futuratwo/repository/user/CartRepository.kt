package com.example.futuratwo.repository.user

import com.example.futuratwo.model.user.Cart
import org.springframework.data.jpa.repository.JpaRepository
import java.util.UUID

interface CartRepository : JpaRepository<Cart, Long> {
    fun findByUserId(userId: UUID): Cart?
}
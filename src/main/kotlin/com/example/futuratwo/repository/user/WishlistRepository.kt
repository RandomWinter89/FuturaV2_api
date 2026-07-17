package com.example.futuratwo.repository.user

import com.example.futuratwo.model.user.Wishlist
import org.springframework.data.jpa.repository.JpaRepository
import java.util.UUID

interface WishlistRepository : JpaRepository<Wishlist, Long> {
    fun findByUserId(userId: UUID): List<Wishlist>
    fun findByIdAndUserId(id: Long, userId: UUID): Wishlist?
}
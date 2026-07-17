package com.example.futuratwo.service.user

import com.example.futuratwo.dto.user.wishlist.AddWishlistRequest
import com.example.futuratwo.dto.user.wishlist.WishlistResponse
import com.example.futuratwo.model.user.Wishlist
import com.example.futuratwo.repository.user.WishlistRepository
import jakarta.transaction.Transactional
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class WishlistService(
    private val wishlistRepository: WishlistRepository
) {

    @Transactional
    fun addWishlist(userId: UUID, request: AddWishlistRequest): WishlistResponse {
        val wishlist = wishlistRepository.save(
            Wishlist(
                userId = userId,
                productId = request.productId,
                productSkuId = request.productSkuId
            )
        )
        return toWishlistResponse(wishlist)
    }

    @Transactional
    fun removeWishlist(userId: UUID, wishlistId: Long) {
        val wishlist = wishlistRepository.findByIdAndUserId(wishlistId, userId)
            ?: throw NoSuchElementException("Wishlist item not found")
        wishlistRepository.delete(wishlist)
    }

    fun getWishlistByUserId(userId: UUID): List<WishlistResponse> {
        return wishlistRepository.findByUserId(userId).map { toWishlistResponse(it) }
    }

    private fun toWishlistResponse(wishlist: Wishlist): WishlistResponse {
        return WishlistResponse(
            id = wishlist.id,
            productId = wishlist.productId,
            productSkuId = wishlist.productSkuId
        )
    }
}
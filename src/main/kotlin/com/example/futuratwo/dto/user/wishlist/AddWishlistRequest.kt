package com.example.futuratwo.dto.user.wishlist

data class AddWishlistRequest(
    val productId: Long,
    val productSkuId: String
)
package com.example.futuratwo.controller.user

import com.example.futuratwo.dto.user.wishlist.AddWishlistRequest
import com.example.futuratwo.dto.user.wishlist.WishlistResponse
import com.example.futuratwo.dto.user.cart.CartResponse
import com.example.futuratwo.dto.user.cart_item.AddCartItemRequest
import com.example.futuratwo.dto.user.cart_item.UpdateCartItemRequest
import com.example.futuratwo.service.user.*
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.UUID

@RestController
@RequestMapping("/api")
class CartController(
    private val cartService: CartService,
    private val wishlistService: WishlistService
) {

    @PostMapping("/carts/{userId}")
    fun createCart(@PathVariable userId: UUID): ResponseEntity<CartResponse> {
        return ResponseEntity.ok(cartService.createCart(userId))
    }

    @GetMapping("/carts/{userId}")
    fun getCart(@PathVariable userId: UUID): ResponseEntity<CartResponse> {
        return ResponseEntity.ok(cartService.getCartByUserId(userId))
    }

    @PostMapping("/carts/{userId}/items")
    fun addCartItem(
        @PathVariable userId: UUID,
        @RequestBody request: AddCartItemRequest
    ): ResponseEntity<CartResponse> {
        return ResponseEntity.ok(cartService.addCartItem(userId, request))
    }

    @PutMapping("/carts/{userId}/items/{itemId}")
    fun updateCartItem(
        @PathVariable userId: UUID,
        @PathVariable itemId: Long,
        @RequestBody request: UpdateCartItemRequest
    ): ResponseEntity<CartResponse> {
        return ResponseEntity.ok(cartService.updateCartItem(userId, itemId, request))
    }

    @DeleteMapping("/carts/{userId}/items/{itemId}")
    fun removeCartItem(
        @PathVariable userId: UUID,
        @PathVariable itemId: Long
    ): ResponseEntity<Void> {
        cartService.removeCartItem(userId, itemId)
        return ResponseEntity.noContent().build()
    }

    @PostMapping("/wishlists/{userId}")
    fun addWishlist(
        @PathVariable userId: UUID,
        @RequestBody request: AddWishlistRequest
    ): ResponseEntity<WishlistResponse> {
        return ResponseEntity.ok(wishlistService.addWishlist(userId, request))
    }

    @DeleteMapping("/wishlists/{userId}/{wishlistId}")
    fun removeWishlist(
        @PathVariable userId: UUID,
        @PathVariable wishlistId: Long
    ): ResponseEntity<Void> {
        wishlistService.removeWishlist(userId, wishlistId)
        return ResponseEntity.noContent().build()
    }

    @GetMapping("/wishlists/{userId}")
    fun getWishlist(@PathVariable userId: UUID): ResponseEntity<List<WishlistResponse>> {
        return ResponseEntity.ok(wishlistService.getWishlistByUserId(userId))
    }
}
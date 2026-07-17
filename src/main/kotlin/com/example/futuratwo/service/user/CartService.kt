package com.example.futuratwo.service.user

import com.example.futuratwo.dto.user.cart_item.*
import com.example.futuratwo.dto.user.cart.*
import com.example.futuratwo.repository.user.*
import com.example.futuratwo.model.user.*
import jakarta.transaction.Transactional
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class CartService(
    private val cartRepository: CartRepository,
    private val cartItemRepository: CartItemRepository
) {

    @Transactional
    fun createCart(userId: UUID): CartResponse {
        val existing = cartRepository.findByUserId(userId)
        if (existing != null) {
            return toCartResponse(existing, cartItemRepository.findByCartId(existing.id))
        }
        val cart = cartRepository.save(Cart(userId = userId))
        return toCartResponse(cart, emptyList())
    }

    fun getCartByUserId(userId: UUID): CartResponse {
        val cart = cartRepository.findByUserId(userId)
            ?: throw NoSuchElementException("Cart not found for user $userId")
        val items = cartItemRepository.findByCartId(cart.id)
        return toCartResponse(cart, items)
    }

    @Transactional
    fun addCartItem(userId: UUID, request: AddCartItemRequest): CartResponse {
        val cart = cartRepository.findByUserId(userId)
            ?: cartRepository.save(Cart(userId = userId))

        cartItemRepository.save(
            CartItem(
                cartId = cart.id,
                productId = request.productId,
                productSkuId = request.productSkuId,
                quantity = request.quantity
            )
        )

        val items = cartItemRepository.findByCartId(cart.id)
        cart.sumProduct = items.sumOf { it.quantity }
        cartRepository.save(cart)

        return toCartResponse(cart, items)
    }

    @Transactional
    fun updateCartItem(userId: UUID, itemId: Long, request: UpdateCartItemRequest): CartResponse {
        val cart = cartRepository.findByUserId(userId)
            ?: throw NoSuchElementException("Cart not found for user $userId")

        val item = cartItemRepository.findByIdAndCartId(itemId, cart.id)
            ?: throw NoSuchElementException("Cart item not found")

        val updatedItem = CartItem(
            id = item.id,
            cartId = item.cartId,
            productId = item.productId,
            productSkuId = item.productSkuId,
            quantity = request.quantity
        )
        cartItemRepository.save(updatedItem)

        val items = cartItemRepository.findByCartId(cart.id)
        cart.sumProduct = items.sumOf { it.quantity }
        cartRepository.save(cart)

        return toCartResponse(cart, items)
    }

    @Transactional
    fun removeCartItem(userId: UUID, itemId: Long) {
        val cart = cartRepository.findByUserId(userId)
            ?: throw NoSuchElementException("Cart not found for user $userId")

        val item = cartItemRepository.findByIdAndCartId(itemId, cart.id)
            ?: throw NoSuchElementException("Cart item not found")

        cartItemRepository.delete(item)

        val items = cartItemRepository.findByCartId(cart.id)
        cart.sumProduct = items.sumOf { it.quantity }
        cartRepository.save(cart)
    }

    private fun toCartResponse(cart: Cart, items: List<CartItem>): CartResponse
    {
        return CartResponse(
            id = cart.id,
            userId = cart.userId,
            sumProduct = cart.sumProduct,
            items = items.map {
                CartItemResponse(
                    id = it.id,
                    productId = it.productId,
                    productSkuId = it.productSkuId,
                    quantity = it.quantity
                )
            }
        )
    }

}
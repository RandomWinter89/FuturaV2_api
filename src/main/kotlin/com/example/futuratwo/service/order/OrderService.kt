package com.example.futuratwo.service.order

import com.example.futuratwo.dto.order.CheckoutRequest
import com.example.futuratwo.dto.order.OrderItemResponse
import com.example.futuratwo.dto.order.OrderResponse
import com.example.futuratwo.dto.order.UpdateOrderStatusRequest
import com.example.futuratwo.enumerator.OrderStatus
import com.example.futuratwo.model.order.Order
import com.example.futuratwo.model.order.OrderItem
import com.example.futuratwo.model.user.CartItem
import com.example.futuratwo.repository.order.*
import com.example.futuratwo.repository.product.ProductSkuRepository
import com.example.futuratwo.repository.user.*
import jakarta.transaction.Transactional
import org.springframework.stereotype.*
import java.time.LocalDateTime
import java.util.UUID

@Service
class OrderService(
    private val orderRepository: OrderRepository,
    private val orderItemRepository: OrderItemRepository,
    private val cartRepository: CartRepository,
    private val cartItemRepository: CartItemRepository,
    private val productSkuRepository: ProductSkuRepository
) {

    @Transactional
    fun createOrderFromCart(userId: UUID, request: CheckoutRequest): OrderResponse {
        val cart = cartRepository.findByUserId(userId)
            ?: throw NoSuchElementException("Cart not found for user $userId")

        val cartItems = cartItemRepository.findByCartId(cart.id)
        if (cartItems.isEmpty()) {
            throw IllegalStateException("Cart is empty")
        }

        var subtotal = 0.0
        var hasDiscount = false

        val pricedItems = cartItems.map { cartItem ->
            val sku = productSkuRepository.findById(cartItem.productSkuId)
                .orElseThrow { NoSuchElementException("Product SKU not found: ${cartItem.productSkuId}") }

            if (!sku.productAvailable) {
                throw IllegalStateException("Product SKU ${sku.sku} is not available")
            }

            val prodPrice = sku.salePrice ?: sku.basePrice
            val discount = sku.salePrice?.let { sku.basePrice - it }
            if (discount != null && discount > 0) hasDiscount = true

            val totalPrice = prodPrice * cartItem.quantity
            subtotal += totalPrice

            PricedItem(cartItem, prodPrice, discount, totalPrice)
        }

        val order = orderRepository.save(
            Order(
                userId = userId,
                sumProduct = cartItems.sumOf { it.quantity },
                hasDiscount = hasDiscount,
                priceTax = request.priceTax,
                deliverCost = request.deliverCost,
                priceTotal = subtotal + request.priceTax + request.deliverCost,
                orderDate = LocalDateTime.now(),
                orderStatus = OrderStatus.IN_PROGRESS,
                paymentType = request.paymentType,
            )
        )

        val orderItems = pricedItems.map {
            orderItemRepository.save(
                OrderItem(
                    orderId = order.id,
                    productId = it.cartItem.productId,
                    productSkuId = it.cartItem.productSkuId,
                    promotionId = null,
                    quantity = it.cartItem.quantity,
                    discount = it.discount,
                    prodPrice = it.prodPrice,
                    totalPrice = it.totalPrice
                )
            )
        }

        cartItemRepository.deleteAll(cartItems)
        cart.sumProduct = 0
        cartRepository.save(cart)

        return toOrderResponse(order, orderItems)
    }

    fun getOrdersByUserId(userId: UUID): List<OrderResponse> {
        return orderRepository.findByUserId(userId).map { order ->
            toOrderResponse(order, orderItemRepository.findByOrderId(order.id))
        }
    }

    fun getOrderById(userId: UUID, orderId: Long): OrderResponse {
        val order = orderRepository.findByIdAndUserId(orderId, userId)
            ?: throw NoSuchElementException("Order not found")
        return toOrderResponse(order, orderItemRepository.findByOrderId(order.id))
    }

    @Transactional
    fun updateOrderStatus(userId: UUID, orderId: Long, request: UpdateOrderStatusRequest): OrderResponse {
        val order = orderRepository.findByIdAndUserId(orderId, userId)
            ?: throw NoSuchElementException("Order not found")

        order.orderStatus = request.orderStatus
        request.paymentDate?.let { order.paymentDate = it }
        request.shipDate?.let { order.shipDate = it }
        request.errorCode?.let { order.errorCode = it }
        request.errorDesc?.let { order.errorDesc = it }

        orderRepository.save(order)
        return toOrderResponse(order, orderItemRepository.findByOrderId(order.id))
    }

    @Transactional
    fun cancelOrder(userId: UUID, orderId: Long) {
        val order = orderRepository.findByIdAndUserId(orderId, userId)
            ?: throw NoSuchElementException("Order not found")
        order.orderStatus = OrderStatus.CANCELLED
        orderRepository.save(order)
    }

    private fun toOrderResponse(order: Order, items: List<OrderItem>): OrderResponse {
        return OrderResponse(
            id = order.id,
            userId = order.userId,
            sumProduct = order.sumProduct,
            hasDiscount = order.hasDiscount,
            priceTax = order.priceTax,
            deliverCost = order.deliverCost,
            priceTotal = order.priceTotal,
            orderDate = order.orderDate,
            orderStatus = order.orderStatus,
            paymentType = order.paymentType,
            paymentDate = order.paymentDate,
            shipDate = order.shipDate,
            errorCode = order.errorCode,
            errorDesc = order.errorDesc,
            items = items.map {
                OrderItemResponse(
                    id = it.id,
                    productId = it.productId,
                    productSkuId = it.productSkuId,
                    promotionId = it.promotionId,
                    quantity = it.quantity,
                    discount = it.discount,
                    prodPrice = it.prodPrice,
                    totalPrice = it.totalPrice,
                )
            }
        )
    }

    private data class PricedItem(
        val cartItem: CartItem,
        val prodPrice: Double,
        val discount: Double?,
        val totalPrice: Double
    )
}
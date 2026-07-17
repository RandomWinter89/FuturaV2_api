package com.example.futuratwo.controller.order

import org.springframework.web.bind.annotation.*
import org.springframework.http.ResponseEntity
import com.example.futuratwo.service.order.OrderService
import com.example.futuratwo.dto.order.*
import java.util.UUID

@RestController
@RequestMapping("/api")
class OrderController(
    private val orderService: OrderService
) {

    @PostMapping("/orders/{userId}/checkout")
    fun createOrderFromCart(
        @PathVariable userId: UUID,
        @RequestBody request: CheckoutRequest
    ): ResponseEntity<OrderResponse> {
        return ResponseEntity.ok(orderService.createOrderFromCart(userId, request))
    }

    @GetMapping("/orders/{userId}")
    fun getOrders(@PathVariable userId: UUID): ResponseEntity<List<OrderResponse>> {
        return ResponseEntity.ok(orderService.getOrdersByUserId(userId))
    }

    @GetMapping("/orders/{userId}/{orderId}")
    fun getOrder(
        @PathVariable userId: UUID,
        @PathVariable orderId: Long
    ): ResponseEntity<OrderResponse> {
        return ResponseEntity.ok(orderService.getOrderById(userId, orderId))
    }

    @PutMapping("/orders/{userId}/{orderId}/status")
    fun updateOrderStatus(
        @PathVariable userId: UUID,
        @PathVariable orderId: Long,
        @RequestBody request: UpdateOrderStatusRequest
    ): ResponseEntity<OrderResponse> {
        return ResponseEntity.ok(orderService.updateOrderStatus(userId, orderId, request))
    }

    @DeleteMapping("/orders/{userId}/{orderId}")
    fun cancelOrder(
        @PathVariable userId: UUID,
        @PathVariable orderId: Long
    ): ResponseEntity<Void> {
        orderService.cancelOrder(userId, orderId)
        return ResponseEntity.noContent().build()
    }
}
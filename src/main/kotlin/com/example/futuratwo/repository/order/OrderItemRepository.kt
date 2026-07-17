package com.example.futuratwo.repository.order

import com.example.futuratwo.model.order.OrderItem
import org.springframework.data.jpa.repository.JpaRepository

interface OrderItemRepository : JpaRepository<OrderItem, Long> {
    fun findByOrderId(orderId: Long): List<OrderItem>
}
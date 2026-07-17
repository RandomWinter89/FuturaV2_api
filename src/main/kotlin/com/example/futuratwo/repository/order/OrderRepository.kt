package com.example.futuratwo.repository.order

import com.example.futuratwo.model.order.Order
import org.springframework.data.jpa.repository.JpaRepository
import java.util.UUID

interface OrderRepository : JpaRepository<Order, Long> {
    fun findByUserId(userId: UUID): List<Order>
    fun findByIdAndUserId(id: Long, userId: UUID): Order?
}
package com.example.futuratwo.dto.order

import com.example.futuratwo.enumerator.OrderStatus
import java.time.LocalDate
import java.time.LocalDateTime
import java.util.UUID

data class OrderResponse(
    val id: Long,
    val userId: UUID,
    val sumProduct: Int,
    val hasDiscount: Boolean,
    val priceTax: Double,
    val deliverCost: Double,
    val priceTotal: Double,
    val orderDate: LocalDateTime,
    val orderStatus: OrderStatus,
    val paymentType: String,
    val paymentDate: LocalDateTime?,
    val shipDate: LocalDate?,
    val errorCode: String?,
    val errorDesc: String?,
    val items: List<OrderItemResponse>
)
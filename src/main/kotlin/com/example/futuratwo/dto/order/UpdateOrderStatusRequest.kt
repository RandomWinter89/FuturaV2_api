package com.example.futuratwo.dto.order

import com.example.futuratwo.enumerator.OrderStatus
import java.time.LocalDate
import java.time.LocalDateTime

data class UpdateOrderStatusRequest(
    val orderStatus: OrderStatus,
    val paymentDate: LocalDateTime? = null,
    val shipDate: LocalDate? = null,
    val errorCode: String? = null,
    val errorDesc: String? = null,
)
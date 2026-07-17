package com.example.futuratwo.repository.order

import com.example.futuratwo.model.order.PaymentType
import org.springframework.data.jpa.repository.JpaRepository

interface PaymentTypeRepository : JpaRepository<PaymentType, Long> {
}
package com.example.futuratwo.dto.order

data class CheckoutRequest(
    val deliverCost: Double,
    val priceTax: Double,
    val paymentType: String,
)
package com.example.futuratwo.model.order

import com.example.futuratwo.enumerator.OrderStatus
import jakarta.persistence.*
import java.time.LocalDate
import java.time.LocalDateTime
import java.util.UUID

@Entity
@Table(name = "orders")
class Order (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id : Long = 0,

    @Column(name = "user_id")
    val userId : UUID,

    @Column(name = "sum_product")
    var sumProduct : Int,

    @Column(name = "has_discount")
    var hasDiscount : Boolean = false,

    @Column(name = "price_tax")
    var priceTax : Double,

    @Column(name = "deliver_cost")
    var deliverCost: Double,

    @Column(name = "price_total")
    var priceTotal : Double,

    @Column(name = "order_date")
    var orderDate : LocalDateTime,

    @Column(name = "order_status")
    var orderStatus : OrderStatus,

    @Column(name = "payment_type")
    var paymentType : String,

    @Column(name = "payment_date")
    var paymentDate : LocalDateTime? = null,

    @Column(name = "ship_date")
    var shipDate : LocalDate? = null,

    @Column(name = "error_code")
    var errorCode : String? = null,

    @Column(name = "error_desc")
    var errorDesc : String? = null,
)
package com.example.futuratwo.model.order

import jakarta.persistence.*
import java.util.UUID

@Entity
@Table(name = "order_items")
class OrderItem (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0,

    @Column(name = "order_id", nullable = false)
    var orderId: Long,

    @Column(name = "product_id")
    var productId: Long,

    @Column(name = "product_sku_id")
    var productSkuId: Long,

    @Column(name = "promotion_id")
    var promotionId: Long? = null,

    @Column(name = "quantity")
    var quantity: Int,

    @Column(name = "discount")
    var discount: Double? = null,

    @Column(name = "prod_price")
    var prodPrice: Double,

    @Column(name = "total_price")
    var totalPrice: Double,
)
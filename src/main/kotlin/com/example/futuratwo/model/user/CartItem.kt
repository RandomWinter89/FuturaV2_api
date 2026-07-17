package com.example.futuratwo.model.user

import jakarta.persistence.*
import java.util.UUID

@Entity
@Table(name = "cart_items")
class CartItem (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @Column(name = "cart_id")
    val cartId : Long,

    @Column(name = "product_id")
    val productId: Long,

    @Column(name = "product_sku_id")
    val productSkuId: Long,

    @Column(name = "quantity")
    val quantity: Int,
)
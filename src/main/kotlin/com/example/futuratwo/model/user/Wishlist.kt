package com.example.futuratwo.model.user

import jakarta.persistence.*
import java.util.UUID

@Entity
@Table(name = "wishlists")
class Wishlist (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id : Long = 0,

    @Column(name = "user_id")
    val userId: UUID,

    @Column(name = "product_id")
    val productId : Long,

    @Column(name = "product_sku_id")
    val productSkuId : String,
)
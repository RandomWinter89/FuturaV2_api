package com.example.futuratwo.model.product

import jakarta.persistence.*

@Entity
@Table(name = "product_images")
class ProductImage (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id : Long = 0,

    @Column(name = "product_sku_id")
    val productSkuId : Long,

    @Column(name = "image_url")
    val imageUrl : String,
)
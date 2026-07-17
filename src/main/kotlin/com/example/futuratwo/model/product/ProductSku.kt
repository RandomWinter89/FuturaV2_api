package com.example.futuratwo.model.product

import jakarta.persistence.*

@Entity
@Table(name = "product_sku")
class ProductSku (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id : Long = 0,

    @Column(name = "product_id")
    val productId : Long,

    //Point toward attribute value
    @Column(name = "color_attribute_id")
    val colorAttributeId : Long,

    @Column(name = "sku")
    val sku : String,

    @Column(name = "base_price")
    val basePrice : Double,

    @Column(name = "sale_price")
    val salePrice : Double? = null,

    //When product sku variants are empty
    @Column(name = "product_available")
    val productAvailable : Boolean = false,
)
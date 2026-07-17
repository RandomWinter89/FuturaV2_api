package com.example.futuratwo.model.product

import jakarta.persistence.*

@Entity
@Table(name = "product_configurations")
class ProductConfiguration (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id : Long = 0,

    @Column(name = "product_sku_id")
    val productSkuId : String,

    @Column(name = "attribute_value_id")
    val attributeValueId : String,
)
package com.example.futuratwo.model.product

import jakarta.persistence.*

@Entity
@Table(name = "product_sku_variants")
class ProductSkuVariant (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id : Long = 0,

    @Column(name = "product_sku_id")
    val productSkuId : String,

    //Point toward attribute value
    @Column(name = "size_attribute_id")
    val sizeAttributeId : Long,

    @Column(name = "stock")
    val stock : Int,

    @Column(name = "extra_price")
    val extraPrice : Double,

    //When stock is empty
    @Column(name = "product_available")
    val productAvailable : Boolean = false,
)
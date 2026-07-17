package com.example.futuratwo.model.product

import com.example.futuratwo.enumerator.GenderType
import jakarta.persistence.*

@Entity
@Table(name = "products")
class Product (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id : Long = 0,

    @Column(name = "name")
    var name: String,

    @Column(name = "description")
    var description: String,

    @Enumerated(EnumType.STRING)
    @Column(name = "gender_type")
    var genderType: GenderType,

    @Column(name = "promotion_id")
    var promotionId: String? = null,

    @Column(name = "promotion_available")
    var promotionAvailable: Boolean = false,

    //When product sku are empty
    @Column(name = "product_available")
    var productAvailable: Boolean = false,
)
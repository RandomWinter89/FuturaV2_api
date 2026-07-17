package com.example.futuratwo.model.product

import jakarta.persistence.*

@Entity
@Table(name = "product_guides")
class ProductGuide (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id : Long,

    @Column(name = "product_id")
    val productId : Long,

    @Column(name = "name")
    val name : String,

    @Column(name = "unit")
    val unit : String,
)
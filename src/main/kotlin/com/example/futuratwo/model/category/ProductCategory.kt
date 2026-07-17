package com.example.futuratwo.model.category

import jakarta.persistence.*

@Entity
@Table(name = "product_categories")
class ProductCategory (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id : Long = 0,

    @Column(name = "category_id")
    val categoryId : Long,

    @Column(name = "product_id")
    val productId : Long,
)
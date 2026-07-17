package com.example.futuratwo.model.product

import com.example.futuratwo.enumerator.LayoutType
import jakarta.persistence.*

@Entity
@Table(name = "product_descriptions")
class ProductDescription (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id : Long,

    @Column(name = "product_id")
    val productId: Long,

    @Column(name = "title")
    val title: String,

    @Column(name = "order")
    val order: Int,

    @Enumerated(EnumType.STRING)
    @Column(name = "layout")
    val layout: LayoutType,
)
package com.example.futuratwo.model.product

import ch.qos.logback.core.Layout
import com.example.futuratwo.enumerator.LayoutType
import jakarta.persistence.*

@Entity
@Table(name = "product_description_details")
class ProductDescriptionDetail (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id : Long,

    @Column(name = "product_description_id")
    val productDescriptionId: Long,

    @Column(name = "image_url")
    val imageUrl: String,

    @Column(name = "content")
    val content: String,

    @Column(name = "order")
    val order: Int,

    @Enumerated(EnumType.STRING)
    @Column(name = "layout")
    val layout: LayoutType,
)
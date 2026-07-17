package com.example.futuratwo.model.category

import jakarta.persistence.*

@Entity
@Table(name = "attribute_categories")
class AttributeCategory (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id : Long,

    @Column(name = "category_id")
    val categoryId : Long,

    @Column(name = "attribute_id")
    val attributeId : Long,
)
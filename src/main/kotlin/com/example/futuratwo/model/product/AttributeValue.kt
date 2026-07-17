package com.example.futuratwo.model.product

import jakarta.persistence.*

@Entity
@Table(name = "attribute_values")
class AttributeValue (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id : Long = 0,

    @Column(name = "attribute_id")
    val attributeId: Long,

    @Column(name = "value")
    val value: String,

    @Column(name = "order")
    val order : Int = 0
)
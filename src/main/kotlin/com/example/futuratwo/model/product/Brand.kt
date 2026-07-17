package com.example.futuratwo.model.product

import jakarta.persistence.*

@Entity
@Table(name = "products")
class Brand (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    @Column(name = "name")
    var name: String,

    @Column(name = "description")
    var description: String,
)
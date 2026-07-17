package com.example.futuratwo.model.user

import jakarta.persistence.*
import java.util.UUID

@Entity
@Table(name = "carts")
class Cart (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @Column(name = "user_id")
    val userId: UUID,

    @Column(name = "sum_product")
    var sumProduct: Int = 0,
)
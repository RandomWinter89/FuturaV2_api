package com.example.futuratwo.model.order

import jakarta.persistence.*

@Entity
@Table(name = "payment_types")
class PaymentType (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id : Int,

    @Column(name = "name")
    var name : String,
)
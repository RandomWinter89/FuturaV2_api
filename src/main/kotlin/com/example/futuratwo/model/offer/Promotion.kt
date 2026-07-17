package com.example.futuratwo.model.offer

import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(name = "promotions")
class Promotion (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id : Long,

    @Column(name = "name")
    val name : String,

    @Column(name = "tagline")
    val tagline : String,

    @Column(name = "description")
    val description : String,

    @Column(name = "discount_rate")
    val discountRate : Double,

    @Column(name = "start_date")
    val startDate : LocalDateTime,

    @Column(name = "end_date")
    val endDate : LocalDateTime
)
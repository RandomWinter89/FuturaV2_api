package com.example.futuratwo.model.location

import jakarta.persistence.*

@Entity
@Table(name = "countries")
class Country (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id : Long = 0,

    @Column(name = "name")
    var name: String,
)
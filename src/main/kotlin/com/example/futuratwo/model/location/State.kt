package com.example.futuratwo.model.location

import jakarta.persistence.*

@Entity
@Table(name = "states")
class State (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id : Long = 0,

    @Column(name = "country_id")
    val countryId: Long,

    @Column(name = "code")
    val code: String,

    @Column(name = "name")
    val name: String
)
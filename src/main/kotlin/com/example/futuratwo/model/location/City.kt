package com.example.futuratwo.model.location

import jakarta.persistence.*

@Entity
@Table(name = "cities")
class City (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id : Long = 0,

    @Column(name = "country_id")
    var countryId: Long,

    @Column(name = "state_id")
    var stateId: Long,

    @Column(name = "name")
    var name : String,
)
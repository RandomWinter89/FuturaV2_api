package com.example.futuratwo.model.location

import jakarta.persistence.*
import java.util.UUID

@Entity
@Table(name = "addresses")
class Address (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id : Long = 0,

    @Column(name = "user_id", nullable = false)
    var userId: UUID,

    @Column(name = "address_line1")
    var addressLine1: String,

    @Column(name = "address_line2")
    var addressLine2: String? = null,

    @Column(name = "address_line3")
    var addressLine3: String? = null,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "country_id", nullable = false)
    var country: Country,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "state_id", nullable = false)
    var state: State,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "city_id", nullable = false)
    var city: City,

    @Column(name = "postcode")
    var postcode: String,

    @Column(name = "is_default")
    var isDefault: Boolean = false,

    )
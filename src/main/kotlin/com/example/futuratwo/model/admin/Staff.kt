package com.example.futuratwo.model.admin

import com.example.futuratwo.enumerator.Position
import jakarta.persistence.*
import java.util.UUID

@Entity
@Table(name = "staffs")
class Staff (
    @Id
    val id : UUID,

    @Column(name = "first_name")
    var firstName: String,

    @Column(name = "last_name")
    var lastName: String,

    @Column(name = "phone")
    var phone: String,

    @Column(name = "email")
    val email: String,

    @Column(name = "password")
    var password: String,

    @Enumerated(EnumType.STRING)
    @Column(name = "position")
    var position: Position,
)
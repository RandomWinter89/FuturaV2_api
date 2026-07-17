package com.example.futuratwo.model.user

import com.example.futuratwo.enumerator.GenderType
import jakarta.persistence.*
import java.time.LocalDate
import java.util.UUID

@Entity
@Table(name = "users")
class User (
    @Id
    val id: UUID,

    @Column(name = "first_name")
    var firstName: String? = null,

    @Column(name = "last_name")
    var lastName: String? = null,

    @Column(name = "username")
    var username: String,

    @Column(name = "phone")
    var phone: String,

    @Column(name = "email")
    val email: String,

    @Column(name = "password")
    var password: String,

    @Column(name = "gender")
    var gender: GenderType,

    @Column(name = "birth_date")
    var birthDate: LocalDate? = null,
)
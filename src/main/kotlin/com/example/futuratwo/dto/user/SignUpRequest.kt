package com.example.futuratwo.dto.user

import com.example.futuratwo.enumerator.GenderType
import java.time.LocalDate

data class SignUpRequest(
    val firstName: String? = null,
    val lastName: String? = null,
    val username: String,
    val phone: String,
    val email: String,
    val password: String,
    val gender: GenderType,
    val birthDate: LocalDate? = null
)
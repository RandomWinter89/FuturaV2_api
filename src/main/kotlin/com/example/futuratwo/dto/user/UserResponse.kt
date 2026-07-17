package com.example.futuratwo.dto.user

import com.example.futuratwo.enumerator.GenderType
import com.example.futuratwo.model.user.User
import java.time.LocalDate
import java.util.UUID

data class UserResponse(
    val id: UUID,
    val firstName: String?,
    val lastName: String?,
    val username: String,
    val phone: String,
    val email: String,
    val gender: GenderType,
    val birthDate: LocalDate?
)

fun User.toResponse() = UserResponse(
    id = id,
    firstName = firstName,
    lastName = lastName,
    username = username,
    phone = phone,
    email = email,
    gender = gender,
    birthDate = birthDate
)
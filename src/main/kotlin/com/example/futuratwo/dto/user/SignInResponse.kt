package com.example.futuratwo.dto.user

data class SignInResponse(
    val token: String,
    val user: UserResponse
)
package com.example.futuratwo.util

import com.example.futuratwo.dto.auth.SignInRequest

object AccountUtil {
    fun validateLogin(request: SignInRequest) : Boolean {
        return request.email.isNotEmpty() && request.password.isNotEmpty()
    }
}
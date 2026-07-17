package com.example.futuratwo.dto.location

import com.example.futuratwo.model.location.State

data class StateResponse(
    val id: Long,
    val code: String,
    val name: String
)

fun State.toResponse() = StateResponse(id = id, code = code, name = name)

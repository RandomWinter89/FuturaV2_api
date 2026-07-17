package com.example.futuratwo.dto.location

import com.example.futuratwo.model.location.City

data class CityResponse(
    val id: Long,
    val name: String
)

fun City.toResponse() = CityResponse(id = id, name = name)
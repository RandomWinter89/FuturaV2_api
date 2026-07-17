package com.example.futuratwo.dto.location

import com.example.futuratwo.model.location.Country

data class CountryResponse(
    val id: Long,
    val name: String
)

fun Country.toResponse() = CountryResponse(id = id, name = name)
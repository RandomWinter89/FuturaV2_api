package com.example.futuratwo.dto.location

import com.example.futuratwo.model.location.Address
import java.util.UUID

data class AddressResponse(
    val id: Long,
    val userId: UUID,
    val addressLine1: String,
    val addressLine2: String?,
    val addressLine3: String?,
    val country: CountryResponse,
    val state: StateResponse,
    val city: CityResponse,
    val postcode: String,
    val isDefault: Boolean
)

fun Address.toResponse() = AddressResponse(
    id = id,
    userId = userId,
    addressLine1 = addressLine1,
    addressLine2 = addressLine2,
    addressLine3 = addressLine3,
    country = country.toResponse(),
    state = state.toResponse(),
    city = city.toResponse(),
    postcode = postcode,
    isDefault = isDefault
)
package com.example.futuratwo.dto.location

import java.util.UUID

data class AddressRequest(
    val userId: UUID,
    val addressLine1: String,
    val addressLine2: String? = null,
    val addressLine3: String? = null,
    val countryId: Long,
    val stateId: Long,
    val cityId: Long,
    val postcode: String,
    val isDefault: Boolean = false
)

package com.example.futuratwo.controller.location

import com.example.futuratwo.dto.location.AddressRequest
import com.example.futuratwo.dto.location.AddressResponse
import com.example.futuratwo.dto.location.CityResponse
import com.example.futuratwo.dto.location.CountryResponse
import com.example.futuratwo.dto.location.StateResponse
import com.example.futuratwo.dto.location.toResponse
import com.example.futuratwo.model.location.Address
import com.example.futuratwo.repository.location.AddressRepository
import com.example.futuratwo.repository.location.CityRepository
import com.example.futuratwo.repository.location.CountryRepository
import com.example.futuratwo.repository.location.StateRepository
import jakarta.persistence.EntityNotFoundException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.UUID

@RestController
@RequestMapping("/api/address")
class AddressController(
    private val addressRepository: AddressRepository,
    private val countryRepository: CountryRepository,
    private val stateRepository: StateRepository,
    private val cityRepository: CityRepository
) {

    @PostMapping("/create-address")
    fun createAddress(@RequestBody request: AddressRequest): ResponseEntity<AddressResponse> {
        val country = countryRepository.findById(request.countryId)
            .orElseThrow { EntityNotFoundException("Country not found with id ${request.countryId}") }
        val state = stateRepository.findById(request.stateId)
            .orElseThrow { EntityNotFoundException("State not found with id ${request.stateId}") }
        val city = cityRepository.findById(request.cityId)
            .orElseThrow { EntityNotFoundException("City not found with id ${request.cityId}") }

        val address = Address(
            userId = request.userId,
            addressLine1 = request.addressLine1,
            addressLine2 = request.addressLine2,
            addressLine3 = request.addressLine3,
            country = country,
            state = state,
            city = city,
            postcode = request.postcode,
            isDefault = request.isDefault
        )
        val saved = addressRepository.save(address)
        return ResponseEntity.status(HttpStatus.CREATED).body(saved.toResponse())
    }

    @GetMapping("/address/{id}")
    fun getAddress(@PathVariable id: Long): ResponseEntity<AddressResponse> {
        val address = addressRepository.findByIdWithLocations(id)
            ?: throw EntityNotFoundException("Address not found with id $id")
        return ResponseEntity.ok(address.toResponse())
    }

    @GetMapping("/user/{userId}/addresses")
    fun getAddressesByUser(@PathVariable userId: UUID): ResponseEntity<List<AddressResponse>> {
        val addresses = addressRepository.findByUserIdWithLocations(userId).map { it.toResponse() }
        return ResponseEntity.ok(addresses)
    }

    @PutMapping("/address/{id}/edit")
    fun editAddress(
        @PathVariable id: Long,
        @RequestBody request: AddressRequest
    ): ResponseEntity<AddressResponse> {
        val address = addressRepository.findById(id)
            .orElseThrow { EntityNotFoundException("Address not found with id $id") }

        val country = countryRepository.findById(request.countryId)
            .orElseThrow { EntityNotFoundException("Country not found with id ${request.countryId}") }
        val state = stateRepository.findById(request.stateId)
            .orElseThrow { EntityNotFoundException("State not found with id ${request.stateId}") }
        val city = cityRepository.findById(request.cityId)
            .orElseThrow { EntityNotFoundException("City not found with id ${request.cityId}") }

        address.userId = request.userId
        address.addressLine1 = request.addressLine1
        address.addressLine2 = request.addressLine2
        address.addressLine3 = request.addressLine3
        address.country = country
        address.state = state
        address.city = city
        address.postcode = request.postcode
        address.isDefault = request.isDefault

        val saved = addressRepository.save(address)
        return ResponseEntity.ok(saved.toResponse())
    }

    @DeleteMapping("/address/{id}/delete")
    fun deleteAddress(@PathVariable id: Long): ResponseEntity<Void> {
        if (!addressRepository.existsById(id)) {
            throw EntityNotFoundException("Address not found with id $id")
        }
        addressRepository.deleteById(id)
        return ResponseEntity.noContent().build()
    }

    @GetMapping("/country")
    fun getCountries(): ResponseEntity<List<CountryResponse>> {
        val countries = countryRepository.findAll().map { it.toResponse() }
        return ResponseEntity.ok(countries)
    }

    @GetMapping("/state")
    fun getStates(@RequestParam("country_id") countryId: Long): ResponseEntity<List<StateResponse>> {
        val states = stateRepository.findByCountryId(countryId).map { it.toResponse() }
        return ResponseEntity.ok(states)
    }

    @GetMapping("/city")
    fun getCities(@RequestParam("state_id") stateId: Long): ResponseEntity<List<CityResponse>> {
        val cities = cityRepository.findByStateId(stateId).map { it.toResponse() }
        return ResponseEntity.ok(cities)
    }
}
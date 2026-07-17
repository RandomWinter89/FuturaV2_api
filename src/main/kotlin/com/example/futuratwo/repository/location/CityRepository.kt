package com.example.futuratwo.repository.location

import com.example.futuratwo.model.location.City
import org.springframework.data.jpa.repository.JpaRepository

interface CityRepository : JpaRepository<City, Long> {
    fun findByStateId(stateId: Long): List<City>
}
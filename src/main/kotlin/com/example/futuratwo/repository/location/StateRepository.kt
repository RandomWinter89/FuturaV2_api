package com.example.futuratwo.repository.location

import com.example.futuratwo.model.location.State
import org.springframework.data.jpa.repository.JpaRepository

interface StateRepository : JpaRepository<State, Long> {
    fun findByCountryId(countryId: Long): List<State>
}
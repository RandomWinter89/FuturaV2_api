package com.example.futuratwo.repository.location

import com.example.futuratwo.model.location.Country
import org.springframework.data.jpa.repository.JpaRepository

interface CountryRepository : JpaRepository<Country, Long> {
}
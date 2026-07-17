package com.example.futuratwo.repository.location

import com.example.futuratwo.model.location.Address
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import java.util.UUID

interface AddressRepository : JpaRepository<Address, Long> {
    @Query("""
        SELECT a FROM Address a
        JOIN FETCH a.country
        JOIN FETCH a.state
        JOIN FETCH a.city
    """)
    fun findAllWithLocations(): List<Address>

    @Query("""
        SELECT a FROM Address a
        JOIN FETCH a.country
        JOIN FETCH a.state
        JOIN FETCH a.city
        WHERE a.id = :id
    """)
    fun findByIdWithLocations(id: Long): Address?

    @Query("""
        SELECT a FROM Address a 
        JOIN FETCH a.country 
        JOIN FETCH a.state 
        JOIN FETCH a.city 
        WHERE a.userId = :userId
    """)
    fun findByUserIdWithLocations(userId: UUID): List<Address>
}
package com.example.futuratwo.repository.user

import org.springframework.data.jpa.repository.JpaRepository
import com.example.futuratwo.model.user.User
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import java.util.Optional
import java.util.UUID

interface UserRepository : JpaRepository<User, UUID> {
    fun findByEmail(email: String): Optional<User>
    fun existsByEmail(email: String): Boolean
    fun existsByUsername(username: String): Boolean
    override fun findAll(pageable: Pageable): Page<User>
}
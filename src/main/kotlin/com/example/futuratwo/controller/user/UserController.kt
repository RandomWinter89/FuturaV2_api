package com.example.futuratwo.controller.user

import com.example.futuratwo.dto.user.UpdateUserRequest
import com.example.futuratwo.dto.user.UserResponse
import com.example.futuratwo.dto.user.toResponse
import com.example.futuratwo.repository.user.UserRepository
import jakarta.persistence.EntityNotFoundException
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Sort
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.UUID

@RestController
@RequestMapping("/api/users")
class UserController(
    private val userRepository: UserRepository
) {

    // Get User (List) - For Admin
    @GetMapping
    fun getUsers(
        @RequestParam(defaultValue = "0") page: Int,
        @RequestParam(defaultValue = "20") size: Int
    ): ResponseEntity<List<UserResponse>> {
        val users = userRepository
            .findAll(PageRequest.of(page, size, Sort.by("username")))
            .map { it.toResponse() }
        return ResponseEntity.ok(users.content)
    }

    // Get User (Detail) - For Admin
    @GetMapping("/{id}")
    fun getUser(@PathVariable id: UUID): ResponseEntity<UserResponse> {
        val user = userRepository.findById(id)
            .orElseThrow { EntityNotFoundException("User not found with id $id") }
        return ResponseEntity.ok(user.toResponse())
    }

    // Edit User
    @PutMapping("/{id}/edit")
    fun editUser(
        @PathVariable id: UUID,
        @RequestBody request: UpdateUserRequest
    ): ResponseEntity<UserResponse> {
        val user = userRepository.findById(id)
            .orElseThrow { EntityNotFoundException("User not found with id $id") }

        if (userRepository.existsByUsername(request.username) && user.username != request.username) {
            throw IllegalArgumentException("Username already taken: ${request.username}")
        }

        user.firstName = request.firstName
        user.lastName = request.lastName
        user.username = request.username
        user.phone = request.phone
        user.gender = request.gender
        user.birthDate = request.birthDate

        val saved = userRepository.save(user)
        return ResponseEntity.ok(saved.toResponse())
    }

    // Delete User
    @DeleteMapping("/{id}/delete")
    fun deleteUser(@PathVariable id: UUID): ResponseEntity<Void> {
        if (!userRepository.existsById(id)) {
            throw EntityNotFoundException("User not found with id $id")
        }
        userRepository.deleteById(id)
        return ResponseEntity.noContent().build()
    }
}
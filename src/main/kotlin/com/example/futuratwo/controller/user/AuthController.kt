package com.example.futuratwo.controller.auth

import com.example.futuratwo.dto.user.SignInRequest
import com.example.futuratwo.dto.user.SignInResponse
import com.example.futuratwo.dto.user.SignUpRequest
import com.example.futuratwo.dto.user.UserResponse
import com.example.futuratwo.dto.user.toResponse
import com.example.futuratwo.model.user.User
import com.example.futuratwo.repository.user.UserRepository
import com.example.futuratwo.service.auth.JwtService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.web.bind.annotation.*
import java.util.UUID

@RestController
@RequestMapping("/api/auth")
class AuthController(
    private val userRepository: UserRepository,
    private val passwordEncoder: PasswordEncoder,
    private val jwtService: JwtService
) {

    @PostMapping("/sign-up")
    fun signUp(@RequestBody request: SignUpRequest): ResponseEntity<UserResponse> {
        if (userRepository.existsByEmail(request.email)) {
            throw IllegalArgumentException("Email already in use: ${request.email}")
        }
        if (userRepository.existsByUsername(request.username)) {
            throw IllegalArgumentException("Username already taken: ${request.username}")
        }

        val user = User(
            id = UUID.randomUUID(),
            firstName = request.firstName,
            lastName = request.lastName,
            username = request.username,
            phone = request.phone,
            email = request.email,
            password = passwordEncoder.encode(request.password)!!,
            gender = request.gender,
            birthDate = request.birthDate
        )
        val saved = userRepository.save(user)
        return ResponseEntity.status(HttpStatus.CREATED).body(saved.toResponse())
    }

    @PostMapping("/sign-in")
    fun signIn(@RequestBody request: SignInRequest): ResponseEntity<SignInResponse> {
        val user = userRepository.findByEmail(request.email)
            .orElseThrow { IllegalArgumentException("Invalid email or password") }

        if (!passwordEncoder.matches(request.password, user.password)) {
            throw IllegalArgumentException("Invalid email or password")
        }

        val token = jwtService.generateToken(user.id.toString(), user.email)
        return ResponseEntity.ok(SignInResponse(token = token, user = user.toResponse()))
    }
}
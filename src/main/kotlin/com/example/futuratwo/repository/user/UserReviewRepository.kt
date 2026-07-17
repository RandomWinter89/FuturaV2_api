package com.example.futuratwo.repository.user

import com.example.futuratwo.model.user.UserReview
import org.springframework.data.jpa.repository.JpaRepository

interface UserReviewRepository : JpaRepository<UserReview, Long> {
}
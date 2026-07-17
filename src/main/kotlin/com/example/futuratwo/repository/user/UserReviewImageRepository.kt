package com.example.futuratwo.repository.user

import com.example.futuratwo.model.user.UserReviewImage
import org.springframework.data.jpa.repository.JpaRepository

interface UserReviewImageRepository : JpaRepository<UserReviewImage, Long> {
}
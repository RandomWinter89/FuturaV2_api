package com.example.futuratwo.model.user

import jakarta.persistence.*
import java.util.UUID

@Entity
@Table(name = "user_review_images")
class UserReviewImage (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @Column(name = "user_id")
    val userId: UUID,

    @Column(name = "product_id")
    val productId: Long,

    @Column(name = "review_id")
    val reviewId: Long,

    @Column(name = "image_url")
    val imageUrl: String,
)
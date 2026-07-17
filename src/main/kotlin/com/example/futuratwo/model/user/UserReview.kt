package com.example.futuratwo.model.user

import jakarta.persistence.*
import java.util.UUID

@Entity
@Table(name = "user_review")
class UserReview (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id : Long = 0,

    @Column(name = "user_id")
    val userId : UUID,

    @Column(name = "product_id")
    val productId : Int,

    @Column(name = "rating")
    val rating : Float = 3.0f,

    @Column(name = "title")
    val title : String,

    @Column(name = "content")
    var content : String,
)
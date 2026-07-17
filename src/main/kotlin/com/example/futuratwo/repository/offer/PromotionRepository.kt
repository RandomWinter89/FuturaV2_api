package com.example.futuratwo.repository.offer

import com.example.futuratwo.model.offer.Promotion
import org.springframework.data.jpa.repository.JpaRepository

interface PromotionRepository : JpaRepository<Promotion, Long> {
}
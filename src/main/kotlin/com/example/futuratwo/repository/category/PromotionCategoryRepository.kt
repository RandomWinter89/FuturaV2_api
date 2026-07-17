package com.example.futuratwo.repository.category

import com.example.futuratwo.model.category.PromotionCategory
import org.springframework.data.jpa.repository.JpaRepository

interface PromotionCategoryRepository : JpaRepository<PromotionCategory, Long> {
}
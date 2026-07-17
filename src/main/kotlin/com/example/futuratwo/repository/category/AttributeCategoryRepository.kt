package com.example.futuratwo.repository.category

import com.example.futuratwo.model.category.AttributeCategory
import org.springframework.data.jpa.repository.JpaRepository

interface AttributeCategoryRepository : JpaRepository<AttributeCategory, Long> {
}
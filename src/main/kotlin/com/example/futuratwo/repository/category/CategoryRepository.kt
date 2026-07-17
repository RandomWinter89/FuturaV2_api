package com.example.futuratwo.repository.category

import com.example.futuratwo.model.category.Category
import org.springframework.data.jpa.repository.JpaRepository

interface CategoryRepository : JpaRepository<Category, Long> {
    fun findByParentCategoryIsNull(): List<Category>
}
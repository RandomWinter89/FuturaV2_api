package com.example.futuratwo.repository.category

import com.example.futuratwo.model.category.ProductCategory
import org.springframework.data.jpa.repository.JpaRepository

interface ProductCategoryRepository : JpaRepository<ProductCategory, Long> {
    fun findByProductId(productId: Long): List<ProductCategory>
    fun findByCategoryId(categoryId: Long): List<ProductCategory>
}
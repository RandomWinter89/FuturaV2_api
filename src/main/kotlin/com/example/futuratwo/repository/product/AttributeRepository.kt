package com.example.futuratwo.repository.product

import com.example.futuratwo.model.product.Attribute
import org.springframework.data.jpa.repository.JpaRepository

interface AttributeRepository : JpaRepository<Attribute, Long> {
    fun findByCategoryId(categoryId: Long): List<Attribute>
}
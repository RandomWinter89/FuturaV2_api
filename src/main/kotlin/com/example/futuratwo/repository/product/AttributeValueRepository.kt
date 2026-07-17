package com.example.futuratwo.repository.product

import com.example.futuratwo.model.product.AttributeValue
import org.springframework.data.jpa.repository.JpaRepository

interface AttributeValueRepository : JpaRepository<AttributeValue, Long> {
    fun findByAttributeId(attributeId: Long): List<AttributeValue>
}
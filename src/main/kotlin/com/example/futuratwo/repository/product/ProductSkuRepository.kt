package com.example.futuratwo.repository.product

import com.example.futuratwo.model.product.ProductSku
import org.springframework.data.jpa.repository.JpaRepository

interface ProductSkuRepository : JpaRepository<ProductSku, Long> {
    fun findByProductId(productId: Long): List<ProductSku>
}
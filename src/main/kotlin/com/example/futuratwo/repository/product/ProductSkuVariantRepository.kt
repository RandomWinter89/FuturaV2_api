package com.example.futuratwo.repository.product

import com.example.futuratwo.model.product.ProductSkuVariant
import org.springframework.data.jpa.repository.JpaRepository

interface ProductSkuVariantRepository : JpaRepository<ProductSkuVariant, Long> {
    fun findByProductSkuId(productSkuId: String): List<ProductSkuVariant>
}
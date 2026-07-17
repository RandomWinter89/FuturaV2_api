package com.example.futuratwo.repository.product

import com.example.futuratwo.model.product.ProductImage
import org.springframework.data.jpa.repository.JpaRepository

interface ProductImageRepository : JpaRepository<ProductImage, Long> {
}
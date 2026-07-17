package com.example.futuratwo.repository.product

import com.example.futuratwo.model.product.ProductDescription
import org.springframework.data.jpa.repository.JpaRepository

interface ProductDescriptionRepository : JpaRepository<ProductDescription, Long> {
}
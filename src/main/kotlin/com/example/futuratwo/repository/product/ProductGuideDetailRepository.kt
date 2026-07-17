package com.example.futuratwo.repository.product

import com.example.futuratwo.model.product.ProductGuideDetail
import org.springframework.data.jpa.repository.JpaRepository

interface ProductGuideDetailRepository : JpaRepository<ProductGuideDetail, Long> {
}
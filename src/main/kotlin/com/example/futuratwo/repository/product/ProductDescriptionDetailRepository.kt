package com.example.futuratwo.repository.product

import com.example.futuratwo.model.product.ProductDescriptionDetail
import org.springframework.data.jpa.repository.JpaRepository

interface ProductDescriptionDetailRepository : JpaRepository<ProductDescriptionDetail, Long> {
}
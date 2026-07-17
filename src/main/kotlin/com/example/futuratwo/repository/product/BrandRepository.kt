package com.example.futuratwo.repository.product

import com.example.futuratwo.model.product.Brand
import org.springframework.data.jpa.repository.JpaRepository

interface BrandRepository : JpaRepository<Brand, Long> {
}
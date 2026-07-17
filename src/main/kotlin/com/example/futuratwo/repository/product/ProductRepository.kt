package com.example.futuratwo.repository.product

import com.example.futuratwo.model.product.Product
import org.springframework.data.jpa.repository.JpaRepository

interface ProductRepository : JpaRepository<Product, Long> {
}
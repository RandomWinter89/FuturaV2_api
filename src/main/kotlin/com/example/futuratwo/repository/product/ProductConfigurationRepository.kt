package com.example.futuratwo.repository.product

import com.example.futuratwo.model.product.ProductConfiguration
import org.springframework.data.jpa.repository.JpaRepository

interface ProductConfigurationRepository : JpaRepository<ProductConfiguration, Long> {
}
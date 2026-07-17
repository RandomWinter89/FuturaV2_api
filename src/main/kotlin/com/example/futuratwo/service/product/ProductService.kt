package com.example.futuratwo.service.product

import com.example.futuratwo.model.product.Product
import com.example.futuratwo.repository.product.ProductRepository
import org.springframework.stereotype.Service

@Service
class ProductService(
    private val repo: ProductRepository
) {
    fun getAll(): List<Product> = repo.findAll()
    fun getById(id: Long): Product = repo.findById(id).orElseThrow { NoSuchElementException("Product not found: $id") }
    fun create(product: Product): Product = repo.save(product)
    fun update(id: Long, updated: Product): Product {
        val existing = getById(id)
        existing.name = updated.name
        existing.description = updated.description
        existing.genderType = updated.genderType
        existing.promotionId = updated.promotionId
        existing.promotionAvailable = updated.promotionAvailable
        existing.productAvailable = updated.productAvailable
        return repo.save(existing)
    }
    fun delete(id: Long) = repo.deleteById(id)
}
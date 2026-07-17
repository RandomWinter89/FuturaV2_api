package com.example.futuratwo.service.category

import com.example.futuratwo.model.category.ProductCategory
import com.example.futuratwo.repository.category.ProductCategoryRepository
import org.springframework.stereotype.Service

@Service
class ProductCategoryService(private val repo: ProductCategoryRepository) {
    fun getAll(): List<ProductCategory> = repo.findAll()
    fun getById(id: Long): ProductCategory = repo.findById(id).orElseThrow { NoSuchElementException("ProductCategory not found: $id") }
    fun getByProductId(productId: Long): List<ProductCategory> = repo.findByProductId(productId)
    fun getByCategoryId(categoryId: Long): List<ProductCategory> = repo.findByCategoryId(categoryId)
    fun create(pc: ProductCategory): ProductCategory = repo.save(pc)
    fun update(id: Long, pc: ProductCategory): ProductCategory {
        getById(id)
        val updated = ProductCategory(
            id = id,
            categoryId = pc.categoryId,
            productId = pc.productId
        )
        return repo.save(updated)
    }
    fun delete(id: Long) = repo.deleteById(id)
}
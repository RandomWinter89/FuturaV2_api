package com.example.futuratwo.service.product

import com.example.futuratwo.model.product.ProductSku
import com.example.futuratwo.repository.product.ProductRepository
import com.example.futuratwo.repository.product.ProductSkuRepository
import org.springframework.stereotype.Service

@Service
class ProductSkuService(
    private val repo: ProductSkuRepository,
    private val productRepo: ProductRepository
) {
    fun getAll(): List<ProductSku> = repo.findAll()
    fun getById(id: Long): ProductSku = repo.findById(id).orElseThrow { NoSuchElementException("ProductSku not found: $id") }
    fun getByProductId(productId: Long): List<ProductSku> {
        productRepo.findById(productId).orElseThrow { NoSuchElementException("Product not found: $productId") }
        return repo.findByProductId(productId)
    }
    fun create(sku: ProductSku): ProductSku = repo.save(sku)
    fun update(id: Long, sku: ProductSku): ProductSku {
        getById(id)
        val updated = ProductSku(
            id = id,
            productId = sku.productId,
            colorAttributeId = sku.colorAttributeId,
            sku = sku.sku,
            basePrice = sku.basePrice,
            salePrice = sku.salePrice,
            productAvailable = sku.productAvailable
        )
        return repo.save(updated)
    }
    fun delete(id: Long) = repo.deleteById(id)
}
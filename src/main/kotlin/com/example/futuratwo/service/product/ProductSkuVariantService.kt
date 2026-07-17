package com.example.futuratwo.service.product

import com.example.futuratwo.model.product.ProductSkuVariant
import com.example.futuratwo.repository.product.ProductSkuVariantRepository
import org.springframework.stereotype.Service

@Service
class ProductSkuVariantService(private val repo: ProductSkuVariantRepository) {
    fun getAll(): List<ProductSkuVariant> = repo.findAll()
    fun getById(id: Long): ProductSkuVariant = repo.findById(id).orElseThrow { NoSuchElementException("ProductSkuVariant not found: $id") }
    fun getByProductSkuId(productSkuId: String): List<ProductSkuVariant> = repo.findByProductSkuId(productSkuId)
    fun create(variant: ProductSkuVariant): ProductSkuVariant = repo.save(variant)
    fun update(id: Long, variant: ProductSkuVariant): ProductSkuVariant {
        getById(id)
        val updated = ProductSkuVariant(
            id = id,
            productSkuId = variant.productSkuId,
            sizeAttributeId = variant.sizeAttributeId,
            stock = variant.stock,
            extraPrice = variant.extraPrice,
            productAvailable = variant.productAvailable
        )
        return repo.save(updated)
    }
    fun delete(id: Long) = repo.deleteById(id)
}
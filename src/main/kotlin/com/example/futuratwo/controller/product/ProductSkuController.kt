package com.example.futuratwo.controller.product

import com.example.futuratwo.model.product.ProductSku
import com.example.futuratwo.model.product.ProductSkuVariant
import com.example.futuratwo.service.product.ProductSkuService
import com.example.futuratwo.service.product.ProductSkuVariantService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/product-skus")
class ProductSkuController(
    private val service: ProductSkuService,
    private val variantService: ProductSkuVariantService
) {
    @GetMapping
    fun getAll(): List<ProductSku> = service.getAll()

    @GetMapping("/{id}")
    fun getById(@PathVariable id: Long): ProductSku = service.getById(id)

    @GetMapping("/{id}/variants")
    fun getVariantsBySkuId(@PathVariable id: Long): List<ProductSkuVariant> {
        val sku = service.getById(id)
        return variantService.getByProductSkuId(sku.sku)
    }

    @PostMapping
    fun create(@RequestBody sku: ProductSku): ProductSku = service.create(sku)

    @PutMapping("/{id}")
    fun update(@PathVariable id: Long, @RequestBody sku: ProductSku): ProductSku = service.update(id, sku)

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long) = service.delete(id)
}
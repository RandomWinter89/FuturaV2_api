package com.example.futuratwo.controller.product

import com.example.futuratwo.model.product.ProductSkuVariant
import com.example.futuratwo.service.product.ProductSkuVariantService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/product-sku-variants")
class ProductSkuVariantController(private val service: ProductSkuVariantService) {
    @GetMapping
    fun getAll(): List<ProductSkuVariant> = service.getAll()

    @GetMapping("/{id}")
    fun getById(@PathVariable id: Long): ProductSkuVariant = service.getById(id)

    @PostMapping
    fun create(@RequestBody variant: ProductSkuVariant): ProductSkuVariant = service.create(variant)

    @PutMapping("/{id}")
    fun update(@PathVariable id: Long, @RequestBody variant: ProductSkuVariant): ProductSkuVariant = service.update(id, variant)

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long) = service.delete(id)
}
package com.example.futuratwo.controller.category

import com.example.futuratwo.model.category.ProductCategory
import com.example.futuratwo.service.category.ProductCategoryService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/product-categories")
class ProductCategoryController(private val service: ProductCategoryService) {
    @GetMapping
    fun getAll(
        @RequestParam(required = false) productId: Long?,
        @RequestParam(required = false) categoryId: Long?
    ): List<ProductCategory> = when {
        productId != null -> service.getByProductId(productId)
        categoryId != null -> service.getByCategoryId(categoryId)
        else -> service.getAll()
    }

    @GetMapping("/{id}")
    fun getById(@PathVariable id: Long): ProductCategory = service.getById(id)

    @PostMapping
    fun create(@RequestBody pc: ProductCategory): ProductCategory = service.create(pc)

    @PutMapping("/{id}")
    fun update(@PathVariable id: Long, @RequestBody pc: ProductCategory): ProductCategory = service.update(id, pc)

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long) = service.delete(id)
}
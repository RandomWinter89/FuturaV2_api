package com.example.futuratwo.controller.product

import com.example.futuratwo.model.product.Product
import com.example.futuratwo.model.product.ProductSku
import com.example.futuratwo.service.product.ProductService
import com.example.futuratwo.service.product.ProductSkuService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/products")
class ProductController(
    private val service: ProductService,
    private val skuService: ProductSkuService
) {
    @GetMapping
    fun getAll(): List<Product> = service.getAll()

    @GetMapping("/{id}")
    fun getById(@PathVariable id: Long): Product = service.getById(id)

    @GetMapping("/{id}/skus")
    fun getSkusByProductId(@PathVariable id: Long): List<ProductSku> = skuService.getByProductId(id)

    @PostMapping
    fun create(@RequestBody product: Product): Product = service.create(product)

    @PutMapping("/{id}")
    fun update(@PathVariable id: Long, @RequestBody product: Product): Product = service.update(id, product)

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long) = service.delete(id)
}
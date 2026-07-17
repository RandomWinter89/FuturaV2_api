package com.example.futuratwo.controller.product

import com.example.futuratwo.model.product.Attribute
import com.example.futuratwo.service.product.AttributeService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/attributes")
class AttributeController(private val service: AttributeService) {
    @GetMapping
    fun getAll(@RequestParam(required = false) categoryId: Long?): List<Attribute> =
        if (categoryId != null) service.getByCategoryId(categoryId) else service.getAll()

    @GetMapping("/{id}")
    fun getById(@PathVariable id: Long): Attribute = service.getById(id)

    @PostMapping
    fun create(@RequestBody attribute: Attribute): Attribute = service.create(attribute)

    @PutMapping("/{id}")
    fun update(@PathVariable id: Long, @RequestBody attribute: Attribute): Attribute = service.update(id, attribute)

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long) = service.delete(id)
}
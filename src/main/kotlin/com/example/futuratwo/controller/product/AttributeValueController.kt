package com.example.futuratwo.controller.product

import com.example.futuratwo.model.product.AttributeValue
import com.example.futuratwo.service.product.AttributeValueService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/attribute-values")
class AttributeValueController(private val service: AttributeValueService) {
    @GetMapping
    fun getAll(@RequestParam(required = false) attributeId: Long?): List<AttributeValue> =
        if (attributeId != null) service.getByAttributeId(attributeId) else service.getAll()

    @GetMapping("/{id}")
    fun getById(@PathVariable id: Long): AttributeValue = service.getById(id)

    @PostMapping
    fun create(@RequestBody value: AttributeValue): AttributeValue = service.create(value)

    @PutMapping("/{id}")
    fun update(@PathVariable id: Long, @RequestBody value: AttributeValue): AttributeValue = service.update(id, value)

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long) = service.delete(id)
}
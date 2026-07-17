package com.example.futuratwo.service.product

import com.example.futuratwo.model.product.AttributeValue
import com.example.futuratwo.repository.product.AttributeValueRepository
import org.springframework.stereotype.Service

@Service
class AttributeValueService(private val repo: AttributeValueRepository) {
    fun getAll(): List<AttributeValue> = repo.findAll()
    fun getById(id: Long): AttributeValue = repo.findById(id).orElseThrow { NoSuchElementException("AttributeValue not found: $id") }
    fun getByAttributeId(attributeId: Long): List<AttributeValue> = repo.findByAttributeId(attributeId)
    fun create(value: AttributeValue): AttributeValue = repo.save(value)
    fun update(id: Long, value: AttributeValue): AttributeValue {
        getById(id)
        val updated = AttributeValue(
            id = id,
            attributeId = value.attributeId,
            value = value.value,
            order = value.order
        )
        return repo.save(updated)
    }
    fun delete(id: Long) = repo.deleteById(id)
}
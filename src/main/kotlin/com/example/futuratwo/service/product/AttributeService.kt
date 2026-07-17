package com.example.futuratwo.service.product

import com.example.futuratwo.model.product.Attribute
import com.example.futuratwo.repository.product.AttributeRepository
import org.springframework.stereotype.Service

@Service
class AttributeService(private val repo: AttributeRepository) {
    fun getAll(): List<Attribute> = repo.findAll()
    fun getById(id: Long): Attribute = repo.findById(id).orElseThrow { NoSuchElementException("Attribute not found: $id") }
    fun getByCategoryId(categoryId: Long): List<Attribute> = repo.findByCategoryId(categoryId)
    fun create(attribute: Attribute): Attribute = repo.save(attribute)
    fun update(id: Long, attribute: Attribute): Attribute {
        getById(id)
        val updated = Attribute(
            id = id,
            categoryId = attribute.categoryId,
            name = attribute.name,
            dataType = attribute.dataType
        )
        return repo.save(updated)
    }
    fun delete(id: Long) = repo.deleteById(id)
}
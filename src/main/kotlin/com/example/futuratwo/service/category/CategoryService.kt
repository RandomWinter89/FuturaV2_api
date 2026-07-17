package com.example.futuratwo.service.category

import com.example.futuratwo.dto.category.CategoryResponse
import com.example.futuratwo.model.category.Category
import com.example.futuratwo.repository.category.CategoryRepository
import org.springframework.stereotype.Service

@Service
class CategoryService(
    private val categoryRepository: CategoryRepository
) {
    fun getAllParentCategoriesWithSubs(): List<CategoryResponse> {
        val parents = categoryRepository.findByParentCategoryIsNull()
        return parents.map { it.toResponse() }
    }

    private fun Category.toResponse(): CategoryResponse = CategoryResponse(
        id = this.id,
        name = this.name,
        previewImageUrl = this.previewImageUrl,
        subCategories = this.subCategories.map {
            CategoryResponse(
                id = it.id,
                name = it.name,
                previewImageUrl = it.previewImageUrl
            )
        }
    )
}
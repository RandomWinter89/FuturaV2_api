package com.example.futuratwo.dto.category

data class CategoryResponse(
    val id : Long,
    val name : String,
    val previewImageUrl : String? = null,
    val subCategories: List<CategoryResponse> = emptyList()
)

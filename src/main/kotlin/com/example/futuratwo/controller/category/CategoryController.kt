package com.example.futuratwo.controller.category

import com.example.futuratwo.dto.category.CategoryResponse
import com.example.futuratwo.service.category.CategoryService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/category")
class CategoryController(
    private val categoryService: CategoryService
) {
    @GetMapping("/categories")
    fun getCategories(): List<CategoryResponse> {
        return categoryService.getAllParentCategoriesWithSubs()
    }
}
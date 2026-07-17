package com.example.futuratwo.model.category

import jakarta.persistence.*

@Entity
@Table(name = "categories")
class Category(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @Column(name = "name", nullable = false)
    val name: String,

    @Column(name = "preview_image_url")
    val previewImageUrl: String,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_category_id")
    val parentCategory: Category? = null,

    @OneToMany(mappedBy = "parentCategory", cascade = [CascadeType.ALL], orphanRemoval = true)
    val subCategories: MutableList<Category> = mutableListOf(),

    ) {
    val isSubCategory: Boolean
        get() = parentCategory != null
}
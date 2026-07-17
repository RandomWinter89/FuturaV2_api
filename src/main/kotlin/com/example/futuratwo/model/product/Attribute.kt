package com.example.futuratwo.model.product

import com.example.futuratwo.enumerator.DataType
import jakarta.persistence.*

@Entity
@Table(name = "attributes")
class Attribute (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id : Long = 0,

    @Column(name = "category_id")
    val categoryId: Long,

    @Column(name = "name")
    val name: String,

    @Enumerated(EnumType.STRING)
    @Column(name = "data_type")
    val dataType: DataType,
)
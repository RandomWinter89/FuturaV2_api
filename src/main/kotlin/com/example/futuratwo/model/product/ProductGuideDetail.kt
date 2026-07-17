package com.example.futuratwo.model.product

import com.example.futuratwo.enumerator.MeasurementType
import jakarta.persistence.*

@Entity
@Table(name = "product_guide_details")
class ProductGuideDetail (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id : Long,

    @Column(name = "product_guide_id")
    val productGuideId : String,

    @Column(name = "label")
    val label : String,

    @Enumerated(EnumType.STRING)
    @Column(name = "measurement_type")
    val measurementType : MeasurementType,

    @Column(name = "value")
    val value : String
)
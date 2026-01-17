package com.example.lyceum_saturday10_2025.features.goods.presentation.model

import kotlinx.serialization.Serializable

@Serializable
data class GoodsItem(
    val id: Int = 0,
    val name: String,
    val rating: Int,
    val description: String,
    val imageURL: String,
)

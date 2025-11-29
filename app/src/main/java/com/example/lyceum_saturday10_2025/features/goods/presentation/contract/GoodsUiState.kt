package com.example.lyceum_saturday10_2025.features.goods.presentation.contract

import com.example.lyceum_saturday10_2025.features.goods.presentation.model.GoodsItem


data class GoodsUiState(
    val items: List<GoodsItem> = emptyList()
)
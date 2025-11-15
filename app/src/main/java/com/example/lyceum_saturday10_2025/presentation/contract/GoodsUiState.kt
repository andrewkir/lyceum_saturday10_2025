package com.example.lyceum_saturday10_2025.presentation.contract

import com.example.lyceum_saturday10_2025.presentation.model.GoodsItem


data class GoodsUiState(
    val items: List<GoodsItem> = emptyList()
)
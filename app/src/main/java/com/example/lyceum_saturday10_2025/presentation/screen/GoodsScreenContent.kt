package com.example.lyceum_saturday10_2025.presentation.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.lyceum_saturday10_2025.presentation.components.GoodsCard
import com.example.lyceum_saturday10_2025.presentation.contract.GoodsUiState

@Composable
fun GoodsScreenContent(
    state: GoodsUiState
) {
    Column {
        LazyColumn(
            modifier = Modifier.padding(8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(state.items) { item ->
                GoodsCard(item)
            }
        }
    }
}

@Composable
@Preview
private fun GoodsScreenPreview() {
    GoodsScreenContent(GoodsUiState())
}
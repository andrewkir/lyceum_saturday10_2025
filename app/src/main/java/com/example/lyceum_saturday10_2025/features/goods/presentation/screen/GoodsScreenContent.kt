package com.example.lyceum_saturday10_2025.features.goods.presentation.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.lyceum_saturday10_2025.features.goods.presentation.components.GoodsCard
import com.example.lyceum_saturday10_2025.features.goods.presentation.contract.GoodsUiState
import com.example.lyceum_saturday10_2025.features.goods.presentation.model.GoodsItem

@Composable
fun GoodsScreenContent(
    state: GoodsUiState,
    onAddClicked: (String, String) -> Unit,
    onGoodClicked: (GoodsItem) -> Unit,
) {
    Column {
        var nameTextFieldValue by remember { mutableStateOf("") }
        OutlinedTextField(
            value = nameTextFieldValue,
            onValueChange = { newValue ->
                nameTextFieldValue = newValue
            },
            placeholder = {
                Text("Введите название")
            }
        )

        Spacer(Modifier.height(16.dp))

        var descriptionTextFieldValue by remember { mutableStateOf("") }
        OutlinedTextField(
            value = descriptionTextFieldValue,
            onValueChange = { newValue ->
                descriptionTextFieldValue = newValue
            },
            placeholder = {
                Text("Введите описание")
            }
        )

        Spacer(Modifier.height(16.dp))

        Button(onClick = {
            onAddClicked(nameTextFieldValue, descriptionTextFieldValue)
        }) {
            Text("Добавить товар")
        }

        LazyColumn(
            modifier = Modifier.padding(8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(state.items) { item ->
                GoodsCard(item, onGoodClicked)
            }
        }
    }
}

@Composable
@Preview
private fun GoodsScreenPreview() {
    GoodsScreenContent(GoodsUiState(), { _, _ -> }, { _ -> })
}
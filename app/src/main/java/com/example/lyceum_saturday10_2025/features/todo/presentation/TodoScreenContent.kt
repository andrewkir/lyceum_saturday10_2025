package com.example.lyceum_saturday10_2025.features.todo.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
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
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.example.lyceum_saturday10_2025.features.todo.presentation.model.TodoItemUi
import com.example.lyceum_saturday10_2025.features.todo.presentation.model.TodoUiState

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun TodoScreenContent(
    state: TodoUiState,
    addItem: (String) -> Unit,
) {
    Column {
        var textFieldValue by remember { mutableStateOf("") }
        OutlinedTextField(
            modifier = Modifier.padding(8.dp),
            value = textFieldValue,
            onValueChange = { newValue ->
                textFieldValue = newValue
            },
            placeholder = {
                Text("Введите текст")
            }
        )

        Button(
            modifier = Modifier.padding(8.dp),
            onClick = {
                addItem(textFieldValue)
            }
        ) {
            Text("Добавить")
        }

        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(state.items) { item ->
                Card(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Row(
                        modifier = Modifier.padding(16.dp)
                    ) {
                        Text(
                            modifier = Modifier.padding(horizontal = 8.dp),
                            text = item.text
                        )
                    }
                }
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
private fun TodoScreenPreview() {
    TodoScreenContent(
        TodoUiState(
            listOf(
                TodoItemUi(
                    1, "Ivan"
                )
            )
        ),
        {}
    )
}
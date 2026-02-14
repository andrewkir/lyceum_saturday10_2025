package com.example.lyceum_saturday10_2025.features.github.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.lyceum_saturday10_2025.features.github.presentation.model.GithubUiState

@Composable
fun GithubScreenContent(
    state: GithubUiState
) {
    Column {
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(state.users) { user ->
                Text(
                    modifier = Modifier.padding(horizontal = 8.dp),
                    text = user
                )
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
private fun GithubScreenPreview() {
    GithubScreenContent(GithubUiState(listOf("Ivan", "Test")))
}
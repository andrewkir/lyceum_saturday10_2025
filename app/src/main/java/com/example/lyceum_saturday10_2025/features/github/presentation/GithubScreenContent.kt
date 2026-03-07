package com.example.lyceum_saturday10_2025.features.github.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.example.lyceum_saturday10_2025.features.github.presentation.model.GithubUiState
import com.example.lyceum_saturday10_2025.features.github.presentation.model.GithubUserUi

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun GithubScreenContent(
    state: GithubUiState
) {
    Column {
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(state.users) { user ->
                Card(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Row(
                        modifier = Modifier.padding(16.dp)
                    ) {
                        GlideImage(
                            modifier = Modifier
                                .clip(CircleShape)
                                .size(82.dp),
                            model = user.avatarUrl,
                            contentScale = ContentScale.FillHeight,
                            contentDescription = null,
                        )

                        Spacer(Modifier.width(16.dp))

                        Text(
                            modifier = Modifier.padding(horizontal = 8.dp),
                            text = user.login
                        )
                    }
                }
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
private fun GithubScreenPreview() {
    GithubScreenContent(
        GithubUiState(
            listOf(
                GithubUserUi(
                    1, "Ivan", ""
                )
            )
        )
    )
}
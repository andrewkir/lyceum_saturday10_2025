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
import com.example.lyceum_saturday10_2025.presentation.model.GoodsItem

val mockList = listOf(
    GoodsItem(
        name = "Курс по Kotlin",
        rating = 4,
        description = "test description",
        imageURL = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSibbxABu10t0qxQWHjH-QQFSWaCgd68RbztA&s"
    ),
    GoodsItem(
        name = "Курс по Java",
        rating = 5,
        description = "test description2",
        imageURL = "https://1000logos.net/wp-content/uploads/2020/09/Java-Logo.jpg"
    ),
    GoodsItem(
        name = "Курс по Python",
        rating = 2,
        description = "test description3",
        imageURL = "https://upload.wikimedia.org/wikipedia/commons/thumb/f/f8/Python_logo_and_wordmark.svg/2560px-Python_logo_and_wordmark.svg.png"
    )
)

@Composable
fun GoodsScreen() {
    Column {
        LazyColumn(
            modifier = Modifier.padding(8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(mockList) { item ->
                GoodsCard(item)
            }
        }
    }
}

@Composable
@Preview
private fun GoodsScreenPreview() {
    GoodsScreen()
}
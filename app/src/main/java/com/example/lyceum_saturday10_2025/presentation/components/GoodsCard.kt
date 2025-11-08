package com.example.lyceum_saturday10_2025.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.lyceum_saturday10_2025.R


@Composable
fun GoodsCard() {
    Card {
        Column {
            Image(
                painter = painterResource(R.drawable.kotlin),
                contentDescription = null
            )

            Row(
                modifier = Modifier.padding(16.dp)
            ) {
                Text("Курс по Kotlin")
            }

            Icon(
                imageVector = Icons.Default.Star,
                contentDescription = null,
                tint = Color.Yellow
            )
        }
    }
}

@Composable
@Preview
private fun GoodsCardPreview() {
    GoodsCard()
}


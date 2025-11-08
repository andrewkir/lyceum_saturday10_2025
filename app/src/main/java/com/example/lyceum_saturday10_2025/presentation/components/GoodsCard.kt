package com.example.lyceum_saturday10_2025.presentation.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.example.lyceum_saturday10_2025.presentation.model.GoodsItem


@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun GoodsCard(
    goodsItem: GoodsItem,
) {
    Card {
        Column {
            //Локальная картинка
//            Image(
//                modifier = Modifier.fillMaxWidth(),
//                painter = painterResource(R.drawable.kotlin),
//                contentDescription = null,
//                contentScale = ContentScale.Crop
//            )
            //Загрузка картинки из интернета
            GlideImage(
                model = goodsItem.imageURL,
                contentScale = ContentScale.FillWidth,
                contentDescription = null,
            )

            Row(
                modifier = Modifier.padding(16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(goodsItem.name)

                Spacer(Modifier.weight(1f))

                for (i in 0..4) {
                    Icon(
                        imageVector = Icons.Default.Star,
                        contentDescription = null,
                        tint = if (i < goodsItem.rating) Color.Yellow else Color.Gray
                    )
                }
            }
            Text(
                modifier = Modifier.padding(16.dp),
                text = goodsItem.description
            )
        }
    }
}

@Composable
@Preview
private fun GoodsCardPreview() {
    GoodsCard(
        goodsItem = GoodsItem(
            name = "Курс по Kotlin",
            rating = 4,
            description = "test description",
            imageURL = ""
        )
    )
}


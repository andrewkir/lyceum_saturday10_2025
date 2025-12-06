package com.example.lyceum_saturday10_2025.features.goodsdetails

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.lyceum_saturday10_2025.features.goods.presentation.model.GoodsItem
import com.ramcosta.composedestinations.annotation.Destination

@Composable
@Destination
//@Destination(style = DestinationStyle.Dialog::class)
fun GoodsDetails(goodsItem: GoodsItem) {
    Card {
        Column(
            modifier = Modifier.padding(32.dp)
        ) {
            Text(goodsItem.name)
            Text(goodsItem.description)
        }
    }
}
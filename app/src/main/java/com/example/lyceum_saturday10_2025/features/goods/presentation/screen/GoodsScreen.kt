package com.example.lyceum_saturday10_2025.features.goods.presentation.screen

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.lyceum_saturday10_2025.features.destinations.GoodsDetailsDestination
import com.example.lyceum_saturday10_2025.features.goods.presentation.GoodsViewModel
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@Composable
@Destination
fun GoodsScreen(
    navigator: DestinationsNavigator
) {
    val viewmodel = viewModel<GoodsViewModel>()
    val state by viewmodel.state.collectAsState()

    GoodsScreenContent(
        state = state,
//        onAddClicked = viewmodel::addGood
        onAddClicked = { name, description, imageUrl ->
            viewmodel.addGood(name, description, imageUrl)
        },
        onGoodClicked = { goodsItem ->
            navigator.navigate(GoodsDetailsDestination(goodsItem))
        },
        onDeleteClicked = { goodsItem ->
            viewmodel.deleteGood(goodsItem)
        }
    )
}
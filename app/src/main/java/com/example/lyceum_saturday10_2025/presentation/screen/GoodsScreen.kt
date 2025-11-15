package com.example.lyceum_saturday10_2025.presentation.screen

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.lyceum_saturday10_2025.presentation.GoodsViewModel

@Composable
fun GoodsScreen() {
    val viewmodel = viewModel<GoodsViewModel>()
    val state by viewmodel.state.collectAsState()

    GoodsScreenContent(
        state = state,
//        onAddClicked = viewmodel::addGood
        onAddClicked = { name, description ->
            viewmodel.addGood(name, description)
        }
    )
}
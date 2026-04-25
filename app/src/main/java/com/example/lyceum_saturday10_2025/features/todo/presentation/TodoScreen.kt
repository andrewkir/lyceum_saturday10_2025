package com.example.lyceum_saturday10_2025.features.todo.presentation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@Composable
@Destination(start = true)
fun TodoScreen(
    navigator: DestinationsNavigator
) {
    val viewmodel = viewModel<TodoViewModel>()
    val state by viewmodel.state.collectAsState()

    TodoScreenContent(state){ text ->
        viewmodel.addItem(text)
    }
}
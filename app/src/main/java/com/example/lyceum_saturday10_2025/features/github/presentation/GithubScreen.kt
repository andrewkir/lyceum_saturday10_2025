package com.example.lyceum_saturday10_2025.features.github.presentation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@Composable
@Destination(start = true)
fun GithubScreen(
    navigator: DestinationsNavigator
) {
    val viewmodel = viewModel<GithubViewModel>()
    val state by viewmodel.state.collectAsState()

    GithubScreenContent(state)
}
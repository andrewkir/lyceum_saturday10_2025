package com.example.lyceum_saturday10_2025.features.github.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.lyceum_saturday10_2025.features.github.data.GithubRepository
import com.example.lyceum_saturday10_2025.features.github.presentation.model.GithubUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class GithubViewModel : ViewModel() {

    val repository = GithubRepository()
    private val _state = MutableStateFlow(GithubUiState())
    val state: StateFlow<GithubUiState>
        get() = _state

    init {
        viewModelScope.launch {
            _state.emit(
                GithubUiState(
                    repository.getUsers().map { user -> user.login }
                )
            )
        }
    }
}
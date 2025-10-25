package com.example.lyceum_saturday10_2025.examples

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class ProfileViewModel : ViewModel() {

    val state = MutableStateFlow(ProfileUiState())

    init {
        viewModelScope.launch {
            delay(5000)
            state.value = ProfileUiState(
                name = "Ivan Petrov",
                lessons = listOf(
                    Lesson("Русский язык", "25.10"),
                    Lesson("Алгебра", "26.10")
                )
            )
        }
    }
}
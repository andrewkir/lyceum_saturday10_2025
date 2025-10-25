package com.example.lyceum_saturday10_2025.examples

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow

class ProfileViewModel: ViewModel() {

    val state = MutableStateFlow(ProfileUiState())


    val mockData = listOf(
        Lesson("Русский язык", "25.10"),
        Lesson("Алгебра", "26.10")
    )
}
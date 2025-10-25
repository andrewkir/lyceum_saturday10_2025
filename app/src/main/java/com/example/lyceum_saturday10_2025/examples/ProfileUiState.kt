package com.example.lyceum_saturday10_2025.examples

data class ProfileUiState(
    val name: String = "",
    val lessons: List<Lesson> = emptyList(),
)

data class Lesson(
    val name: String,
    val data: String,
)

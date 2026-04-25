package com.example.lyceum_saturday10_2025.features.todo.data.model

import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

@Serializable
data class TodoRequest(
    @SerializedName("text") val text: String,
)
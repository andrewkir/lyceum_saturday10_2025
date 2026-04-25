package com.example.lyceum_saturday10_2025.features.todo.data.model

import com.google.gson.annotations.SerializedName

data class TodoModel(
  @SerializedName("id")
  val id: Int,
  @SerializedName("text")
  val text: String,
)
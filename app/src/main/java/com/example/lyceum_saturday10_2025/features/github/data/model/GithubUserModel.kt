package com.example.lyceum_saturday10_2025.features.github.data.model

import com.google.gson.annotations.SerializedName

data class GithubUserModel(
  @SerializedName("id")
  val id: Int,
  @SerializedName("login")
  val login: String
)
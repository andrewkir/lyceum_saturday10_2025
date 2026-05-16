package com.example.lyceum_saturday10_2025.common.api

import com.google.gson.annotations.SerializedName

data class TokensResponse (
    @SerializedName("access_token")
    val access_token: String,
    @SerializedName("refresh_token")
    val refresh_token: String
)
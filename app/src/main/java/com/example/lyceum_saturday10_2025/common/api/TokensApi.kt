package com.example.lyceum_saturday10_2025.common.api

import retrofit2.http.Header
import retrofit2.http.POST

interface TokensApi {

    @POST("/refresh")
    suspend fun refreshAccessToken(
        @Header("Authorization") refresh_token: String
    ): TokensResponse
}
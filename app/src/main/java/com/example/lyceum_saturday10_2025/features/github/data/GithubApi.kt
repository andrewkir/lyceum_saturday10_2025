package com.example.lyceum_saturday10_2025.features.github.data

import com.example.lyceum_saturday10_2025.features.github.data.model.GithubUserModel
import retrofit2.http.GET

interface GithubApi {

    @GET("/users")
    suspend fun getUsers(): List<GithubUserModel>
}
package com.example.lyceum_saturday10_2025.features.github.data

import com.example.lyceum_saturday10_2025.features.github.data.model.GithubUserModel
import okhttp3.OkHttpClient.Builder
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class GithubRepository {
    val api by lazy {
        getRetrofit()
    }

    suspend fun getUsers(): List<GithubUserModel> {
        return api.getUsers()
    }

    private fun getRetrofit(): GithubApi {
        val httpClient = Builder()
        val logging = HttpLoggingInterceptor()
        logging.setLevel(HttpLoggingInterceptor.Level.BODY)
        httpClient.addInterceptor(logging)
        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.github.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(httpClient.build())
            .build()
        return retrofit.create(GithubApi::class.java)
    }
}
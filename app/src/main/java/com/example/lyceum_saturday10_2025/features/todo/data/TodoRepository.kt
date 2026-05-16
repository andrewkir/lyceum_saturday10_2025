package com.example.lyceum_saturday10_2025.features.todo.data

import android.content.Context
import com.example.lyceum_saturday10_2025.common.JWTAuthenticator
import com.example.lyceum_saturday10_2025.common.UserPrefsManager
import com.example.lyceum_saturday10_2025.common.api.TokensApi
import com.example.lyceum_saturday10_2025.features.todo.data.model.TodoModel
import com.example.lyceum_saturday10_2025.features.todo.data.model.TodoRequest
import okhttp3.OkHttpClient.Builder
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class TodoRepository(val applicationContext: Context) {
    val prefs = UserPrefsManager(applicationContext)

    val api by lazy {
        getRetrofit()
    }

    suspend fun getItems(): List<TodoModel> {
        try {
            return api.getItems()
        } catch (e: Exception) {
            e.printStackTrace()
            return emptyList()
        }
    }

    suspend fun addItem(text: String) {
        api.addItem(TodoRequest(text))
    }

    private fun getRetrofit(): TodoApi {
        val accessToken = prefs.accessToken

        val httpClient = Builder()
        val logging = HttpLoggingInterceptor()
        logging.setLevel(HttpLoggingInterceptor.Level.BODY)
        httpClient.addInterceptor(logging)
        httpClient.addInterceptor { chain ->
            chain.proceed(
                chain.request().newBuilder().also {
                    it.addHeader("Accept", "application/json")
                    if (accessToken != null) {
                        it.addHeader(
                            "Authorization",
                            "Bearer $accessToken"
                        )
                    }
                }.build()
            )
        }
            .also { client ->
                client.authenticator(
                    JWTAuthenticator(
                        context = applicationContext,
                        tokensApi = getTokensApi()
                    )
                )
            }.build()
        val retrofit = Retrofit.Builder()
            .baseUrl("http://10.0.2.2:8080")
            .addConverterFactory(GsonConverterFactory.create())
            .client(httpClient.build())
            .build()
        return retrofit.create(TodoApi::class.java)
    }

    private fun getTokensApi(): TokensApi {
        val httpClient = Builder()
        val logging = HttpLoggingInterceptor()
        logging.setLevel(HttpLoggingInterceptor.Level.BODY)
        httpClient.addInterceptor(logging)
        val retrofit = Retrofit.Builder()
            .baseUrl("http://10.0.2.2:8080")
            .addConverterFactory(GsonConverterFactory.create())
            .client(httpClient.build())
            .build()
        return retrofit.create(TokensApi::class.java)
    }
}
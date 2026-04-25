package com.example.lyceum_saturday10_2025.features.todo.data

import com.example.lyceum_saturday10_2025.features.todo.data.model.TodoModel
import com.example.lyceum_saturday10_2025.features.todo.data.model.TodoRequest
import okhttp3.OkHttpClient.Builder
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class TodoRepository {
    val api by lazy {
        getRetrofit()
    }

    suspend fun getItems(): List<TodoModel> {
        return api.getItems()
    }

    suspend fun addItem(text: String) {
        api.addItem(TodoRequest(text))
    }

    private fun getRetrofit(): TodoApi {
        val httpClient = Builder()
        val logging = HttpLoggingInterceptor()
        logging.setLevel(HttpLoggingInterceptor.Level.BODY)
        httpClient.addInterceptor(logging)
        val retrofit = Retrofit.Builder()
            .baseUrl("http://10.0.2.2:8080")
            .addConverterFactory(GsonConverterFactory.create())
            .client(httpClient.build())
            .build()
        return retrofit.create(TodoApi::class.java)
    }
}
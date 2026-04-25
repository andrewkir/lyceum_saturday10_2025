package com.example.lyceum_saturday10_2025.features.todo.data

import com.example.lyceum_saturday10_2025.features.todo.data.model.TodoModel
import com.example.lyceum_saturday10_2025.features.todo.data.model.TodoRequest
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface TodoApi {

    @GET("/items")
    suspend fun getItems(): List<TodoModel>

    @POST("/items/add")
    suspend fun addItem(@Body body: TodoRequest)
}
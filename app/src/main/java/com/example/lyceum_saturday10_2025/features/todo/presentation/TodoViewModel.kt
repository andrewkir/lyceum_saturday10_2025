package com.example.lyceum_saturday10_2025.features.todo.presentation

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.lyceum_saturday10_2025.features.todo.data.TodoRepository
import com.example.lyceum_saturday10_2025.features.todo.presentation.model.TodoItemUi
import com.example.lyceum_saturday10_2025.features.todo.presentation.model.TodoUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class TodoViewModel(application: Application) : AndroidViewModel(application) {

    val repository = TodoRepository(application.applicationContext)
    private val _state = MutableStateFlow(TodoUiState())
    val state: StateFlow<TodoUiState>
        get() = _state

    init {
        loadItems()
    }

    fun loadItems() {
        viewModelScope.launch {
            _state.emit(
                TodoUiState(
                    repository.getItems().map { item ->
                        TodoItemUi(
                            id = item.id,
                            text = item.text
                        )
                    }
                )
            )
        }
    }

    fun addItem(text: String) {
        viewModelScope.launch {
            repository.addItem(text)
            loadItems()
        }
    }
}
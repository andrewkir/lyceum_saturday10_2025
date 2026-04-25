package com.example.lyceum_saturday10_2025.features.todo.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.lyceum_saturday10_2025.features.todo.data.TodoRepository
import com.example.lyceum_saturday10_2025.features.todo.presentation.model.TodoItemUi
import com.example.lyceum_saturday10_2025.features.todo.presentation.model.TodoUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class TodoViewModel : ViewModel() {

    val repository = TodoRepository()
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
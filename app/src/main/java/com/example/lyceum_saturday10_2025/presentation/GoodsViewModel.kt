package com.example.lyceum_saturday10_2025.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.lyceum_saturday10_2025.presentation.contract.GoodsUiState
import com.example.lyceum_saturday10_2025.presentation.model.GoodsItem
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class GoodsViewModel : ViewModel() {

    private val _state = MutableStateFlow(GoodsUiState())
    val state: StateFlow<GoodsUiState>
        get() = _state

    init {
        viewModelScope.launch {
            delay(3000)
            _state.value = GoodsUiState(
                mockList
            )
        }
    }

    fun addGood(name: String, description: String) {
        val goodsList = state.value.items.toMutableList()
        goodsList.add(
            GoodsItem(
                name = name,
                rating = 5,
                description = description,
                imageURL = ""
            )
        )
        _state.value = GoodsUiState(goodsList)
    }


    companion object {

        val mockList = listOf(
            GoodsItem(
                name = "Курс по Kotlin",
                rating = 4,
                description = "test description",
                imageURL = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSibbxABu10t0qxQWHjH-QQFSWaCgd68RbztA&s"
            ),
            GoodsItem(
                name = "Курс по Java",
                rating = 5,
                description = "test description2",
                imageURL = "https://1000logos.net/wp-content/uploads/2020/09/Java-Logo.jpg"
            ),
            GoodsItem(
                name = "Курс по Python",
                rating = 2,
                description = "test description3",
                imageURL = "https://upload.wikimedia.org/wikipedia/commons/thumb/f/f8/Python_logo_and_wordmark.svg/2560px-Python_logo_and_wordmark.svg.png"
            )
        )
    }
}
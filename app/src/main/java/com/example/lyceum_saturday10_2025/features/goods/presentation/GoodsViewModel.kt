package com.example.lyceum_saturday10_2025.features.goods.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.lyceum_saturday10_2025.App
import com.example.lyceum_saturday10_2025.db.Good
import com.example.lyceum_saturday10_2025.features.goods.presentation.contract.GoodsUiState
import com.example.lyceum_saturday10_2025.features.goods.presentation.model.GoodsItem
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class GoodsViewModel : ViewModel() {

    val db = App.getDatabase()

    private val _state = MutableStateFlow(GoodsUiState())
    val state: StateFlow<GoodsUiState>
        get() = _state

    init {
        loadData()
    }

    fun loadData() {
        val goodsFromDb = db
            ?.goodsDao()
            ?.getAllGoods()
            ?.map { good ->
                GoodsItem(
                    id = good.id,
                    name = good.name,
                    rating = good.rating,
                    description = good.description,
                    imageURL = good.imageUrl
                )
            } ?: emptyList()

        viewModelScope.launch {
            _state.value = GoodsUiState(
                goodsFromDb
            )
        }
    }

    fun addGood(name: String, description: String, imageUrl: String) {
        db?.goodsDao()?.insert(
            Good(
                name = name,
                description = description,
                rating = 5,
                imageUrl = imageUrl,
            )
        )
        loadData()
    }

    fun deleteGood(goodsItem: GoodsItem) {
        db?.goodsDao()?.delete(goodsItem.id)
        loadData()
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
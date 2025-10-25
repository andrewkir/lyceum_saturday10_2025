package com.example.lyceum_saturday10_2025.examples.model

data class User(
    val name: String,
    val surname: String,
) {

    val fullName: String = "$name $surname"

    fun getInitials(): String {
        val firstInitial = if (name.isNotEmpty()) name[0] else ""
        val secondInitial = if (surname.isNotEmpty()) surname[0] else ""
        return "$firstInitial$secondInitial"
    }
}

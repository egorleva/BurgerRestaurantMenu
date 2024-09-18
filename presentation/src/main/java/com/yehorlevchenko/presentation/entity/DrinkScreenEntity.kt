package com.yehorlevchenko.presentation.entity

data class DrinkScreenEntity(
    val name: String,
    val description: String,
    val price: Double,
    val allergens: List<String>?,
    val imageUrl: String
)

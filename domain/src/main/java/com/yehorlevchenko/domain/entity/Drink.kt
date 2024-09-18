package com.yehorlevchenko.domain.entity

data class Drink(
    val name: String,
    val description: String,
    val price: Double,
    val allergens: List<String>?,
    val imageUrl: String
)

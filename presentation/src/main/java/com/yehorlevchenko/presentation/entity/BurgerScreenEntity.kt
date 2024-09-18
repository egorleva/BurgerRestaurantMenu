package com.yehorlevchenko.presentation.entity

data class BurgerScreenEntity(
    val name: String,
    val description: String,
    val weightGrams: Int?,
    val priceUsd: Double,
    val tags: List<String>?,
    val isAvailable: Boolean,
    val isVegetarian: Boolean,
    val allergensContainedIn: List<String>?,
    val imageUrl: String
)

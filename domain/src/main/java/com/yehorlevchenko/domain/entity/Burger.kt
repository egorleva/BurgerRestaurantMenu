package com.yehorlevchenko.domain.entity

data class Burger(
    val name: String,
    val description: String,
    val weightGrams: Int?,
    val priceUsd: Double,
    val tags: List<String>?,
    val isInStock: Boolean?,
    val isVegetarian: Boolean,
    val allergensContainedIn: List<String>?,
    val availableSince: Long?,
    val availableUntil: String?,
    val imageUrl: String
)

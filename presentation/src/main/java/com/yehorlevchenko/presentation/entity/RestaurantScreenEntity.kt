package com.yehorlevchenko.presentation.entity

data class RestaurantScreenEntity(
    val name: String,
    val street: String,
    val city: String,
    val countryName: String,
    val burgers: List<BurgerScreenEntity>,
    val drinks: List<DrinkScreenEntity>
)
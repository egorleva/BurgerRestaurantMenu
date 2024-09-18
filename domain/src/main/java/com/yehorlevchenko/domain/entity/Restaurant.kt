package com.yehorlevchenko.domain.entity

data class Restaurant(
    val name: String,
    val street: String,
    val city: String,
    val countryCode: String,
    val countryName: String,
    val burgers: List<Burger>,
    val drinks: List<Drink>
)
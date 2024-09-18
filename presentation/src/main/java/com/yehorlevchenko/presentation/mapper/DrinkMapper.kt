package com.yehorlevchenko.presentation.mapper

import com.yehorlevchenko.domain.entity.Drink
import com.yehorlevchenko.presentation.entity.DrinkScreenEntity

fun Drink.toDrinkScreenEntity() = DrinkScreenEntity(
    name = name,
    description = description,
    price = price,
    allergens = allergens,
    imageUrl = imageUrl
)
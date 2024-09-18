package com.yehorlevchenko.presentation.mapper

import com.yehorlevchenko.domain.entity.Burger
import com.yehorlevchenko.presentation.entity.BurgerScreenEntity

fun Burger.toBurgerScreenEntity(isAvailable: Boolean) = BurgerScreenEntity(
    name = name,
    description = description,
    weightGrams = weightGrams,
    priceUsd = priceUsd,
    tags = tags,
    isAvailable = isAvailable,
    isVegetarian = isVegetarian,
    allergensContainedIn = allergensContainedIn,
    imageUrl = imageUrl
)
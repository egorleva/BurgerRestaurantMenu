package com.yehorlevchenko.data.mapper

import com.yehorlevchenko.data.storage.local.entity.DrinkJsonEntity
import com.yehorlevchenko.data.storage.remote.entity.DrinkApiEntity
import com.yehorlevchenko.domain.entity.Drink

fun DrinkApiEntity.toDrink() = Drink(
    name = name,
    description = description,
    price = price,
    allergens = allergens,
    imageUrl = imageUrl
)

fun DrinkJsonEntity.toDrink() = Drink(
    name = name,
    description = description,
    price = price,
    allergens = allergens,
    imageUrl = imageUrl
)
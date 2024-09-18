package com.yehorlevchenko.data.mapper

import com.yehorlevchenko.data.storage.local.entity.BurgerJsonEntity
import com.yehorlevchenko.data.storage.remote.entity.BurgerApiEntity
import com.yehorlevchenko.domain.entity.Burger

fun BurgerApiEntity.toBurger() = Burger(
    name = name,
    description = description,
    weightGrams = weightGrams,
    priceUsd = priceUsd,
    tags = tags,
    isInStock = info.inStock,
    isVegetarian = info.isVegetarian,
    allergensContainedIn = info.allergensContainedIn,
    availableSince = info.availableSince,
    availableUntil = info.availableUntil,
    imageUrl = info.imageUrl
)

fun BurgerJsonEntity.toBurger() = Burger(
    name = name,
    description = description,
    weightGrams = weightGrams,
    priceUsd = priceUsd,
    tags = tags,
    isInStock = info.inStock,
    isVegetarian = info.isVegetarian,
    allergensContainedIn = info.allergensContainedIn,
    availableSince = info.availableSince,
    availableUntil = info.availableUntil,
    imageUrl = info.imageUrl
)
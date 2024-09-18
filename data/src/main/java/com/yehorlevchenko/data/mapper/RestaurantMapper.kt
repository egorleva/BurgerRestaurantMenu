package com.yehorlevchenko.data.mapper

import com.yehorlevchenko.data.storage.local.entity.RestaurantJsonEntity
import com.yehorlevchenko.data.storage.remote.entity.RestaurantApiEntity
import com.yehorlevchenko.domain.entity.Restaurant

fun RestaurantApiEntity.toRestaurant() = Restaurant(
    name = name,
    street = address.street,
    city = address.city,
    countryCode = address.country.code,
    countryName = address.country.name,
    burgers = burgers.map { it.toBurger() },
    drinks = drinks.map { it.toDrink() }
)

fun RestaurantJsonEntity.toRestaurant() = Restaurant(
    name = name,
    street = address.street,
    city = address.city,
    countryCode = address.country.code,
    countryName = address.country.name,
    burgers = burgers.map { it.toBurger() },
    drinks = drinks.map { it.toDrink() }
)
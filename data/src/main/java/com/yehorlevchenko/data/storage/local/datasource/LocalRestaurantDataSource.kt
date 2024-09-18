package com.yehorlevchenko.data.storage.local.datasource

import com.yehorlevchenko.data.storage.local.entity.RestaurantJsonEntity

interface LocalRestaurantDataSource {

    suspend fun getRestaurant(): RestaurantJsonEntity
}
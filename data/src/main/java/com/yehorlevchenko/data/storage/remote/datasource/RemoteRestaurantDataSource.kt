package com.yehorlevchenko.data.storage.remote.datasource

import com.yehorlevchenko.data.storage.remote.entity.RestaurantApiEntity

interface RemoteRestaurantDataSource {

    suspend fun getRestaurant(): RestaurantApiEntity
}
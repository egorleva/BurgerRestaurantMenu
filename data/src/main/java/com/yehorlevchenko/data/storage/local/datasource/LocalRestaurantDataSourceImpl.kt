package com.yehorlevchenko.data.storage.local.datasource

import android.app.Application
import com.google.gson.Gson
import com.yehorlevchenko.data.storage.local.entity.RestaurantJsonEntity
import javax.inject.Inject

class LocalRestaurantDataSourceImpl @Inject constructor(
    private val application: Application
) : LocalRestaurantDataSource {

    override suspend fun getRestaurant(): RestaurantJsonEntity {
        val inputStream = application.assets.open("restaurant.txt")
        val restaurantJson = inputStream.bufferedReader().use { it.readText() }

        return Gson().fromJson(restaurantJson, RestaurantJsonEntity::class.java)
    }
}
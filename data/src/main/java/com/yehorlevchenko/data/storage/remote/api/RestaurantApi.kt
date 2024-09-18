package com.yehorlevchenko.data.storage.remote.api

import com.yehorlevchenko.data.storage.remote.entity.RestaurantApiEntity
import retrofit2.http.GET

interface RestaurantApi {

    @GET("coding/restaurant.json")
    suspend fun getRestaurant(): RestaurantApiEntity
}
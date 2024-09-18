package com.yehorlevchenko.domain.repository

import com.yehorlevchenko.domain.entity.Restaurant
import com.yehorlevchenko.domain.utils.Result

interface RestaurantRepository {

    suspend fun getRestaurant(): Result<Restaurant>
}
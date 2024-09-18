package com.yehorlevchenko.domain.usecase

import com.yehorlevchenko.domain.entity.Restaurant
import com.yehorlevchenko.domain.utils.Result
import com.yehorlevchenko.domain.repository.RestaurantRepository

class GetRestaurantUseCase(private val restaurantRepository: RestaurantRepository) {

     suspend operator fun invoke(): Result<Restaurant> {
         return restaurantRepository.getRestaurant()
     }
}
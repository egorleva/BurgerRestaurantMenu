package com.yehorlevchenko.data.storage.remote.datasource

import com.yehorlevchenko.data.storage.remote.api.RestaurantApi
import com.yehorlevchenko.data.storage.remote.entity.RestaurantApiEntity
import javax.inject.Inject

class RemoteRestaurantDataSourceImpl @Inject constructor(
    private val api: RestaurantApi
) : RemoteRestaurantDataSource {

    override suspend fun getRestaurant(): RestaurantApiEntity {
        return api.getRestaurant()
    }
}
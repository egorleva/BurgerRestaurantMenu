package com.yehorlevchenko.data.repository

import com.yehorlevchenko.core.annotations.IoDispatcher
import com.yehorlevchenko.data.mapper.toRestaurant
import com.yehorlevchenko.data.storage.local.datasource.LocalRestaurantDataSource
import com.yehorlevchenko.data.storage.remote.datasource.RemoteRestaurantDataSource
import com.yehorlevchenko.domain.entity.Restaurant
import com.yehorlevchenko.domain.utils.Result
import com.yehorlevchenko.domain.repository.RestaurantRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject

class RestaurantRepositoryImpl @Inject constructor(
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher,
    private val remoteRestaurantDataSource: RemoteRestaurantDataSource,
    private val localRestaurantDataSource: LocalRestaurantDataSource
) : RestaurantRepository {

    override suspend fun getRestaurant(): Result<Restaurant> {
        return withContext(ioDispatcher) {
            runCatching {
                remoteRestaurantDataSource.getRestaurant().toRestaurant()
            }.recoverCatching {
                localRestaurantDataSource.getRestaurant().toRestaurant()
            }.fold(
                onSuccess = { Result.Success(it) },
                onFailure = { Result.Failure(it) }
            )
        }
    }
}
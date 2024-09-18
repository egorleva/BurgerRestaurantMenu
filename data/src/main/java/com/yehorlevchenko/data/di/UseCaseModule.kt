package com.yehorlevchenko.data.di

import com.yehorlevchenko.domain.repository.RestaurantRepository
import com.yehorlevchenko.domain.usecase.GetRestaurantUseCase
import com.yehorlevchenko.domain.usecase.IsBurgerAvailableUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    @Provides
    @Singleton
    fun provideGetRestaurantUseCase(
        restaurantRepository: RestaurantRepository
    ): GetRestaurantUseCase {
        return GetRestaurantUseCase(restaurantRepository)
    }

    @Provides
    @Singleton
    fun provideIsBurgerAvailableUseCase(): IsBurgerAvailableUseCase {
        return IsBurgerAvailableUseCase()
    }
}
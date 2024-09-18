package com.yehorlevchenko.data.di

import com.yehorlevchenko.data.storage.local.datasource.LocalRestaurantDataSource
import com.yehorlevchenko.data.storage.local.datasource.LocalRestaurantDataSourceImpl
import com.yehorlevchenko.data.storage.remote.datasource.RemoteRestaurantDataSource
import com.yehorlevchenko.data.storage.remote.datasource.RemoteRestaurantDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class DataSourceModule {

    @Binds
    @Singleton
    abstract fun bindRemoteRestaurantDataSource(
        remoteRestaurantDataSourceImpl: RemoteRestaurantDataSourceImpl
    ): RemoteRestaurantDataSource

    @Binds
    @Singleton
    abstract fun bindLocalRestaurantDataSource(
        localRestaurantDataSourceImpl: LocalRestaurantDataSourceImpl
    ): LocalRestaurantDataSource
}
package com.yehorlevchenko.presentation.ui.screen.details.drink

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yehorlevchenko.core.annotations.DefaultDispatcher
import com.yehorlevchenko.domain.entity.Burger
import com.yehorlevchenko.domain.entity.Restaurant
import com.yehorlevchenko.domain.usecase.GetRestaurantUseCase
import com.yehorlevchenko.domain.usecase.IsBurgerAvailableUseCase
import com.yehorlevchenko.domain.utils.Result
import com.yehorlevchenko.presentation.entity.RestaurantScreenEntity
import com.yehorlevchenko.presentation.mapper.toBurgerScreenEntity
import com.yehorlevchenko.presentation.mapper.toDrinkScreenEntity
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class DrinkDetailsViewModel @Inject constructor(
    private val getRestaurantUseCase: GetRestaurantUseCase,
    private val isBurgerAvailableUseCase: IsBurgerAvailableUseCase,
    @DefaultDispatcher private val defaultDispatcher: CoroutineDispatcher
) : ViewModel() {

    private val _uiState = MutableStateFlow<Result<RestaurantScreenEntity>>(Result.Empty)
    val uiState: StateFlow<Result<RestaurantScreenEntity>> = _uiState.asStateFlow()

    init {
        loadRestaurantData()
    }

    private fun loadRestaurantData() {
        viewModelScope.launch {
            _uiState.value = Result.Loading
            val result = getRestaurantUseCase()
            if (result is Result.Success) {
                _uiState.value = Result.Success(mapRestaurant(result.data))
            } else if (result is Result.Failure) {
                _uiState.value = Result.Failure(result.throwable)
            }
        }
    }

    private suspend fun mapRestaurant(restaurant: Restaurant) = RestaurantScreenEntity(
        name = restaurant.name,
        street = restaurant.street,
        city = restaurant.city,
        countryName = restaurant.countryName,
        burgers = restaurant.burgers.map { it.toBurgerScreenEntity(isBurgerAvailable(it)) },
        drinks = restaurant.drinks.map { it.toDrinkScreenEntity() }
    )

    private suspend fun isBurgerAvailable(burger: Burger): Boolean {
        return withContext(defaultDispatcher) { isBurgerAvailableUseCase(burger) }
    }
}
package com.yehorlevchenko.presentation.ui.screen.overview

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.yehorlevchenko.domain.utils.Result
import com.yehorlevchenko.presentation.entity.RestaurantScreenEntity
import com.yehorlevchenko.presentation.ui.component.list.BurgersList
import com.yehorlevchenko.presentation.ui.component.list.DrinksList
import com.yehorlevchenko.presentation.ui.component.loader.FullScreenLoader
import com.yehorlevchenko.presentation.ui.component.placeholder.FullScreenFailureLoadingPlaceholder
import com.yehorlevchenko.presentation.ui.component.placeholder.FullScreenNoDataPlaceholder
import com.yehorlevchenko.presentation.ui.theme.padding04
import com.yehorlevchenko.presentation.ui.theme.spacer01
import com.yehorlevchenko.presentation.ui.theme.spacer02
import com.yehorlevchenko.presentation.ui.theme.spacer03

@Composable
fun RestaurantOverviewScreen(
    navController: NavHostController,
    viewModel: RestaurantOverviewViewModel = hiltViewModel()
) {
    val uiState by viewModel.uiState.collectAsState()
    when (uiState) {
        is Result.Empty -> FullScreenNoDataPlaceholder()
        is Result.Loading -> FullScreenLoader()
        is Result.Failure -> FullScreenFailureLoadingPlaceholder()
        is Result.Success -> {
            val restaurant = (uiState as Result.Success<RestaurantScreenEntity>).data
            RestaurantOverview(navController, restaurant)
        }
    }
}

@Composable
fun RestaurantOverview(
    navController: NavHostController,
    restaurant: RestaurantScreenEntity
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White)
            .padding(padding04)
    ) {
        Spacer(modifier = Modifier.height(spacer02))
        Text(
            text = restaurant.name,
            style = MaterialTheme.typography.titleLarge
        )
        Spacer(modifier = Modifier.height(spacer01))
        Text(
            text = "${restaurant.street}, ${restaurant.city}, ${restaurant.countryName}",
            style = MaterialTheme.typography.bodyMedium
        )
        Spacer(modifier = Modifier.height(spacer03))
        BurgersList(burgers = restaurant.burgers, navController = navController, Modifier.weight(1f))
        Spacer(modifier = Modifier.height(spacer03))
        DrinksList(drinks = restaurant.drinks, navController = navController)
    }
}
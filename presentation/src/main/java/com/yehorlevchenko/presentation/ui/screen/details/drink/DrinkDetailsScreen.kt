package com.yehorlevchenko.presentation.ui.screen.details.drink

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorMatrix
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.yehorlevchenko.domain.utils.Result
import com.yehorlevchenko.presentation.R
import com.yehorlevchenko.presentation.entity.DrinkScreenEntity
import com.yehorlevchenko.presentation.entity.RestaurantScreenEntity
import com.yehorlevchenko.presentation.ui.component.body.Allergens
import com.yehorlevchenko.presentation.ui.component.body.DetailsImage
import com.yehorlevchenko.presentation.ui.component.header.CustomAppBar
import com.yehorlevchenko.presentation.ui.component.loader.FullScreenLoader
import com.yehorlevchenko.presentation.ui.component.placeholder.FullScreenFailureLoadingPlaceholder
import com.yehorlevchenko.presentation.ui.component.placeholder.FullScreenNoDataPlaceholder
import com.yehorlevchenko.presentation.ui.component.title.TitleWithValue
import com.yehorlevchenko.presentation.ui.theme.padding04
import com.yehorlevchenko.presentation.ui.theme.spacer02

@Composable
fun DrinkDetailsScreen(
    drinkName: String,
    navController: NavHostController,
    viewModel: DrinkDetailsViewModel = hiltViewModel()
) {
    val uiState by viewModel.uiState.collectAsState()
    when (uiState) {
        is Result.Empty -> FullScreenNoDataPlaceholder()
        is Result.Loading -> FullScreenLoader()
        is Result.Failure -> FullScreenFailureLoadingPlaceholder()
        is Result.Success -> {
            val restaurant = (uiState as Result.Success<RestaurantScreenEntity>).data
            DrinkData(drinkName, navController, restaurant)
        }
    }
}

@Composable
fun DrinkData(
    drinkName: String,
    navController: NavHostController,
    restaurant: RestaurantScreenEntity
) {
    restaurant.drinks
        .find { it.name == drinkName }
        ?.let { drink ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(color = Color.White)
            ) {
                CustomAppBar(
                    appBarTitle = drink.name,
                    backButtonTitle = restaurant.name,
                    navController = navController
                )
                HorizontalDivider(color = Color.LightGray)
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .verticalScroll(rememberScrollState())
                        .padding(padding04)
                ) {
                    DetailsImage(
                        imageUrl = drink.imageUrl,
                        contentDescription = stringResource(R.string.content_description_drink_image),
                        colorMatrix = ColorMatrix()
                    )
                    Spacer(modifier = Modifier.height(spacer02))
                    DrinkDetails(drink = drink)
                    Spacer(modifier = Modifier.height(spacer02))
                    HorizontalDivider(color = Color.LightGray)
                    Spacer(modifier = Modifier.height(spacer02))
                    Text(text = drink.description, style = MaterialTheme.typography.bodyMedium)
                    Spacer(modifier = Modifier.height(spacer02))
                    Allergens(allergens = drink.allergens)
                }
            }
        }
}

@Composable
fun DrinkDetails(drink: DrinkScreenEntity) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center
    ) {
        TitleWithValue(
            title = stringResource(R.string.title_price),
            value = stringResource(R.string.placeholder_price_usd, drink.price)
        )
    }
}
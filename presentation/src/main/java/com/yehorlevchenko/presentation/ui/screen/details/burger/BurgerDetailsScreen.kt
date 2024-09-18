package com.yehorlevchenko.presentation.ui.screen.details.burger

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
import com.yehorlevchenko.presentation.entity.BurgerScreenEntity
import com.yehorlevchenko.presentation.entity.RestaurantScreenEntity
import com.yehorlevchenko.presentation.ui.component.body.Allergens
import com.yehorlevchenko.presentation.ui.component.body.DetailsImage
import com.yehorlevchenko.presentation.ui.component.body.SpecialIngredients
import com.yehorlevchenko.presentation.ui.component.title.TitleWithValue
import com.yehorlevchenko.presentation.ui.component.header.CustomAppBar
import com.yehorlevchenko.presentation.ui.component.loader.FullScreenLoader
import com.yehorlevchenko.presentation.ui.component.placeholder.FullScreenFailureLoadingPlaceholder
import com.yehorlevchenko.presentation.ui.component.placeholder.FullScreenNoDataPlaceholder
import com.yehorlevchenko.presentation.ui.theme.padding04
import com.yehorlevchenko.presentation.ui.theme.spacer02

@Composable
fun BurgerDetailsScreen(
    burgerName: String,
    navController: NavHostController,
    viewModel: BurgerDetailsViewModel = hiltViewModel()
) {
    val uiState by viewModel.uiState.collectAsState()
    when (uiState) {
        is Result.Empty -> FullScreenNoDataPlaceholder()
        is Result.Loading -> FullScreenLoader()
        is Result.Failure -> FullScreenFailureLoadingPlaceholder()
        is Result.Success -> {
            val restaurant = (uiState as Result.Success<RestaurantScreenEntity>).data
            BurgerData(burgerName, navController, restaurant)
        }
    }
}

@Composable
fun BurgerData(
    burgerName: String,
    navController: NavHostController,
    restaurant: RestaurantScreenEntity
) {
    restaurant.burgers
        .find { it.name == burgerName }
        ?.let { burger ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(color = Color.White)
            ) {
                CustomAppBar(
                    appBarTitle = burger.name,
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
                        imageUrl = burger.imageUrl,
                        contentDescription = stringResource(R.string.content_description_burger_image),
                        colorMatrix = ColorMatrix().apply { if (!burger.isAvailable) setToSaturation(0f) }
                    )
                    Spacer(modifier = Modifier.height(spacer02))
                    BurgerDetails(burger = burger)
                    Spacer(modifier = Modifier.height(spacer02))
                    HorizontalDivider(color = Color.LightGray)
                    Spacer(modifier = Modifier.height(spacer02))
                    Text(text = burger.description, style = MaterialTheme.typography.bodyMedium)
                    Spacer(modifier = Modifier.height(spacer02))
                    SpecialIngredients(tags = burger.tags)
                    Spacer(modifier = Modifier.height(spacer02))
                    Allergens(allergens = burger.allergensContainedIn)
                }
            }
        }
}

@Composable
fun BurgerDetails(burger: BurgerScreenEntity) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        TitleWithValue(
            title = stringResource(R.string.title_price),
            value = stringResource(
                R.string.placeholder_price_usd,
                burger.priceUsd
            )
        )
        TitleWithValue(
            title = stringResource(R.string.title_weight),
            value = stringResource(
                R.string.placeholder_weight_grams,
                burger.weightGrams?.toString() ?: stringResource(R.string.label_absent)
            )
        )
        TitleWithValue(
            title = stringResource(R.string.title_vegetarian),
            value = stringResource(
                if (burger.isVegetarian) R.string.label_yes else R.string.label_no
            )
        )
    }
}
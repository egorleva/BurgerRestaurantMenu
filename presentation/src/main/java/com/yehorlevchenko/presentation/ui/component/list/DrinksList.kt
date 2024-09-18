package com.yehorlevchenko.presentation.ui.component.list

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import com.yehorlevchenko.presentation.R
import com.yehorlevchenko.presentation.entity.DrinkScreenEntity
import com.yehorlevchenko.presentation.ui.component.list.item.DrinkItem
import com.yehorlevchenko.presentation.ui.theme.spacer02

@Composable
fun DrinksList(drinks: List<DrinkScreenEntity>, navController: NavController) {
    Text(
        text = stringResource(R.string.title_drinks),
        style = MaterialTheme.typography.titleMedium
    )
    Spacer(modifier = Modifier.height(spacer02))
    LazyRow {
        itemsIndexed(drinks) { index, drink ->
            if (index != 0) Spacer(modifier = Modifier.width(spacer02))
            DrinkItem(drink = drink, navController = navController)
            if (index == drinks.lastIndex) Spacer(modifier = Modifier.width(spacer02))
        }
    }
}
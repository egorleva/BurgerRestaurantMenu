package com.yehorlevchenko.presentation.ui.component.list

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import com.yehorlevchenko.presentation.R
import com.yehorlevchenko.presentation.entity.BurgerScreenEntity
import com.yehorlevchenko.presentation.ui.component.list.item.BurgerItem
import com.yehorlevchenko.presentation.ui.theme.spacer02

@Composable
fun BurgersList(burgers: List<BurgerScreenEntity>, navController: NavController, modifier: Modifier) {
    Text(
        text = stringResource(R.string.title_burgers),
        style = MaterialTheme.typography.titleMedium
    )
    Spacer(modifier = Modifier.height(spacer02))
    LazyColumn(modifier = modifier) {
        items(burgers) {burger ->
            BurgerItem(burger = burger, navController = navController)
            Spacer(modifier = Modifier.height(spacer02))
        }
    }
}
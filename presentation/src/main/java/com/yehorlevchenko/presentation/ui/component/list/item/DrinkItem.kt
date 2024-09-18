package com.yehorlevchenko.presentation.ui.component.list.item

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import com.yehorlevchenko.presentation.R
import com.yehorlevchenko.presentation.entity.DrinkScreenEntity
import com.yehorlevchenko.presentation.ui.theme.cornerRadius01
import com.yehorlevchenko.presentation.ui.theme.drinkListItemImageSize
import com.yehorlevchenko.presentation.ui.theme.spacer01

@Composable
fun DrinkItem(drink: DrinkScreenEntity, navController: NavController) {
    Column(modifier = Modifier
        .width(drinkListItemImageSize)
        .wrapContentHeight()
        .clickable { navController.navigate("details/drink/${drink.name}") }
    ) {
        Image(
            painter = rememberAsyncImagePainter(drink.imageUrl),
            contentDescription = stringResource(R.string.content_description_drink_image),
            modifier = Modifier
                .size(drinkListItemImageSize)
                .clip(RoundedCornerShape(cornerRadius01)),
            contentScale = ContentScale.Crop
        )
        Spacer(modifier = Modifier.height(spacer01))
        Text(
            text = drink.name,
            style = MaterialTheme.typography.bodySmall
        )
    }
}
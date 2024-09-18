package com.yehorlevchenko.presentation.ui.component.list.item

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.ColorMatrix
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextDecoration
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import com.yehorlevchenko.presentation.R
import com.yehorlevchenko.presentation.entity.BurgerScreenEntity
import com.yehorlevchenko.presentation.ui.theme.BlueLight
import com.yehorlevchenko.presentation.ui.theme.burgerListItemBottomHeight
import com.yehorlevchenko.presentation.ui.theme.burgerListItemImageHeight
import com.yehorlevchenko.presentation.ui.theme.cornerRadius02
import com.yehorlevchenko.presentation.ui.theme.cornerRadius01
import com.yehorlevchenko.presentation.ui.theme.elevation01
import com.yehorlevchenko.presentation.ui.theme.padding01
import com.yehorlevchenko.presentation.ui.theme.padding02
import com.yehorlevchenko.presentation.ui.theme.padding03

@Composable
fun BurgerItem(burger: BurgerScreenEntity, navController: NavController) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { navController.navigate("details/burger/${burger.name}") },
        shape = RoundedCornerShape(corner = CornerSize(cornerRadius01)),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = elevation01)
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            BurgerItemTop(burger = burger)
            BurgerItemBottom(burger = burger)
        }
    }
}

@Composable
fun BurgerItemTop(burger: BurgerScreenEntity) {
    val isAvailable = burger.isAvailable
    val colorMatrix = ColorMatrix().apply { if (!burger.isAvailable) setToSaturation(0f) }
    Box(modifier = Modifier.fillMaxWidth()) {
        Image(
            painter = rememberAsyncImagePainter(burger.imageUrl),
            contentDescription = stringResource(R.string.content_description_burger_image),
            modifier = Modifier.fillMaxWidth().height(burgerListItemImageHeight),
            contentScale = ContentScale.Crop,
            colorFilter = ColorFilter.colorMatrix(colorMatrix)
        )
        BurgerItemLabel(
            modifier = Modifier.align(if (isAvailable) Alignment.BottomEnd else Alignment.Center),
            labelColor = if (isAvailable) BlueLight else Color.LightGray,
            labelTextColor = if (isAvailable) Color.White else Color.Black,
            labelText = if (isAvailable) stringResource(R.string.placeholder_price_usd, burger.priceUsd.toString())
            else stringResource(R.string.label_currently_not_available)
        )
    }
}

@Composable
fun BurgerItemBottom(burger: BurgerScreenEntity) {
    val textDecoration = if (burger.isAvailable) TextDecoration.None else TextDecoration.LineThrough
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(burgerListItemBottomHeight)
            .padding(horizontal = padding02),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = burger.name,
            style = MaterialTheme.typography.titleSmall,
            textDecoration = textDecoration
        )
        Text(
            text = stringResource(
                R.string.placeholder_weight_grams,
                burger.weightGrams?.toString() ?: stringResource(R.string.label_absent)
            ),
            style = MaterialTheme.typography.bodySmall,
            textDecoration = textDecoration,
            color = Color.Gray
        )
    }
}

@Composable
fun BurgerItemLabel(
    modifier: Modifier,
    labelColor: Color,
    labelTextColor: Color,
    labelText: String
) {
    Surface(
        modifier = modifier
            .wrapContentSize()
            .padding(padding02)
            .clip(RoundedCornerShape(cornerRadius02)),
        color = labelColor
    ) {
        Text(
            text = labelText,
            style = MaterialTheme.typography.bodySmall,
            color = labelTextColor,
            modifier = Modifier
                .wrapContentSize()
                .padding(horizontal = padding03, vertical = padding01)
        )
    }
}
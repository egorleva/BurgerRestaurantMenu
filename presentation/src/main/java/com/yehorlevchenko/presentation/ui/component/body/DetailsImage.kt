package com.yehorlevchenko.presentation.ui.component.body

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.ColorMatrix
import androidx.compose.ui.layout.ContentScale
import coil.compose.rememberAsyncImagePainter
import com.yehorlevchenko.presentation.ui.theme.cornerRadius01
import com.yehorlevchenko.presentation.ui.theme.detailsImageHeight

@Composable
fun DetailsImage(
    imageUrl: String,
    contentDescription: String,
    colorMatrix: ColorMatrix
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(CornerSize(cornerRadius01)),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        Image(
            painter = rememberAsyncImagePainter(imageUrl),
            contentDescription = contentDescription,
            modifier = Modifier.fillMaxWidth().height(detailsImageHeight),
            contentScale = ContentScale.Crop,
            colorFilter = ColorFilter.colorMatrix(colorMatrix)
        )
    }
}
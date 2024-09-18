package com.yehorlevchenko.presentation.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight

val Typography = Typography(
    bodySmall = TextStyle(
        fontSize = fontSize01
    ),
    bodyMedium = TextStyle(
        fontSize = fontSize02
    ),
    bodyLarge = TextStyle(
        fontSize = fontSize04,
        fontWeight = FontWeight.Bold
    ),
    titleSmall = TextStyle(
        fontWeight = FontWeight.Bold,
        fontSize = fontSize03
    ),
    titleMedium = TextStyle(
        fontWeight = FontWeight.Bold,
        fontSize = fontSize04
    ),
    titleLarge = TextStyle(
        fontWeight = FontWeight.Bold,
        fontSize = fontSize05
    ),
    labelSmall = TextStyle(
        fontWeight = FontWeight.Medium,
        fontSize = fontSize01,
        color = Color.LightGray
    )
)
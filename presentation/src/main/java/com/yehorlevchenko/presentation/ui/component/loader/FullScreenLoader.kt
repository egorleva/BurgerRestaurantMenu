package com.yehorlevchenko.presentation.ui.component.loader

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.yehorlevchenko.presentation.ui.theme.BlueLight
import com.yehorlevchenko.presentation.ui.theme.strokeWidth01

@Composable
fun FullScreenLoader() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        CircularProgressIndicator(
            color = BlueLight,
            strokeWidth = strokeWidth01
        )
    }
}
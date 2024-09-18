package com.yehorlevchenko.presentation.ui.component.title

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.yehorlevchenko.presentation.ui.theme.spacer01

@Composable
fun TitleWithValue(title: String, value: String) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = value, style = MaterialTheme.typography.bodyLarge)
        Spacer(modifier = Modifier.height(spacer01))
        Text(text = title, style = MaterialTheme.typography.labelSmall)
    }
}
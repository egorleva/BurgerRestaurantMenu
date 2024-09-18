package com.yehorlevchenko.presentation.ui.component.placeholder

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.yehorlevchenko.presentation.R

@Composable
fun FullScreenNoDataPlaceholder() {
    Box(modifier = Modifier.fillMaxSize()) {
        Text(
            modifier = Modifier.align(Alignment.Center),
            text = stringResource(id = R.string.placeholder_no_data_loaded),
            style = MaterialTheme.typography.bodyLarge
        )
    }
}
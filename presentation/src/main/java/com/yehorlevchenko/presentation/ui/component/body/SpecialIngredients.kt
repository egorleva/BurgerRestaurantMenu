package com.yehorlevchenko.presentation.ui.component.body

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.yehorlevchenko.presentation.R
import com.yehorlevchenko.presentation.ui.theme.spacer01

@Composable
fun SpecialIngredients(tags: List<String>?) {
    if (tags?.isNotEmpty() == true) {
        Text(
            text = stringResource(R.string.title_special_ingredients),
            style = MaterialTheme.typography.labelSmall
        )
        Spacer(modifier = Modifier.height(spacer01))
        Text(
            text = tags.joinToString(", "),
            style = MaterialTheme.typography.bodyMedium
        )
    }
}
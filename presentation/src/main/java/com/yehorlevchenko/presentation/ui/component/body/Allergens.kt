package com.yehorlevchenko.presentation.ui.component.body

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.yehorlevchenko.presentation.R
import com.yehorlevchenko.presentation.ui.theme.YellowLemon
import com.yehorlevchenko.presentation.ui.theme.cornerRadius01
import com.yehorlevchenko.presentation.ui.theme.padding02
import com.yehorlevchenko.presentation.ui.theme.spacer01

@Composable
fun Allergens(allergens: List<String>?) {
    if (allergens?.isNotEmpty() == true) {
        Text(
            text = stringResource(R.string.title_allergens),
            style = MaterialTheme.typography.labelSmall
        )
        Spacer(modifier = Modifier.height(spacer01))
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(YellowLemon, RoundedCornerShape(cornerRadius01))
                .padding(padding02)
        ) {
            Text(
                text = allergens.joinToString(", "),
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }
}
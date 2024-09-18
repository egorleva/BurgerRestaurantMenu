package com.yehorlevchenko.presentation.ui.component.header

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.navigation.NavHostController
import com.yehorlevchenko.presentation.R
import com.yehorlevchenko.presentation.ui.theme.BlueLight
import com.yehorlevchenko.presentation.ui.theme.customAppBarHeightHeight
import com.yehorlevchenko.presentation.ui.theme.padding02

@Composable
fun CustomAppBar(
    appBarTitle: String,
    backButtonTitle: String,
    navController: NavHostController
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(customAppBarHeightHeight),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row(
            modifier = Modifier.weight(1f),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = Icons.AutoMirrored.Default.KeyboardArrowLeft,
                contentDescription = stringResource(R.string.content_description_back_arrow_image),
                tint = BlueLight
            )
            Text(
                modifier = Modifier.clickable { navController.popBackStack() },
                text = backButtonTitle,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                color = BlueLight,
                style = MaterialTheme.typography.titleSmall
            )
        }
        Text(
            modifier = Modifier
                .weight(1f)
                .padding(horizontal = padding02),
            text = appBarTitle,
            style = MaterialTheme.typography.titleSmall,
            textAlign = TextAlign.Center,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )
        Spacer(modifier = Modifier.weight(1f))
    }
}
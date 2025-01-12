package com.brandoncano.ohmslawcalculator.ui.screens.about

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Apps
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.Grade
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.brandoncano.ohmslawcalculator.R
import com.brandoncano.ohmslawcalculator.ui.theme.OhmsLawCalculatorTheme
import com.brandoncano.sharedcomponents.composables.AppArrowCardButton
import com.brandoncano.sharedcomponents.composables.AppComponentPreviews
import com.brandoncano.sharedcomponents.data.ArrowCardButtonContents
import com.brandoncano.sharedcomponents.text.textStyleHeadline

@Composable
fun OurAppsButtons(
    onRateThisAppTapped: () -> Unit,
    onViewOurAppsTapped: () -> Unit,
    onDonateTapped: () -> Unit,
) {
    Column {
        Text(
            text = stringResource(id = R.string.about_our_apps_header_text),
            modifier = Modifier.align(Alignment.Start),
            style = textStyleHeadline(),
        )
        Spacer(modifier = Modifier.height(12.dp))
        AppArrowCardButton(
            ArrowCardButtonContents(
                imageVector = Icons.Outlined.Grade,
                text = stringResource(id = R.string.nav_rate_us),
                onClick = onRateThisAppTapped,
            ),
            ArrowCardButtonContents(
                imageVector = Icons.Outlined.Apps,
                text = stringResource(id = R.string.nav_view_apps),
                onClick = onViewOurAppsTapped,
            ),
            ArrowCardButtonContents(
                imageVector = Icons.Outlined.FavoriteBorder,
                text = stringResource(R.string.nav_donate),
                onClick = onDonateTapped,
            ),
        )
    }
}

@AppComponentPreviews
@Composable
private fun OurAppsButtonsPreview() {
    OhmsLawCalculatorTheme {
        Surface {
            OurAppsButtons(
                onRateThisAppTapped = {},
                onViewOurAppsTapped = {},
                onDonateTapped = {},
            )
        }
    }
}

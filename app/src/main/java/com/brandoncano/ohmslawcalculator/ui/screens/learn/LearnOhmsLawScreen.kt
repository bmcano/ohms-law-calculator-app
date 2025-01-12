package com.brandoncano.ohmslawcalculator.ui.screens.learn

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.brandoncano.ohmslawcalculator.R
import com.brandoncano.ohmslawcalculator.ui.theme.OhmsLawCalculatorTheme
import com.brandoncano.sharedcomponents.composables.AppScreenPreviews
import com.brandoncano.sharedcomponents.composables.AppTopAppBar
import com.brandoncano.sharedcomponents.text.onSurfaceVariant
import com.brandoncano.sharedcomponents.text.textStyleBody
import com.brandoncano.sharedcomponents.text.textStyleTitle

@Composable
fun LearnOhmsLawScreen(
    onNavigateBack: () -> Unit,
) {
    Scaffold(
        topBar = {
            AppTopAppBar(
                titleText = stringResource(R.string.learn_title),
                navigationIcon =  Icons.Filled.Close,
                onNavigateBack = onNavigateBack,
            )
        },
    ) { paddingValues ->
        LearnOhmsLawScreenContent(paddingValues)
    }
}

@Composable
private fun LearnOhmsLawScreenContent(paddingValues: PaddingValues) {
    val sidePadding = dimensionResource(R.dimen.app_side_padding)
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(paddingValues)
            .padding(horizontal = sidePadding),
        horizontalAlignment = Alignment.Start,
    ) {
        Text(
            text = stringResource(R.string.learn_introduction),
            modifier = Modifier.padding(vertical = 12.dp),
            style = textStyleTitle(),
        )
        Text(
            text = stringResource(R.string.learn_intro_body),
            modifier = Modifier.padding(bottom = 32.dp),
            style = textStyleBody().onSurfaceVariant(),
        )
        Text(
            text = stringResource(R.string.learn_ohms_law_circle),
            modifier = Modifier.padding(vertical = 12.dp),
            style = textStyleTitle(),
        )
        Text(
            text = stringResource(R.string.learn_ohms_law_circle_description),
            modifier = Modifier.padding(bottom = 32.dp),
            style = textStyleBody().onSurfaceVariant(),
        )
        Image(
            painter = painterResource(R.drawable.img_ohms_law_circle),
            contentDescription = null,
            modifier = Modifier.align(Alignment.CenterHorizontally),
            alignment = Alignment.Center,
        )
        Spacer(modifier = Modifier.height(48.dp))
    }
}

@AppScreenPreviews
@Composable
private fun LearnOhmsLawPreview() {
    OhmsLawCalculatorTheme {
        LearnOhmsLawScreen {}
    }
}

package com.example.abcall.share.components

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import com.example.abcall.R

@Composable
fun progressIndicatorComp() {
    CircularProgressIndicator(
        modifier = Modifier
            .width(dimensionResource(R.dimen.radius_progress_indicator))
            .padding(vertical = dimensionResource(R.dimen.sm_vertical_padding)),
        color = MaterialTheme.colorScheme.primary
    )
}
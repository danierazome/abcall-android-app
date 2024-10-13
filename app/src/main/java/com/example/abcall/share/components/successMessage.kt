package com.example.abcall.share.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import com.example.abcall.R

@Composable
fun successMessageComp(message: String) {

    ElevatedCard (
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.tertiaryContainer,
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = dimensionResource(R.dimen.card_elevation)
        ),
        modifier = Modifier
            .padding(
                horizontal = dimensionResource(R.dimen.l_horizontal_padding),
                vertical = dimensionResource(R.dimen.m_vertical_padding))
    ){
        Text(
            text = message,
            modifier = Modifier
                .padding(
                    vertical = dimensionResource(R.dimen.m_vertical_padding),
                    horizontal = dimensionResource(R.dimen.m_horizontal_padding)
                )
        )
    }
}
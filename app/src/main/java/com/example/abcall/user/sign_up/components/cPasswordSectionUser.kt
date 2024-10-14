package com.example.abcall.user.sign_up.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import com.example.abcall.R
import com.example.abcall.user.sign_up.view_model.SignUpUserViewModel

@Composable
fun cPasswordSectionUser(viewModel: SignUpUserViewModel) {
    Column (
        modifier = Modifier.padding(vertical = dimensionResource(R.dimen.sm_vertical_padding))){
        TextField(
            isError = !viewModel.cPasswordIsValid,
            value = viewModel.cPassword,
            onValueChange = {viewModel.updateCPassword(it)},
            label = { Text(stringResource(R.string.password)) }
        )
        if (!viewModel.cPasswordIsValid) {
            Text(
                text = stringResource(R.string.password_match),
                style = MaterialTheme.typography.labelMedium,
                color = MaterialTheme.colorScheme.errorContainer)
        }

    }

}
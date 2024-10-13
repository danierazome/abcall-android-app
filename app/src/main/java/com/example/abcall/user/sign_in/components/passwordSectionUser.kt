package com.example.abcall.user.sign_in.components

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
import com.example.abcall.user.sign_in.view_model.SignInUserViewModel

@Composable
fun passwordSectionUser(viewModel: SignInUserViewModel) {
    Column (
        modifier = Modifier.padding(vertical = dimensionResource(R.dimen.sm_vertical_padding))){
        TextField(
            isError = !viewModel.passwordIsValid.result,
            value = viewModel.password,
            onValueChange = {viewModel.updatePassword(it)},
            label = { Text(stringResource(R.string.password)) }
        )
        if (!viewModel.passwordIsValid.result) {
            Text(
                text = stringResource(viewModel.passwordIsValid.message),
                style = MaterialTheme.typography.labelMedium,
                color = MaterialTheme.colorScheme.errorContainer)
        }

    }

}
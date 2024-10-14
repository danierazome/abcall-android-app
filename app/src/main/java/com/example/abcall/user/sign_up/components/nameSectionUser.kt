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
fun nameSectionUser(viewModel: SignUpUserViewModel) {
    Column (
        modifier = Modifier.padding(vertical = dimensionResource(R.dimen.sm_vertical_padding))){
        TextField(
            isError = !viewModel.nameIsValid.result,
            value = viewModel.name,
            onValueChange = {viewModel.updateName(it)},
            label = { Text(stringResource(R.string.user_name)) }
        )
        if (!viewModel.nameIsValid.result) {
            Text(
                text = stringResource(viewModel.nameIsValid.message),
                style = MaterialTheme.typography.labelMedium,
                color = MaterialTheme.colorScheme.errorContainer)
        }
    }
}
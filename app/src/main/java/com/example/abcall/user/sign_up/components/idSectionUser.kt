package com.example.abcall.user.sign_up.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import com.example.abcall.R
import com.example.abcall.user.sign_up.view_model.SignUpUserViewModel

@Composable
fun idSectionUser(viewModel: SignUpUserViewModel) {
    Column (
        modifier = Modifier.padding(vertical = dimensionResource(R.dimen.sm_vertical_padding))){
        TextField(
            isError = !viewModel.idIsValid.result,
            value = viewModel.id,
            onValueChange = {viewModel.updateId(it)},
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number),
            label = { Text(stringResource(R.string.user_id)) }
        )
        if (!viewModel.idIsValid.result) {
            Text(
                text = stringResource(viewModel.idIsValid.message),
                style = MaterialTheme.typography.labelMedium,
                color = MaterialTheme.colorScheme.errorContainer)
        }
    }
}
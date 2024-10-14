package com.example.abcall.user.sign_up.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import com.example.abcall.R
import com.example.abcall.share.components.errorMessageComp
import com.example.abcall.share.components.progressIndicatorComp
import com.example.abcall.share.components.successMessageComp
import com.example.abcall.user.sign_up.types.SignUpUserState
import com.example.abcall.user.sign_up.view_model.SignUpUserViewModel

@Composable
fun formSignUpUser(
    modifier: Modifier = Modifier,
    viewModel: SignUpUserViewModel
) {
    val state = viewModel.state
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .verticalScroll(rememberScrollState())
    ) {

        when(state) {
            is SignUpUserState.Error -> state.error?.let { errorMessageComp(it.message) }
            else -> Unit
        }

        when(state) {
            is SignUpUserState.Success -> state.response?.let { successMessageComp(it.message) }
            else -> Unit
        }

        nameSectionUser(viewModel = viewModel)
        emailSectionUserR(viewModel = viewModel)
        idSectionUser(viewModel = viewModel)
        passwordSectionUserR(viewModel = viewModel)
        cPasswordSectionUser(viewModel = viewModel)
        clientIdSectionUser(viewModel = viewModel)

        when (state) {
            is SignUpUserState.Loading -> progressIndicatorComp()
            else -> Button(
                enabled = viewModel.formIsValid,
                shape = CircleShape,
                onClick =
                {
                    viewModel.signUp()
                },
                modifier = modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(vertical = dimensionResource(R.dimen.sm_vertical_padding))
            ) {
                Text(text = stringResource(R.string.sign_up))
            }
        }
    }
}
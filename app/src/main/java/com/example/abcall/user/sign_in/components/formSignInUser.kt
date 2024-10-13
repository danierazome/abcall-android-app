package com.example.abcall.user.sign_in.components

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
import com.example.abcall.user.sign_in.types.SignInUserState
import com.example.abcall.user.sign_in.view_model.SignInUserViewModel

@Composable
fun FormSignInUser(
    modifier: Modifier = Modifier,
    navigateTo: (String) -> Unit,
    viewModel: SignInUserViewModel
) {
    val state = viewModel.state
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .verticalScroll(rememberScrollState())
    ) {

        when(state) {
            is SignInUserState.Error -> state.error?.let { errorMessageComp(it.message) }
            else -> Unit
        }

        when(state) {
            is SignInUserState.Success -> state.response?.let { successMessageComp(it.message) }
            else -> Unit
        }

        emailSectionUser(viewModel = viewModel)
        passwordSectionUser(viewModel = viewModel)

        when (state) {
            is SignInUserState.Loading -> progressIndicatorComp()
            else -> Button(
                enabled = viewModel.formIsValid,
                shape = CircleShape,
                onClick =
                {
                    viewModel.signIn()
                },
                modifier = modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(vertical = dimensionResource(R.dimen.sm_vertical_padding))
            ) {
                Text(text = stringResource(R.string.sign_in))
            }
        }
    }
}








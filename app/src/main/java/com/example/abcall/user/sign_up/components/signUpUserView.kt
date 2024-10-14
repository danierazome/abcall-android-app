package com.example.abcall.user.sign_up.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.abcall.R
import com.example.abcall.user.sign_up.view_model.SignUpUserViewModel

@Composable
fun signUpUser(
    modifier: Modifier = Modifier,
    navigateUp: () -> Unit,
    navigateTo: (String) -> Unit) {

    val viewModel: SignUpUserViewModel = viewModel(factory = SignUpUserViewModel.factory)

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {

        formSignUpUser(viewModel = viewModel)

        Button(
            shape = CircleShape,
            onClick =
            {
                navigateUp()
            },
            modifier = modifier
                .align(Alignment.CenterHorizontally)
                .padding(vertical = dimensionResource(R.dimen.sm_vertical_padding))
        ) {
            Icon(
                imageVector = Icons.Filled.ArrowBack,
                contentDescription = "Go back to select user type"
            )
        }
    }
}
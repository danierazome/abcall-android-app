package com.example.abcall.user.sign_in.components

import androidx.compose.foundation.Image
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
import androidx.compose.ui.res.painterResource
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.abcall.R
import com.example.abcall.user.sign_in.view_model.SignInUserViewModel

@Composable
fun SignInUser(
    modifier: Modifier = Modifier,
    navigateUp: () -> Unit,
    navigateTo: (String) -> Unit) {

    val viewModel: SignInUserViewModel = viewModel(factory = SignInUserViewModel.factory)

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {

        Image(
            painter = painterResource(R.drawable.user_sign_in_logo),
            contentDescription = "Login user logo",
            modifier = Modifier.padding(vertical = dimensionResource(R.dimen.l_vertical_padding))
        )

        FormSignInUser(navigateTo = navigateTo, viewModel = viewModel)

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
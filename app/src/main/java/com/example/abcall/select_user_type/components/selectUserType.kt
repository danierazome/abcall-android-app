package com.example.abcall.select_user_type.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import com.example.abcall.R
import com.example.abcall.share.theme.teamThemeKey
import com.example.abcall.team.config.TeamScreens
import com.example.abcall.user.config.UserScreens

@Composable
fun SelectUserType(
    modifier: Modifier = Modifier,
    navigateTo: (String) -> Unit = {},
    changeTheme: (Int) -> Unit
) {

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = stringResource(id = R.string.continue_as),
            fontWeight = FontWeight.Bold,
            style = MaterialTheme.typography.titleLarge,
            color = Color.White,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(vertical = dimensionResource(R.dimen.l_horizontal_padding))
        )

        ButtonsSection(navigateTo = navigateTo, changeTheme = changeTheme)

        Image(
            painter = painterResource(R.drawable.full_logo_abcall),
            contentDescription = "Company logo",
            modifier = Modifier.padding(horizontal = dimensionResource(R.dimen.l_vertical_padding))
        )
    }
}


@Composable
fun ButtonsSection(
    modifier: Modifier = Modifier,
    navigateTo: (String) -> Unit,
    changeTheme: (Int) -> Unit) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {

        Button(
            onClick =
            {
                navigateTo(TeamScreens.SignIn.route)
                changeTheme(teamThemeKey)
            },
            modifier = modifier
                .align(Alignment.CenterHorizontally)
                .padding(vertical = dimensionResource(R.dimen.sm_vertical_padding)),
            colors = ButtonDefaults.buttonColors(
                containerColor = colorResource(id = R.color.team_primary_color)
            )
        ) {
            Text(stringResource(id = R.string.team))
        }
        Button(
            onClick =
            {
                navigateTo(UserScreens.SignIn.route)
            },
            modifier = modifier
                .align(Alignment.CenterHorizontally)
                .padding(vertical = dimensionResource(R.dimen.sm_vertical_padding))
        ) {
            Text(stringResource(id = R.string.user))
        }
    }
}
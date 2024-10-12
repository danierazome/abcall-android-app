package com.example.abcall

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.abcall.user.config.UserScreens
import com.example.abcall.select_user_type.components.SelectUserType
import com.example.abcall.select_user_type.config.UserTypeScreens
import com.example.abcall.user.sign_in.components.SignInUser

@Composable
fun IndexApp(
    navController: NavHostController = rememberNavController(),
    changeTheme: (Int) -> Unit) {

    NavHost(
        navController = navController,
        startDestination = UserTypeScreens.SelectUserType.name
    ) {
        composable(route = UserTypeScreens.SelectUserType.name) {
            SelectUserType(
                navigateTo = {
                    navController.navigate(it)
                },
                changeTheme = changeTheme
            )
        }

        composable(route = UserScreens.SignIn.route) {
            SignInUser(
                navigateUp = { navController.navigateUp() },
                navigateTo = {navController.navigate(it)})
        }

    }

}

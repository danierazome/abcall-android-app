package com.example.abcall

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.abcall.select_user_type.components.selectUserType
import com.example.abcall.select_user_type.config.UserTypeScreens
import com.example.abcall.team.config.TeamScreens
import com.example.abcall.team.sign_in.components.signInTeam
import com.example.abcall.user.config.UserScreens
import com.example.abcall.user.sign_in.components.signInUser
import com.example.abcall.user.sign_up.components.signUpUser

@Composable
fun IndexApp(
    navController: NavHostController = rememberNavController(),
    changeTheme: (Int) -> Unit) {

    NavHost(
        navController = navController,
        startDestination = UserTypeScreens.SelectUserType.name
    ) {
        composable(route = UserTypeScreens.SelectUserType.name) {
            selectUserType(
                navigateTo = {
                    navController.navigate(it)
                },
                changeTheme = changeTheme
            )
        }

        composable(route = UserScreens.SignIn.route) {
            signInUser(
                navigateUp = { navController.navigateUp() },
                navigateTo = {navController.navigate(it)})
        }

        composable(route = UserScreens.SignUp.route) {
            signUpUser(
                navigateUp = { navController.navigateUp() },
                navigateTo = {navController.navigate(it)})
        }

        composable(route = TeamScreens.SignIn.route) {
            signInTeam(
                navigateUp = { navController.navigateUp() },
                navigateTo = {navController.navigate(it)},
                changeTheme = changeTheme)
        }

    }

}

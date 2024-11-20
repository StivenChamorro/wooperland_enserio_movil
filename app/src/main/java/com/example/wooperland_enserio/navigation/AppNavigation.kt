package com.example.wooperland_enserio.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable


import com.example.wooperland_enserio.screens.AchievementsScreen
import com.example.wooperland_enserio.screens.AddChildScreen
import com.example.wooperland_enserio.screens.AvatarScreen
import com.example.wooperland_enserio.screens.ChangePlayerPasswordScreen
import com.example.wooperland_enserio.screens.ChangePlayerScreen
import com.example.wooperland_enserio.screens.EdithFatherScreen
import com.example.wooperland_enserio.screens.HomeScreen
import com.example.wooperland_enserio.screens.LevelPreviewScreen
import com.example.wooperland_enserio.screens.LoginScreen
import com.example.wooperland_enserio.screens.ProfileScreen
import com.example.wooperland_enserio.screens.RegisterScreen
import com.example.wooperland_enserio.screens.ShopScreen
import com.example.wooperland_enserio.screens.TermsScreen

@Composable
fun AppNavigation(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = NavigationItem.Login.route
    ) {
        composable(NavigationItem.Login.route) {
            LoginScreen(navController)
        }
        composable(NavigationItem.Register.route) {
            RegisterScreen(navController)
        }
        composable(NavigationItem.Terms.route) {
            TermsScreen(navController)
        }
        composable(NavigationItem.AddChild.route) {
            AddChildScreen(navController)
        }

        //rutas de navegacion principales
        composable(NavScreen.HomeScreen.name) {
            HomeScreen(navController)
        }
        composable(NavScreen.ProfileScreen.name) {
            ProfileScreen()
        }
        composable(NavScreen.AvatarScreen.name) {
            AvatarScreen()
        }
        composable(NavScreen.ShopScreen.name) {
            ShopScreen()
        }
        composable(NavScreen.AchievementScreen.name) {
            AchievementsScreen(navController)
        }
        composable(NavScreen.ChangePlayerPasswordScreen.name) {
            ChangePlayerPasswordScreen(navController)
        }
        composable(NavScreen.EdithFatherScreen.name) {
            EdithFatherScreen()
        }
        composable(NavScreen.ChangePlayerScreen.name) {
           ChangePlayerScreen(navController)
        }
        composable(NavScreen.LevelPreviewScreen.name) {
            LevelPreviewScreen(navController)
        }

    }
}
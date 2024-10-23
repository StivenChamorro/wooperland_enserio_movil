package com.example.wooperland_enserio.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.wooperland_enserio.screens.AchievementScreen
import com.example.wooperland_enserio.screens.AvatarScreen
import com.example.wooperland_enserio.screens.HomeScreen
import com.example.wooperland_enserio.screens.ProfileScreen
import com.example.wooperland_enserio.screens.ShopScreen

@Composable
fun AppNavigation(
    navController: NavHostController
){
    NavHost(
        navController = navController,
        startDestination = NavScreen.HomeScreen.name
    ) {
        composable(NavScreen.HomeScreen.name) {
            HomeScreen()
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
            AchievementScreen()
        }

    }
}
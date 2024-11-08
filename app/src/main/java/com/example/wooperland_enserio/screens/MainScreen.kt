package com.example.wooperland_enserio.screens

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.wooperland_enserio.components.NavegacionInferior
import com.example.wooperland_enserio.components.TopAppBar
import com.example.wooperland_enserio.navigation.AppNavigation
import com.example.wooperland_enserio.navigation.NavScreen


@Composable
fun MainScreen() {
    val navController = rememberNavController()

    // Define las rutas donde se debe mostrar el Bottom Navigation
    val bottomNavRoutes = listOf(
        NavScreen.HomeScreen.name,
        NavScreen.ProfileScreen.name,
        NavScreen.ShopScreen.name,
        NavScreen.AvatarScreen.name,
        NavScreen.AchievementScreen.name
    )

    Scaffold(
        topBar = {
            // Muestra el TopAppBar solo en las rutas especificadas
            AnimatedVisibility(
                visible = navController.currentBackStackEntryAsState().value?.destination?.route in bottomNavRoutes,
                enter = fadeIn(),
                exit = fadeOut()
            ) {
                TopAppBar(navController)
            }
        },
        bottomBar = {
            // Muestra el BottomNavigation solo en las rutas especificadas
            AnimatedVisibility(
                visible = navController.currentBackStackEntryAsState().value?.destination?.route in bottomNavRoutes,
                enter = fadeIn(),
                exit = fadeOut()
            ) {
                NavegacionInferior(navController)
            }
        }
    ) { padding ->
        Box(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize()
        ) {
            AppNavigation(navController = navController)
        }
    }
}
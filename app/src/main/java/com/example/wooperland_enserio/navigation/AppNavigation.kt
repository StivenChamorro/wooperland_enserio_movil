package com.example.wooperland_enserio.navigation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
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
import com.example.wooperland_enserio.screens.LevelScreen
import com.example.wooperland_enserio.screens.LoginScreen
import com.example.wooperland_enserio.screens.ProfileScreen
import com.example.wooperland_enserio.screens.RegisterScreen
import com.example.wooperland_enserio.screens.ShopScreen
import com.example.wooperland_enserio.screens.TermsScreen
import com.example.wooperland_enserio.viewmodel.ChildProfileViewModel
import com.example.wooperland_enserio.viewmodel.LoginViewModel
import com.example.wooperland_enserio.viewmodel.RegisterViewModel
import com.example.wooperland_enserio.viewmodel.TopicsViewModel

@RequiresApi(Build.VERSION_CODES.N)
@Composable
fun AppNavigation(
    viewModel: LoginViewModel,
    viewModel2: RegisterViewModel,
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = NavigationItem.Login.route
    ) {

        composable(route = NavigationItem.Login.route) {
            if (viewModel.isSuccessLoading.value) {
                LaunchedEffect(key1 = Unit) {
                    if (viewModel.isFirstLogin.value) {
                        // Redirigir a TermsScreen si es el primer login.
                        navController.navigate(route = NavigationItem.Terms.route) {
                            popUpTo(route = NavigationItem.Login.route) {
                                inclusive = true
                            }
                        }
                    } else {
                        // Redirigir a la vista habitual.
                        navController.navigate(route = NavigationItem.Home.route) {
                            popUpTo(route = NavigationItem.Login.route) {
                                inclusive = true
                            }
                        }
                    }
                }
            } else {
                LoginScreen(
                    onclickLogin = { email, password -> viewModel.login(email, password) },
                    navController = navController
                )
            }
        }



        composable(NavigationItem.Terms.route) {
            TermsScreen(navController)
        }

        composable(route = NavigationItem.Register.route) {
            if (viewModel2.isSuccessRegister.value) {
                LaunchedEffect(key1 = Unit) {
                    navController.navigate(NavigationItem.Login.route) {
                        popUpTo(route = NavigationItem.Register.route) {
                            inclusive = true
                        }
                    }
                }
            } else {
                RegisterScreen(
                    navController = navController,
                    onClickRegister = { name, lastName, birthDate, email, username, password, confirmPassword, token ->
                        viewModel2.register(name, lastName, birthDate, email, username, password, confirmPassword, token)
                    }
                )
            }
        }



//        composable(NavigationItem.Login.route) {
//            LoginScreen(navController)
//        }
//        composable(NavigationItem.Register.route) {
//            RegisterScreen(navController)
//        }

        composable(NavigationItem.AddChild.route) {
            AddChildScreen(navController)
        }

        //rutas de navegacion principales
        composable(NavScreen.HomeScreen.name) {
            HomeScreen(navController, viewModel = TopicsViewModel())
        }
        composable(NavScreen.ProfileScreen.name) {
            ProfileScreen(viewModel = ChildProfileViewModel())
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
        composable(NavScreen.LevelScreen.name) {
            LevelScreen(onNavigateBack = { navController.popBackStack() }, navController = navController)
        }

    }
}
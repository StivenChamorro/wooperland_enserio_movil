package com.example.wooperland_enserio.navigation

enum class Screen { // Names to identify the screens
    LoginScreen,
    RegisterScreen,
    TermsScreen,
    AddChildScreen,
    HomeScreen,
}

// Objects to identify where navigate
sealed class NavigationItem(val route: String) {
    object Login: NavigationItem(Screen.LoginScreen.name)
    object Register: NavigationItem(Screen.RegisterScreen.name)
    object Terms: NavigationItem(Screen.TermsScreen.name)
    object AddChild: NavigationItem(Screen.AddChildScreen.name)
    object Home: NavigationItem(Screen.HomeScreen.name)
}
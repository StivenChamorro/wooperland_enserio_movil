package com.example.wooperland_enserio.navigation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.compose.rememberNavController
import com.example.wooperland_enserio.components.NavegacionInferior
import com.example.wooperland_enserio.screens.AddChild
import com.example.wooperland_enserio.screens.HomeScreen
import com.example.wooperland_enserio.screens.LoginScreen
import com.example.wooperland_enserio.screens.RegisterScreen
import com.example.wooperland_enserio.screens.TermsScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        setContent {
            MainScreen()
        }
    }
}

@Composable
fun MainScreen(){
    val navController = rememberNavController()
    Scaffold (
        bottomBar = {
            NavegacionInferior(navController)
        }
    ){padding ->
        Box(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize()
        ){
            AppNavigation(navController = navController)

        }
    }
}
package com.example.wooperland_enserio.models

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material.icons.outlined.AddShoppingCart
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Shop
import androidx.compose.material.icons.outlined.TaskAlt
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.wooperland_enserio.navigation.NavScreen

sealed class Items_bottom_nav (
    val icon: ImageVector,
    val title: String,
    val ruta: String
){
    object Item_bottom_nav1: Items_bottom_nav(
       Icons.Outlined.AccountCircle,
        "Tu cuenta",
        NavScreen.ProfileScreen.name
    )

    object Item_bottom_nav2: Items_bottom_nav(
        Icons.Outlined.AddShoppingCart,
        "Avatares",
        NavScreen.AvatarScreen.name
    )

    object Item_bottom_nav3: Items_bottom_nav(
        Icons.Outlined.Home,
        "Home",
        NavScreen.HomeScreen.name
    )

    object Item_bottom_nav4: Items_bottom_nav(
        Icons.Outlined.Shop,
        "Tienda",
        NavScreen.ShopScreen.name
    )

//    object Item_bottom_nav5: Items_bottom_nav(
//        Icons.Outlined.TaskAlt,
//        "Logros",
//        NavScreen.AchievementScreen.name
//    )

}

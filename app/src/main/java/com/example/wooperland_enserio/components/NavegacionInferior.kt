package com.example.wooperland_enserio.components


import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import com.example.wooperland_enserio.models.Items_bottom_nav.*
import com.example.wooperland_enserio.navigation.currentRoute

@Composable
fun NavegacionInferior(
   navController: NavHostController
){
    val menu_items = listOf(
        Item_bottom_nav1,
        Item_bottom_nav2,
        Item_bottom_nav3,
        Item_bottom_nav4,
        Item_bottom_nav5,
    )
    BottomAppBar(
        containerColor = Color(0xFFB43654)
    ){
        NavigationBar(
            containerColor = Color(0xFFB43654)
        ) {
            menu_items.forEach{item->
                val selected = currentRoute(navController ) == item.ruta
                NavigationBarItem(
                selected = selected,
                onClick = {navController.navigate(item.ruta)},
                icon = {
                    Icon(imageVector = item.icon,
                        contentDescription = item.title,
                        tint = Color.White
                    )
                },
                label = {
                    Text(
                        text = item.title,
                        color = Color.White
                    )

                }
            )
            }
        }
    }
}
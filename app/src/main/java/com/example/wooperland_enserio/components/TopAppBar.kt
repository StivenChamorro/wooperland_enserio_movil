package com.example.wooperland_enserio.components

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Games
import androidx.compose.material.icons.outlined.ManageAccounts
import androidx.compose.material.icons.outlined.MoreVert
import androidx.compose.material3.Divider
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.wooperland_enserio.R
import com.example.wooperland_enserio.models.DraweItem
import com.example.wooperland_enserio.navigation.NavScreen
import com.example.wooperland_enserio.screens.HomeScreen
import com.example.wooperland_enserio.ui.theme.Rosa_wooper
import com.example.wooperland_enserio.ui.theme.Wooperland_enserioTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBar(navController: NavHostController) {


    val context = LocalContext.current.applicationContext
    var showMenu by remember { mutableStateOf(false)}
    androidx.compose.material3.TopAppBar(
        title = {
            Text(
                text = "Wooperland",
                color = Color(0xFFFFD166), // Color amarillo FFD166
                style = TextStyle(
                    fontSize = (16.sp),
                    fontFamily = FontFamily(
                        Font(R.font.press_start_2p) // Asegúrate de que el nombre del recurso coincide con el archivo
                    ),
                    shadow = Shadow(
                        color = Color(0xFFEF476F), // Sombra sólida de color EF476F
                        offset = Offset(4f, 4f), // Ajusta la distancia de la sombra
                        blurRadius = 0f // Sin desenfoque para una sombra sólida
                    )
                )
            )
        },
        navigationIcon = {
            IconButton(onClick = {
                //Toast.makeText(context, "Wooperland", Toast.LENGTH_SHORT).show()
                navController.navigate("HomeScreen")
            }) {
                Image(
                    painter = painterResource(id = R.drawable.logo),
                    contentDescription = "Wooperland icon",
                    modifier = Modifier.size(40.dp)
                )
            }
        }, colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Rosa_wooper,
            titleContentColor = Color.White,
            navigationIconContentColor = Color.White
        ), actions = {
            IconButton(onClick = {
                showMenu = !showMenu
            }) {
                Icon(
                    imageVector = Icons.Outlined.MoreVert,
                    contentDescription = "Ver mas",
                    tint = Color.White
                )
            }
            DropdownMenu(
                expanded = showMenu,
                onDismissRequest = { showMenu = false },
                modifier = Modifier
                    .background(Rosa_wooper)
            )
            {
                DropdownMenuItem(
                    text = {
                        Row (
                            verticalAlignment = Alignment.CenterVertically
                        ){
                            Icon(
                                imageVector = Icons.Outlined.Games,
                                contentDescription = "CambiarJugador",
                                modifier = Modifier
                                    .size(24.dp),
                                tint = Color.White
                            )
                            Text(
                                text = "Cambiar Jugador",
                                color = Color.White,
                                modifier = Modifier
                                    .padding(start = 10.dp),
                                fontSize = 15.sp,
                                fontFamily = FontFamily(
                                    Font(R.font.happy_monkey)
                                )
                            )
                        }
                    },
                    onClick = { navController.navigate("LoginScreen") })

                DropdownMenuItem(
                    text = {
                        Row (
                            verticalAlignment = Alignment.CenterVertically
                        ){
                            Icon(
                                imageVector = Icons.Outlined.ManageAccounts,
                                contentDescription = "PerfilPadre",
                                modifier = Modifier
                                    .size(24.dp),
                                tint = Color.White
                            )
                            Text(
                                text = "Perfil Adulto",
                                modifier = Modifier
                                    .padding(start = 10.dp),
                                color = Color.White,
                                fontSize = 15.sp,
                                fontFamily = FontFamily(
                                    Font(R.font.happy_monkey)
                                )
                            )
                        }
                    },
                    onClick = { navController.navigate(NavScreen.ChangePlayerPasswordScreen.name) })
            }
        }
    )
}
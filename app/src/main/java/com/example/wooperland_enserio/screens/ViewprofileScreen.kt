package com.example.wooperland_enserio.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.wooperland_enserio.R
import com.example.wooperland_enserio.ui.theme.Wooperland_enserioTheme

@Composable
fun ViewprofileScreen() {
    val scrollState = rememberScrollState()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFFFD180))
    ) {
        // Top Bar
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    color = Color(0xFFFFB74D),
                    shape = RoundedCornerShape(bottomEnd = 25.dp, bottomStart = 25.dp)
                )
                .height(170.dp)
                .align(Alignment.CenterHorizontally)

        ) {
            IconButton(
                onClick = { /* Handle back navigation */ },
                modifier = Modifier.align(Alignment.CenterStart)
            ) {
                Icon(Icons.Default.ArrowBack, contentDescription = "Back")
            }
            Box(
                modifier = Modifier
                    .width(270.dp)
                    .align(Alignment.Center)
            )
            {
                Column(
                    modifier = Modifier.padding(10.dp)
                        .align(Alignment.CenterStart)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.person),
                        contentDescription = "Profile Picture",
                        modifier = Modifier
                            .size(64.dp)
                            .clip(CircleShape),
                        contentScale = ContentScale.Crop
                    )
                }
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.align(Alignment.CenterEnd)
                ) {
                    Text(
                        text = "John Smith",
                        fontSize = 20.sp,
                        fontFamily = FontFamily(Font(R.font.happy_monkey)),
                        color = Color.Black
                    )
                    Text(
                        text = "johnsmith@example.com",
                        fontSize = 14.sp,
                        fontFamily = FontFamily(Font(R.font.happy_monkey)),
                        color = Color.Black
                    )
                }
            }
            Button(
                onClick = { /* Handle profile view */ },
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFF4081)),
                shape = RoundedCornerShape(20.dp),
                modifier = Modifier.padding(top = 8.dp, bottom = 8.dp)
                    .height(35.dp)
                    .align(Alignment.BottomCenter)
            ) {
                Text(
                    "Ver perfil",
                    fontFamily = FontFamily(Font(R.font.happy_monkey)),
                    color = Color.Black
                )
            }

        }

        // Profile Section
        Column(
            modifier = Modifier
                .weight(1f)
                .padding(15.dp)
                .verticalScroll(scrollState)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 24.dp)
                    .background(
                        color = Color(0xFFFFB74D),
                        shape = RoundedCornerShape(percent = 10)
                    ),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(
                            color = Color(0xFFFFB74D),
                            shape = RoundedCornerShape(
                                bottomEnd = 40.dp,
                                bottomStart = 40.dp,
                                topStart = 40.dp,
                                topEnd = 40.dp
                            )
                        )
                ) {
                    Row(
                        modifier = Modifier
                            .padding(10.dp)
                            .width(380.dp)
                            .height(200.dp)
                            .align(Alignment.Center)
                    ) {
                        // Columna para la imagen
                        Column(
                            modifier = Modifier
                                .width(100.dp)
                                .fillMaxHeight()
                                .padding(10.dp),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.player_avatar),
                                contentDescription = "Player Avatar",
                                modifier = Modifier
                                    .size(90.dp)
                                    .clip(CircleShape),
                                contentScale = ContentScale.Crop
                            )
                        }
                        Spacer(modifier = Modifier.weight(1f))
                        // Columna para el texto
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .fillMaxHeight()
                                .padding(5.dp),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center
                        ) {
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceAround // Espacio entre etiquetas y valores
                            ) {
                                Column() {
                                    Text(
                                        "Nombre:",
                                        fontSize = 16.sp,
                                        color = Color.DarkGray,
                                        fontFamily = FontFamily(Font(R.font.happy_monkey))
                                    )
                                    Text(
                                        "apellido",
                                        fontSize = 16.sp,
                                        color = Color.DarkGray,
                                        fontFamily = FontFamily(Font(R.font.happy_monkey))
                                    )
                                    Text(
                                        "Edad",
                                        fontSize = 16.sp,
                                        color = Color.DarkGray,
                                        fontFamily = FontFamily(Font(R.font.happy_monkey))
                                    )
                                    Text(
                                        "Relacion",
                                        fontSize = 16.sp,
                                        color = Color.DarkGray,
                                        fontFamily = FontFamily(Font(R.font.happy_monkey))
                                    )
                                    Text(
                                        "Genero",
                                        fontSize = 16.sp,
                                        color = Color.DarkGray,
                                        fontFamily = FontFamily(Font(R.font.happy_monkey))
                                    )
                                    Text(
                                        "Nickname",
                                        fontSize = 16.sp,
                                        color = Color.DarkGray,
                                        fontFamily = FontFamily(Font(R.font.happy_monkey))
                                    )
                                }
                                Column() {
                                    Text(
                                        "Nicolas",
                                        fontSize = 16.sp,
                                        color = Color.DarkGray,
                                        fontFamily = FontFamily(Font(R.font.happy_monkey))
                                    )
                                    Text(
                                        "Smith phines",
                                        fontSize = 16.sp,
                                        color = Color.DarkGray,
                                        fontFamily = FontFamily(Font(R.font.happy_monkey))
                                    )
                                    Text(
                                        "8 años",
                                        fontSize = 16.sp,
                                        color = Color.DarkGray,
                                        fontFamily = FontFamily(Font(R.font.happy_monkey))
                                    )
                                    Text(
                                        "hijo",
                                        fontSize = 16.sp,
                                        color = Color.DarkGray,
                                        fontFamily = FontFamily(Font(R.font.happy_monkey))
                                    )
                                    Text(
                                        "niño",
                                        fontSize = 16.sp,
                                        color = Color.DarkGray,
                                        fontFamily = FontFamily(Font(R.font.happy_monkey))
                                    )
                                    Text(
                                        "Nick",
                                        fontSize = 16.sp,
                                        color = Color.DarkGray,
                                        fontFamily = FontFamily(Font(R.font.happy_monkey))
                                    )
                                }
                            }
                        }
                    }
                }
            }


            // Wooperland Section
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(280.dp)
                    .padding(vertical = 7.dp),
                shape = RoundedCornerShape(25.dp),
                colors = CardDefaults.cardColors(containerColor = Color(0xFFFFB74D)
                )
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(270.dp)
                        .padding(10.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.grafico),
                        contentDescription = "Player Avatar",
                        modifier = Modifier
                            .width(300.dp),
                        contentScale = ContentScale.Crop
                    )

                    Text(
                        "Promedio de horas: 1.98 horas",
                        fontSize = 16.sp,
                        modifier = Modifier.padding(top = 8.dp)
                    )
                }
            }

            Spacer(modifier = Modifier.weight(1f))

            // Buttons
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                Button(
                    onClick = { /* Handle profile view */ },
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFF4081)),
                    shape = RoundedCornerShape(20.dp),
                    modifier = Modifier.padding(top = 7.dp, bottom = 7.dp)
                        .width(160.dp)
                        .height(35.dp)) {
                    Text("Editar información",
                        fontFamily = FontFamily(Font(R.font.happy_monkey)),
                        fontSize = 11.sp,
                        color = Color.Black)
                }

                Button(
                    onClick = { /* Handle profile view */ },
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFF4081)),
                    shape = RoundedCornerShape(20.dp),
                    modifier = Modifier.padding(top = 7.dp, bottom = 7.dp)
                        .width(160.dp)
                        .height(35.dp)) {
                    Text("Eliminar Jugador",
                        fontFamily = FontFamily(Font(R.font.happy_monkey)),
                        fontSize = 11.sp,
                        color = Color.Black)
                }
            }

            Button(
                onClick = { /* Cerrar sesión */ },
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(percent = 15))
                    .background(Color(0xFFFFB74D)),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFFB74D)),
                contentPadding = PaddingValues(16.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.close),
                    contentDescription = "Perfil",
                    modifier = Modifier
                        .size(50.dp)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    "Cerrar sesión",
                    fontFamily = FontFamily(Font(R.font.happy_monkey)),
                    fontSize = 12.sp,
                    color = Color.Black,
                    modifier = Modifier.padding(start = 8.dp)
                )
            }
        }
    }
}

@Composable
fun Chart() {
    // Código para crear el gráfico de barras de Wooperland
    // Puedes usar una biblioteca de gráficos como Jetpack Compose's Accompanist
    // o una librería externa como Recharts
}

@Preview(showBackground = true)
@Composable
fun ViewprofileScreenPreview() {
    Wooperland_enserioTheme {
        ViewprofileScreen()
    }
}
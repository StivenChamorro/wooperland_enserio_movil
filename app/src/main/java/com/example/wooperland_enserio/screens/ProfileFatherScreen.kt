package com.example.wooperland_enserio.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material.icons.filled.LightMode
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.wooperland_enserio.R
import com.example.wooperland_enserio.ui.theme.Amarillo
import com.example.wooperland_enserio.ui.theme.Wooperland_enserioTheme

@Composable
fun ProfileFatherScreen() {
    var isDarkMode by remember { mutableStateOf(false) }
    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFFFD180))
            .verticalScroll(scrollState)
            .padding(16.dp)
    ) {
        // Top Bar
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically

        ) {
            IconButton(onClick = { /* Navegación hacia atrás */ }) {
                Icon(Icons.Default.ArrowBack, contentDescription = "Regresar")

            }
            Text(
                "Mi cuenta",
                fontFamily = FontFamily(Font(R.font.happy_monkey)),
                fontSize = 24.sp,
                modifier = Modifier.padding(start = 8.dp)
            )
        }

        // Perfil
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                modifier = Modifier
                    .size(110.dp)
                    .clip(CircleShape)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.person),
                    contentDescription = "Perfil",
                    modifier = Modifier
                        .size(110.dp)
                        .align(Alignment.Center),
                )
            }

            Text(
                "John Smith",
                fontFamily = FontFamily(Font(R.font.happy_monkey)),
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(top = 16.dp)
            )

            Text(
                "johnsmith@example.com",
                fontFamily = FontFamily(Font(R.font.happy_monkey)),
                fontSize = 11.sp,
                color = Color.DarkGray
            )

            Button(
                onClick = { /* Ver perfil */ },
                modifier = Modifier
                    .padding(top = 8.dp)
                    .clip(RoundedCornerShape(percent = 30))
                    .border(1.dp, Color.Black, shape = RoundedCornerShape(30))
                    .height(33.dp),// Establecer el color de fondo
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFABD30)),
            ) {
                Text("Ver perfil",
                    fontFamily = FontFamily(Font(R.font.happy_monkey)),
                    fontSize = 15.sp,
                    color = Color.Black,
                    modifier = Modifier.padding(vertical = 0.dp)
                )
            }
        }

        // Sección Temas
        Text(
            "Temas",
            fontFamily = FontFamily(Font(R.font.happy_monkey)),
            fontSize = 17.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(vertical = 8.dp)
        )

        Card(
            modifier = Modifier.fillMaxWidth(),
            colors = CardDefaults.cardColors(containerColor = Color(0xFFFFB74D))
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text("Cambiar de light a dark",
                        fontFamily = FontFamily(Font(R.font.happy_monkey)),
                        fontSize = 12.sp,)
                Switch(
                    checked = isDarkMode,
                    onCheckedChange = { isDarkMode = it }
                )
            }
        }

        // Sección Opciones del adulto
        Text(
            "Opciones del adulto",
            fontFamily = FontFamily(Font(R.font.happy_monkey)),
            fontSize = 17.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(vertical = 8.dp)
        )

        Button( onClick = {/*vista de jugadores*/},
            modifier = Modifier.fillMaxWidth()
                .clip(RoundedCornerShape(percent = 15))
                .background(Color(0xFFFFB74D)),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFFB74D))
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Box(
                        modifier = Modifier
                            .size(50.dp)
                            .clip(CircleShape)
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.players),
                            contentDescription = "Perfil",
                            modifier = Modifier
                                .size(50.dp)
                                .align(Alignment.Center),
                        )
                    }
                    Text(
                        "Ver mis jugadores",
                        fontFamily = FontFamily(Font(R.font.happy_monkey)),
                        fontSize = 12.sp,
                        color = Color.Black,
                        modifier = Modifier.padding(start = 8.dp)
                    )
                }
                Icon(
                    Icons.Default.ArrowBack,
                    contentDescription = "Ir a jugadores",
                    modifier = Modifier.rotate(180f)
                )
            }
        }
        Spacer(modifier = Modifier.weight(1f))
        // Botón Cerrar sesión
        Button(
            onClick = { /* Cerrar sesión */ },
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(percent = 15))
                .background(Color(0xFFFFB74D)),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFFB74D)),
            contentPadding = PaddingValues(16.dp)
        ) {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = R.drawable.close),
                    contentDescription = "Perfil",
                    modifier = Modifier
                        .size(50.dp)
                )

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


@Preview(showBackground = true)
@Composable
fun ProfileFatherScreenPreview(){
    Wooperland_enserioTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            ProfileFatherScreen()
        }
    }
}
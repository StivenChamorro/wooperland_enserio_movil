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
fun ViewChild() {
    var nombres by remember { mutableStateOf("Nicolas") }
    var apellidos by remember { mutableStateOf("Smith Pines") }
    var Edad by remember { mutableStateOf("8 años") }
    var Relacion by remember { mutableStateOf("hijo") }
    var genero by remember { mutableStateOf("niño") }
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
        Column(
            modifier = Modifier
                .weight(1f)
                .verticalScroll(scrollState)
                .padding(15.dp)
        ) {

            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
                    .clip(RoundedCornerShape(percent = 5))
                    .background(Color(0xFFFFB74D)),
                colors = CardDefaults.cardColors(containerColor = Color(0xFFFFB74D))
            ) {
                Column(
                    modifier = Modifier.padding(16.dp),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.player_avatar),
                        contentDescription = "Profile Picture",
                        modifier = Modifier
                            .size(120.dp)
                            .clip(CircleShape)
                    )
                    Text(
                        text = "Nick",
                        fontFamily = HappyMonkeyFont,
                        fontWeight = FontWeight.Bold)
                    OutlinedTextField(
                        value = nombres,
                        onValueChange = { nombres = it },
                        label = { Text("Nombres", fontFamily = HappyMonkeyFont) },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 4.dp),
                        colors = OutlinedTextFieldDefaults.colors(
                            unfocusedBorderColor = Color.Black,
                            focusedBorderColor = Color.Black
                        ),
                        shape = RoundedCornerShape(15.dp),
                        textStyle = LocalTextStyle.current.copy(fontFamily = HappyMonkeyFont)

                    )

                    OutlinedTextField(
                        value = apellidos,
                        onValueChange = { apellidos = it },
                        label = { Text("Apellidos", fontFamily = HappyMonkeyFont) },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 4.dp),
                        colors = OutlinedTextFieldDefaults.colors(
                            unfocusedBorderColor = Color.Black,
                            focusedBorderColor = Color.Black
                        ),
                        shape = RoundedCornerShape(15.dp),
                        textStyle = LocalTextStyle.current.copy(fontFamily = HappyMonkeyFont)
                    )

                    OutlinedTextField(
                        value = Edad,
                        onValueChange = { Edad = it },
                        label = { Text("Edad", fontFamily = HappyMonkeyFont) },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 4.dp),
                        colors = OutlinedTextFieldDefaults.colors(
                            unfocusedBorderColor = Color.Black,
                            focusedBorderColor = Color.Black
                        ),
                        shape = RoundedCornerShape(15.dp),
                        textStyle = LocalTextStyle.current.copy(fontFamily = HappyMonkeyFont)
                    )

                    OutlinedTextField(
                        value = Relacion,
                        onValueChange = { Relacion = it },
                        label = { Text("Relacion", fontFamily = HappyMonkeyFont) },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 4.dp),
                        colors = OutlinedTextFieldDefaults.colors(
                            unfocusedBorderColor = Color.Black,
                            focusedBorderColor = Color.Black
                        ),
                        shape = RoundedCornerShape(15.dp),
                        textStyle = LocalTextStyle.current.copy(fontFamily = HappyMonkeyFont)
                    )
                    OutlinedTextField(
                        value = genero,
                        onValueChange = { genero = it },
                        label = { Text("genero", fontFamily = HappyMonkeyFont) },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 4.dp),
                        colors = OutlinedTextFieldDefaults.colors(
                            unfocusedBorderColor = Color.Black,
                            focusedBorderColor = Color.Black
                        ),
                        shape = RoundedCornerShape(15.dp),
                        textStyle = LocalTextStyle.current.copy(fontFamily = HappyMonkeyFont)
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
                        .height(35.dp)
                ) {
                    Text(
                        "Editar información",
                        fontFamily = FontFamily(Font(R.font.happy_monkey)),
                        fontSize = 11.sp,
                        color = Color.Black
                    )
                }

                Button(
                    onClick = { /* Handle profile view */ },
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFF4081)),
                    shape = RoundedCornerShape(20.dp),
                    modifier = Modifier.padding(top = 7.dp, bottom = 7.dp)
                        .width(160.dp)
                        .height(35.dp)
                ) {
                    Text(
                        "Eliminar Jugador",
                        fontFamily = FontFamily(Font(R.font.happy_monkey)),
                        fontSize = 11.sp,
                        color = Color.Black
                    )
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



@Preview(showBackground = true)
@Composable
fun ViewChildPreview() {
    Wooperland_enserioTheme {
        ViewChild()
    }
}
package com.example.wooperland_enserio.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.wooperland_enserio.R
import com.example.wooperland_enserio.ui.theme.Wooperland_enserioTheme

// Primero necesitas añadir la fuente Happy Monkey en tu proyecto
// Coloca el archivo HappyMonkey-Regular.ttf en la carpeta res/font/
val HappyMonkeyFont = FontFamily(
    Font(R.font.happy_monkey)
)

@Composable
fun EdithFatherScreen() {
    val scrollState = rememberScrollState()
    var nombres by remember { mutableStateOf("John Andrés") }
    var apellidos by remember { mutableStateOf("Smith Pines") }
    var fechaNacimiento by remember { mutableStateOf("12/08/1986") }
    var correo by remember { mutableStateOf("johnsmith@example.com") }
    var usuario by remember { mutableStateOf("jhonsmith@example.com") }
    var contrasena by remember { mutableStateOf("********") }
    var passwordVisible by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFFFD180))
    ) {
        // Top Bar (fuera del scroll)
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(onClick = { /* Navegación hacia atrás */ }) {
                Icon(Icons.Default.ArrowBack, contentDescription = "Regresar")
            }
            Text(
                "Mi cuenta",
                fontSize = 24.sp,
                fontFamily = HappyMonkeyFont,
                modifier = Modifier.padding(start = 8.dp)
            )
        }

        // Contenido scrolleable
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(scrollState)
                .padding(horizontal = 16.dp)
        ) {
            // Profile Section
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
                    fontSize = 32.sp,
                    fontWeight = FontWeight.Bold,
                    fontFamily = HappyMonkeyFont,
                    modifier = Modifier.padding(top = 16.dp)
                )

                Text(
                    "johnsmith@example.com",
                    fontSize = 11.sp,
                    fontFamily = HappyMonkeyFont,
                    color = Color.DarkGray
                )

                Button(
                    onClick = { /* Ver perfil */ },
                    modifier = Modifier
                        .padding(top = 8.dp)
                        .clip(RoundedCornerShape(percent = 30))
                        .border(1.dp, Color.Black, shape = RoundedCornerShape(30))
                        .height(33.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFABD30)),
                    )
                 {
                    Text(
                        "Editar perfil",
                        fontFamily = HappyMonkeyFont,
                        fontSize = 15.sp,
                        color = Color.Black,
                    )
                }
            }

            // Formulario de datos personales
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
                    .clip(RoundedCornerShape(percent = 10))
                    .background(Color(0xFFFFB74D)),
                colors = CardDefaults.cardColors(containerColor = Color(0xFFFFB74D))
            ) {
                Column(
                    modifier = Modifier.padding(16.dp)
                ) {
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
                        value = fechaNacimiento,
                        onValueChange = { fechaNacimiento = it },
                        label = { Text("Fecha de nacimiento", fontFamily = HappyMonkeyFont) },
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
                        value = correo,
                        onValueChange = { correo = it },
                        label = { Text("Correo Electrónico", fontFamily = HappyMonkeyFont) },
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

            // Formulario de credenciales
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
                    .clip(RoundedCornerShape(percent = 10))
                    .background(Color(0xFFFFB74D)),
                colors = CardDefaults.cardColors(containerColor = Color(0xFFFFB74D))
            ) {
                Column(
                    modifier = Modifier.padding(16.dp)
                ) {
                    OutlinedTextField(
                        value = usuario,
                        onValueChange = { usuario = it },
                        label = { Text("Usuario", fontFamily = HappyMonkeyFont) },
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
                        value = contrasena,
                        onValueChange = { contrasena = it },
                        label = { Text("Contraseña", fontFamily = HappyMonkeyFont) },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 4.dp),
                        trailingIcon = {
                            IconButton(onClick = { passwordVisible = !passwordVisible }) {
                                Icon(
                                    if (passwordVisible) Icons.Default.Visibility
                                    else Icons.Default.VisibilityOff,
                                    contentDescription = "Toggle password visibility"
                                )
                            }
                        },
                        visualTransformation = if (passwordVisible) VisualTransformation.None
                        else PasswordVisualTransformation(),
                        colors = OutlinedTextFieldDefaults.colors(
                            unfocusedBorderColor = Color.Black,
                            focusedBorderColor = Color.Black
                        ),
                        shape = RoundedCornerShape(15.dp),
                        textStyle = LocalTextStyle.current.copy(fontFamily = HappyMonkeyFont)
                    )
                }
            }

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

            // Espacio adicional al final para evitar que el último elemento quede oculto
            Spacer(modifier = Modifier.height(32.dp))
        }
    }
}
@Preview(showBackground = true)
@Composable
fun EdithFatherScreenPreview(){
    Wooperland_enserioTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background,
        ) {
            EdithFatherScreen()
        }
    }
}
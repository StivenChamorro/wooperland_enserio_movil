package com.example.wooperland_enserio.screens

import android.icu.text.SimpleDateFormat
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.key.Key.Companion.Calendar
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.intl.Locale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.wooperland_enserio.R
import com.example.wooperland_enserio.navigation.NavScreen
import com.example.wooperland_enserio.ui.theme.Wooperland_enserioTheme
import java.time.LocalDate
import java.time.LocalDate.now
import java.time.format.DateTimeFormatter
import java.time.format.DateTimeFormatter.ofPattern


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RegisterScreen(navController: NavController) {
    val gradient = Brush.verticalGradient(
        colors = listOf(
            Color(0xFFFFD166), // Amarillo claro
            Color(0xFFB43654)  // Rosa oscuro
        )
    )

    // Variables para almacenar los inputs
    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var name by remember { mutableStateOf("") }
    var lastname by remember { mutableStateOf("") }
    var birthdate by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var pin by remember { mutableStateOf("") }

    val happyMonkeyFontFamily = FontFamily(Font(R.font.happy_monkey))

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(gradient)
            .padding(16.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.image4_4153158),
            contentDescription = null,
            contentScale = ContentScale.FillBounds,
            modifier = Modifier
                .size(180.dp, 25.dp)
                .align(Alignment.CenterHorizontally)
        )

        Spacer(modifier = Modifier.height(50.dp))

        Box(
            modifier = Modifier
                .border(
                    width = 1.dp,
                    color = Color.White,
                    shape = RoundedCornerShape(25.dp)
                )
        ) {
            Box(
                modifier = Modifier
                    .background(Color.White.copy(alpha = 0.3f), shape = RoundedCornerShape(25.dp))
                    .border(
                        width = 1.dp,
                        color = Color.White,
                        shape = RoundedCornerShape(25.dp)
                    )
                    .padding(16.dp, 50.dp, 16.dp, 70.dp) // Espaciado interno del Box
            ) {
                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Row (
                        horizontalArrangement = Arrangement.spacedBy(5.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ){
                        Text(
                            text = "Registro", fontFamily = FontFamily(Font(R.font.happy_monkey)),
                            color = Color.White,
                            fontSize = 30.sp
                        )
                    }

                    Spacer(modifier = Modifier.height(50.dp))

                    // Aquí vienen los inputs
                    Row (
                        horizontalArrangement = Arrangement.spacedBy(5.dp),
                        verticalAlignment = Alignment.CenterVertically

                    ){
                        OutlinedTextField(
                            value = name,
                            onValueChange = { name = it },
                            label = { Text("Nombres", color = Color.White, fontFamily = FontFamily(Font(R.font.happy_monkey))) },
                            modifier = Modifier
                                .weight(1f)
                                .height(56.dp),
                            shape = RoundedCornerShape(25.dp),
                            colors = TextFieldDefaults.outlinedTextFieldColors(
                                focusedBorderColor = Color.White, // Borde blanco al enfocar
                                unfocusedBorderColor = Color.White, // Borde blanco al desenfocar
                                cursorColor = Color.White // Color del cursor
                            )
                        )

                        Spacer(modifier = Modifier.width(16.dp))

                        OutlinedTextField(
                            value = lastname,
                            onValueChange = { lastname = it },
                            label = { Text("apellidos", color = Color.White, fontFamily = FontFamily(Font(R.font.happy_monkey))) },
                            modifier = Modifier
                                .weight(1f)
                                .height(56.dp),
                            shape = RoundedCornerShape(25.dp),
                            colors = TextFieldDefaults.outlinedTextFieldColors(
                                focusedBorderColor = Color.White, // Borde blanco al enfocar
                                unfocusedBorderColor = Color.White, // Borde blanco al desenfocar
                                cursorColor = Color.White // Color del cursor
                            )
                        )
                    }

                    Spacer(modifier = Modifier.height(16.dp))

                    // fecha de nacimiento
                    OutlinedTextField(
                        value = birthdate,
                        onValueChange = { birthdate = it },
                        label = { Text("Fecha de nacimiento", color = Color.White, fontFamily = FontFamily(Font(R.font.happy_monkey))) },
                        modifier = Modifier
                            .fillMaxWidth(1f)
                            .height(56.dp),
                        shape = RoundedCornerShape(25.dp),
                        colors = TextFieldDefaults.outlinedTextFieldColors(
                            focusedBorderColor = Color.White, // Borde blanco al enfocar
                            unfocusedBorderColor = Color.White, // Borde blanco al desenfocar
                            cursorColor = Color.White // Color del cursor
                        )
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    OutlinedTextField(
                        value = email,
                        onValueChange = { email = it },
                        label = { Text("Correo electrónico", color = Color.White, fontFamily = FontFamily(Font(R.font.happy_monkey))) },
                        modifier = Modifier
                            .fillMaxWidth(1f)
                            .height(56.dp),
                        shape = RoundedCornerShape(25.dp),
                        colors = TextFieldDefaults.outlinedTextFieldColors(
                            focusedBorderColor = Color.White, // Borde blanco al enfocar
                            unfocusedBorderColor = Color.White, // Borde blanco al desenfocar
                            cursorColor = Color.White // Color del cursor
                        )
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    OutlinedTextField(
                        value = username,
                        onValueChange = { username = it },
                        label = { Text("Usuario", color = Color.White, fontFamily = FontFamily(Font(R.font.happy_monkey))) },
                        modifier = Modifier
                            .fillMaxWidth(1f)
                            .height(56.dp),
                        shape = RoundedCornerShape(25.dp),
                        colors = TextFieldDefaults.outlinedTextFieldColors(
                            focusedBorderColor = Color.White, // Borde blanco al enfocar
                            unfocusedBorderColor = Color.White, // Borde blanco al desenfocar
                            cursorColor = Color.White // Color del cursor
                        )
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    OutlinedTextField(
                        value = password,
                        onValueChange = { password = it },
                        label = { Text("Contraseña", color = Color.White, fontFamily = FontFamily(Font(R.font.happy_monkey))) },
                        modifier = Modifier
                            .fillMaxWidth(1f)
                            .height(56.dp),
                        shape = RoundedCornerShape(25.dp),
                        colors = TextFieldDefaults.outlinedTextFieldColors(
                            focusedBorderColor = Color.White, // Borde blanco al enfocar
                            unfocusedBorderColor = Color.White, // Borde blanco al desenfocar
                            cursorColor = Color.White // Color del cursor
                        )
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    OutlinedTextField(
                        value = pin,
                        onValueChange = { pin = it },
                        label = { Text("Pin", color = Color.White, fontFamily = FontFamily(Font(R.font.happy_monkey))) },
                        modifier = Modifier
                            .fillMaxWidth(1f)
                            .height(56.dp),
                        shape = RoundedCornerShape(25.dp),
                        colors = TextFieldDefaults.outlinedTextFieldColors(
                            focusedBorderColor = Color.White, // Borde blanco al enfocar
                            unfocusedBorderColor = Color.White, // Borde blanco al desenfocar
                            cursorColor = Color.White // Color del cursor
                        )
                    )

                    Spacer(modifier = Modifier.height(100.dp))

                    // Botón de Registrarse
                    Button(
                        onClick = { navController.navigate(NavScreen.TermsScreen.name) },
                        modifier = Modifier
                            .fillMaxWidth(1f)
                            .height(50.dp)
                            .shadow(8.dp, shape = RoundedCornerShape(25.dp)), // Agrega sombra
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(0xFFEF476F) // Color de fondo
                        )
                    ) {
                        Text(text = "Registrarme", fontFamily = FontFamily(Font(R.font.happy_monkey)),fontSize = 20.sp,)
                    }

                    Spacer(modifier = Modifier.height(20.dp))

                    // Texto para registrar una nueva cuenta
                    Row(
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "Ya tienes cuenta?", fontFamily = FontFamily(Font(R.font.happy_monkey)),
                            color = Color.White,
                            fontSize = 18.sp
                        )
                        Spacer(modifier = Modifier.width(4.dp))
                        Text(
                            text = "Inicia Sesión", fontFamily = FontFamily(Font(R.font.happy_monkey)),
                            color = Color(0xFFFFD166),
                            fontSize = 18.sp,
                            modifier = Modifier.clickable { navController.navigate(NavScreen.LoginScreen.name) }
                        )
                    }

                }
            }
        }
        
        Spacer(modifier = Modifier.height(100.dp))

        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.Bottom
        )
        {
            Text(
                text = "©Wooperland 2024", fontFamily = FontFamily(Font(R.font.happy_monkey)),
                color = Color.White,
                fontSize = 15.sp
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun RegisterScreenPreview() {
    Wooperland_enserioTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            RegisterScreen(rememberNavController())
        }
    }
}
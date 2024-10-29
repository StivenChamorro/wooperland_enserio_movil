package com.example.wooperland_enserio.screens

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
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
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.wooperland_enserio.R
import androidx.navigation.compose.rememberNavController

import com.example.wooperland_enserio.navigation.AppNavigation
import com.example.wooperland_enserio.navigation.NavScreen
import com.example.wooperland_enserio.ui.theme.Wooperland_enserioTheme


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(navController: NavHostController) {@OptIn(ExperimentalMaterial3Api::class)
    val gradient = Brush.verticalGradient(
        colors = listOf(
            Color(0xFFFFD166), // Amarillo claro
            Color(0xFFB43654)  // Rosa oscuro
        )
    )

    // Variables para almacenar los inputs
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

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
        Spacer(modifier = Modifier.height(180.dp))
        // Imagen superior
        Image(
            painter = painterResource(id = R.drawable.image1_4153054),
            contentDescription = null,
            contentScale = ContentScale.FillBounds,
            modifier = Modifier
                .size(170.dp, 120.dp)
                .align(Alignment.Start)
        )

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
                    .padding(16.dp, 50.dp) // Espaciado interno del Box
            ) {
                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    // Input para Email
                    OutlinedTextField(
                        value = email,
                        onValueChange = { email = it },
                        label = { Text("Email", color = Color.White, fontFamily = FontFamily(Font(R.font.happy_monkey))) },
                        modifier = Modifier
                            .fillMaxWidth(0.9f)
                            .height(56.dp),
                        shape = RoundedCornerShape(25.dp),
                        colors = TextFieldDefaults.outlinedTextFieldColors(
                            focusedBorderColor = Color.White, // Borde blanco al enfocar
                            unfocusedBorderColor = Color.White, // Borde blanco al desenfocar
                            cursorColor = Color.White // Color del cursor
                        )
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    // Input para Contraseña
                    OutlinedTextField(
                        value = password,
                        onValueChange = { password = it },
                        label = { Text("Contraseña", color = Color.White, fontFamily = FontFamily(Font(R.font.happy_monkey))) },
                        modifier = Modifier
                            .fillMaxWidth(0.9f)
                            .height(56.dp),
                        shape = RoundedCornerShape(25.dp),
                        colors = TextFieldDefaults.outlinedTextFieldColors(
                            focusedBorderColor = Color.White, // Borde blanco al enfocar
                            unfocusedBorderColor = Color.White, // Borde blanco al desenfocar
                            cursorColor = Color.White // Color del cursor
                        ),
                        visualTransformation = androidx.compose.ui.text.input.PasswordVisualTransformation()
                    )

                    Spacer(modifier = Modifier.height(24.dp))

                    // Botón de Iniciar Sesión
                    Button(
                        onClick = {
                            navController.navigate(NavScreen.HomeScreen.name){
                                popUpTo(NavScreen.LoginScreen.name){
                                    inclusive = true
                                }
                            }
                        },
                        modifier = Modifier
                            .fillMaxWidth(.9f)
                            .height(48.dp)
                            .shadow(8.dp, shape = RoundedCornerShape(25.dp)), // Agrega sombra
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(0xFFEF476F) // Color de fondo
                        )
                    ) {
                        Text(text = "Iniciar Sesión", fontFamily = FontFamily(Font(R.font.happy_monkey)),fontSize = 20.sp,)
                    }

                    Spacer(modifier = Modifier.height(10.dp))

                    // Texto de "Olvidaste tu contraseña"
                    Text(
                        text = "Olvidaste tu contraseña?", fontFamily = FontFamily(Font(R.font.happy_monkey)),
                        color = Color.White,
                        fontSize = 18.sp,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.clickable { /* Acción de recuperación */ }
                    )

                    Spacer(modifier = Modifier.height(32.dp))

                    // Opción de Continuar con Google
                    Button(
                        onClick = { /* Acción para continuar con Google */ },
                        modifier = Modifier
                            .fillMaxWidth(.9f)
                            .height(56.dp)
                            .border(
                                width = 1.dp,
                                color = Color.White,
                                shape = RoundedCornerShape(25.dp)
                            ),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color.Transparent, // Fondo transparente
                            contentColor = Color.White // Color del texto y contenido
                        )
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.image3_4153076),
                            contentDescription = null,
                            modifier = Modifier.size(28.dp)
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(
                            text = "Continuar con Google", fontFamily = FontFamily(Font(R.font.happy_monkey)),
                            color = Color.White,
                            fontSize = 16.sp
                        )
                    }

                    Spacer(modifier = Modifier.height(10.dp))

                    // Texto para registrar una nueva cuenta
                    Row(
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "No tienes una cuenta?", fontFamily = FontFamily(Font(R.font.happy_monkey)),
                            color = Color.White,
                            fontSize = 18.sp
                        )
                        Spacer(modifier = Modifier.width(4.dp))
                        Text(
                            text = "Regístrate", fontFamily = FontFamily(Font(R.font.happy_monkey)),
                            color = Color(0xFFFFD166),
                            fontSize = 18.sp,
                            modifier = Modifier.clickable {
                                navController.navigate(NavScreen.RegisterScreen.name) {
                                }
                            }
                        )
                    }
                }
            }
        }
        Spacer(modifier = Modifier.height(200.dp))
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
fun LoginScreenPreview() {
    Wooperland_enserioTheme {
        val navController = rememberNavController() // NavController para la preview
        LoginScreen(navController = navController)
    }
}

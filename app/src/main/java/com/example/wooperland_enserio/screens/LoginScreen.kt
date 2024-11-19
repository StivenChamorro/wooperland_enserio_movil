package com.example.wooperland_enserio.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.wooperland_enserio.R
import com.example.wooperland_enserio.navigation.NavScreen
import com.example.wooperland_enserio.ui.theme.Wooperland_enserioTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(navController: NavHostController) {
    val configuration = LocalConfiguration.current
    val screenHeight = configuration.screenHeightDp.dp
    val screenWidth = configuration.screenWidthDp.dp

    val gradient = Brush.verticalGradient(
        colors = listOf(
            Color(0xFFFFD166),
            Color(0xFFB43654)
        )
    )

    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var passwordVisible by remember { mutableStateOf(false) }

    val happyMonkeyFont = FontFamily(Font(R.font.happy_monkey))

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(gradient)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(16.dp),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.image4_4153158),
                contentDescription = "Logo",
                contentScale = ContentScale.FillBounds,
                modifier = Modifier
                    .size(180.dp, 40.dp)
                    .padding(top = screenHeight * 0.02f)
            )

            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(id = R.drawable.image1_4153054),
                    contentDescription = "Decorative",
                    contentScale = ContentScale.FillBounds,
                    modifier = Modifier
                        .size(170.dp, 120.dp)
                        .align(Alignment.Start)
                )

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color.White.copy(alpha = 0.3f), RoundedCornerShape(25.dp))
                        .border(1.dp, Color.White, RoundedCornerShape(25.dp))
                        .padding(16.dp)
                ) {
                    Column(
                        verticalArrangement = Arrangement.spacedBy(16.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        OutlinedTextField(
                            value = email,
                            onValueChange = { email = it },
                            label = { Text("Email", color = Color.White, fontFamily = happyMonkeyFont) },
                            modifier = Modifier.fillMaxWidth(),
                            shape = RoundedCornerShape(25.dp),
                            colors = TextFieldDefaults.outlinedTextFieldColors(
                                focusedBorderColor = Color.White,
                                unfocusedBorderColor = Color.White,
                                cursorColor = Color.White
                            ),
                            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next)
                        )

                        OutlinedTextField(
                            value = password,
                            onValueChange = { password = it },
                            label = { Text("Contraseña", color = Color.White, fontFamily = happyMonkeyFont) },
                            modifier = Modifier.fillMaxWidth(),
                            shape = RoundedCornerShape(25.dp),
                            colors = TextFieldDefaults.outlinedTextFieldColors(
                                focusedBorderColor = Color.White,
                                unfocusedBorderColor = Color.White,
                                cursorColor = Color.White
                            ),
                            visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
                            trailingIcon = {
                                IconButton(onClick = { passwordVisible = !passwordVisible }) {
                                    Icon(
                                        imageVector = if (passwordVisible) Icons.Default.Visibility else Icons.Default.VisibilityOff,
                                        contentDescription = if (passwordVisible) "Hide password" else "Show password",
                                        tint = Color.White
                                    )
                                }
                            }
                        )

                        Button(
                            onClick = {
                                navController.navigate(NavScreen.HomeScreen.name) {
                                    popUpTo(NavScreen.LoginScreen.name) {
                                        inclusive = true
                                    }
                                }
                            },
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(48.dp)
                                .shadow(8.dp, shape = RoundedCornerShape(25.dp)),
                            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFEF476F))
                        ) {
                            Text(
                                text = "Iniciar Sesión",
                                fontFamily = happyMonkeyFont,
                                fontSize = (screenWidth.value * 0.05f).sp
                            )
                        }

                        Text(
                            text = "Olvidaste tu contraseña?",
                            fontFamily = happyMonkeyFont,
                            color = Color.White,
                            fontSize = (screenWidth.value * 0.04f).sp,
                            textAlign = TextAlign.Center,
                            modifier = Modifier.clickable { /* Acción de recuperación */ }
                        )

                        Spacer(modifier = Modifier.height(16.dp))

                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.Center
                        ) {
                            Text(
                                text = "No tienes una cuenta?",
                                fontFamily = happyMonkeyFont,
                                color = Color.White,
                                fontSize = (screenWidth.value * 0.04f).sp
                            )
                            Spacer(modifier = Modifier.width(4.dp))
                            Text(
                                text = "Regístrate",
                                fontFamily = happyMonkeyFont,
                                color = Color(0xFFFFD166),
                                fontSize = (screenWidth.value * 0.04f).sp,
                                modifier = Modifier.clickable {
                                    navController.navigate(NavScreen.RegisterScreen.name)
                                }
                            )
                        }
                    }
                }
            }

            Text(
                text = "©Wooperland 2024",
                fontFamily = happyMonkeyFont,
                color = Color.White,
                fontSize = (screenWidth.value * 0.035f).sp,
                modifier = Modifier.padding(bottom = screenHeight * 0.02f)
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

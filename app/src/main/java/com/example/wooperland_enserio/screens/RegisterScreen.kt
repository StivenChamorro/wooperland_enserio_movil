package com.example.wooperland_enserio.screens

import android.icu.text.SimpleDateFormat
import android.os.Build
import androidx.annotation.RequiresApi
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
import androidx.compose.material.icons.filled.CalendarToday
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
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.wooperland_enserio.R
import com.example.wooperland_enserio.navigation.NavScreen
import com.example.wooperland_enserio.ui.theme.Wooperland_enserioTheme
import java.util.*

@RequiresApi(Build.VERSION_CODES.N)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RegisterScreen(navController: NavController) {
    val configuration = LocalConfiguration.current
    val screenHeight = configuration.screenHeightDp.dp
    val screenWidth = configuration.screenWidthDp.dp

    val gradient = Brush.verticalGradient(
        colors = listOf(
            Color(0xFFFFD166),
            Color(0xFFB43654)
        )
    )

    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var name by remember { mutableStateOf("") }
    var lastname by remember { mutableStateOf("") }
    var birthdate by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var pin by remember { mutableStateOf("") }

    var passwordVisible by remember { mutableStateOf(false) }
    var pinVisible by remember { mutableStateOf(false) }
    var showDatePicker by remember { mutableStateOf(false) }

    val dateFormatter = remember { SimpleDateFormat("dd/MM/yyyy", Locale.getDefault()) }
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
                    Text(
                        text = "Registro",
                        fontFamily = happyMonkeyFont,
                        color = Color.White,
                        fontSize = (screenWidth.value * 0.08f).sp
                    )

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        OutlinedTextField(
                            value = name,
                            onValueChange = { name = it },
                            label = { Text("Nombres", color = Color.White, fontFamily = happyMonkeyFont) },
                            modifier = Modifier.weight(1f),
                            shape = RoundedCornerShape(25.dp),
                            colors = outlinedTextFieldColors()
                        )

                        OutlinedTextField(
                            value = lastname,
                            onValueChange = { lastname = it },
                            label = { Text("Apellidos", color = Color.White, fontFamily = happyMonkeyFont) },
                            modifier = Modifier.weight(1f),
                            shape = RoundedCornerShape(25.dp),
                            colors = outlinedTextFieldColors()
                        )
                    }

                    OutlinedTextField(
                        value = birthdate,
                        onValueChange = { },
                        label = { Text("Fecha de nacimiento", color = Color.White, fontFamily = happyMonkeyFont) },
                        modifier = Modifier.fillMaxWidth(),
                        shape = RoundedCornerShape(25.dp),
                        colors = outlinedTextFieldColors(),
                        readOnly = true,
                        trailingIcon = {
                            IconButton(onClick = { showDatePicker = true }) {
                                Icon(Icons.Filled.CalendarToday, contentDescription = "Select date", tint = Color.White)
                            }
                        }
                    )

                    OutlinedTextField(
                        value = email,
                        onValueChange = { email = it },
                        label = { Text("Correo electrónico", color = Color.White, fontFamily = happyMonkeyFont) },
                        modifier = Modifier.fillMaxWidth(),
                        shape = RoundedCornerShape(25.dp),
                        colors = outlinedTextFieldColors()
                    )

                    OutlinedTextField(
                        value = username,
                        onValueChange = { username = it },
                        label = { Text("Usuario", color = Color.White, fontFamily = happyMonkeyFont) },
                        modifier = Modifier.fillMaxWidth(),
                        shape = RoundedCornerShape(25.dp),
                        colors = outlinedTextFieldColors()
                    )

                    OutlinedTextField(
                        value = password,
                        onValueChange = { password = it },
                        label = { Text("Contraseña", color = Color.White, fontFamily = happyMonkeyFont) },
                        modifier = Modifier.fillMaxWidth(),
                        shape = RoundedCornerShape(25.dp),
                        colors = outlinedTextFieldColors(),
                        visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                        trailingIcon = {
                            IconButton(onClick = { passwordVisible = !passwordVisible }) {
                                Icon(
                                    if (passwordVisible) Icons.Filled.Visibility else Icons.Filled.VisibilityOff,
                                    contentDescription = if (passwordVisible) "Hide password" else "Show password",
                                    tint = Color.White
                                )
                            }
                        }
                    )

                    OutlinedTextField(
                        value = password,
                        onValueChange = { password = it },
                        label = { Text("Confirmar Contraseña", color = Color.White, fontFamily = happyMonkeyFont) },
                        modifier = Modifier.fillMaxWidth(),
                        shape = RoundedCornerShape(25.dp),
                        colors = outlinedTextFieldColors(),
                        visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                        trailingIcon = {
                            IconButton(onClick = { passwordVisible = !passwordVisible }) {
                                Icon(
                                    if (passwordVisible) Icons.Filled.Visibility else Icons.Filled.VisibilityOff,
                                    contentDescription = if (passwordVisible) "Hide confirmatepassword" else "Show confirmatepassword",
                                    tint = Color.White
                                )
                            }
                        }
                    )

                    Button(
                        onClick = { navController.navigate(NavScreen.TermsScreen.name) },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(screenHeight * 0.07f)
                            .shadow(8.dp, shape = RoundedCornerShape(25.dp)),
                        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFEF476F))
                    ) {
                        Text(
                            text = "Registrarme",
                            fontFamily = happyMonkeyFont,
                            fontSize = (screenWidth.value * 0.05f).sp
                        )
                    }

                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "Ya tienes cuenta?",
                            fontFamily = happyMonkeyFont,
                            color = Color.White,
                            fontSize = (screenWidth.value * 0.04f).sp
                        )
                        Spacer(modifier = Modifier.width(4.dp))
                        Text(
                            text = "Inicia Sesión",
                            fontFamily = happyMonkeyFont,
                            color = Color(0xFFFFD166),
                            fontSize = (screenWidth.value * 0.04f).sp,
                            modifier = Modifier.clickable { navController.navigate(NavScreen.LoginScreen.name) }
                        )
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

    if (showDatePicker) {
        val datePickerState = rememberDatePickerState()
        DatePickerDialog(
            onDismissRequest = { showDatePicker = false },
            confirmButton = {
                TextButton(onClick = {
                    datePickerState.selectedDateMillis?.let {
                        birthdate = dateFormatter.format(Date(it))
                    }
                    showDatePicker = false
                }) {
                    Text("OK")
                }
            },
            dismissButton = {
                TextButton(onClick = { showDatePicker = false }) {
                    Text("Cancel")
                }
            }
        ) {
            DatePicker(state = datePickerState)
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun outlinedTextFieldColors() = TextFieldDefaults.outlinedTextFieldColors(
    focusedBorderColor = Color.White,
    unfocusedBorderColor = Color.White,
    cursorColor = Color.White,
)

@Preview(showBackground = true)
@Composable
fun RegisterScreenPreview() {
    Wooperland_enserioTheme {
        val navController = rememberNavController() // NavController para la preview
        RegisterScreen(navController = navController)
    }
}
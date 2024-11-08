package com.example.wooperland_enserio.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Backspace
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.wooperland_enserio.R
import com.example.wooperland_enserio.navigation.NavScreen

val happyMonkeyFont = FontFamily(Font(R.font.happy_monkey))

@Composable
fun ChangePlayerPasswordScreen(navController: NavController) {
    var pin by remember { mutableStateOf(listOf("", "", "", "")) }
    var currentIndex by remember { mutableStateOf(0) }

    val mainColor = Color(0xFFB43654)
    val darkPink = Color(0xFF98223E)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(mainColor)
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Perfil del padre",
            color = Color.White,
            fontSize = 28.sp,
            fontFamily = happyMonkeyFont,
            modifier = Modifier.padding(bottom = 24.dp)
        )

        Image(
            painter = painterResource(id = R.drawable.wooper_father),
            contentDescription = "Wooper Father",
            modifier = Modifier
                .size(200.dp)
                .padding(bottom = 24.dp)
        )

        Text(
            text = "Para acceder a esta información pon el pin que ingresaste cuando hiciste el registro",
            color = Color.White,
            fontSize = 18.sp,
            fontFamily = happyMonkeyFont,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(bottom = 24.dp)
        )

        // PIN inputs
        Row(
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier.padding(bottom = 24.dp)
        ) {
            pin.forEachIndexed { index, digit ->
                PinInput(value = digit)
            }
        }

        // Botón de borrar
        IconButton(
            onClick = {
                if (currentIndex > 0) {
                    currentIndex--
                    pin = pin.toMutableList().apply { this[currentIndex] = "" }
                }
            },
            modifier = Modifier
                .size(48.dp)
                .background(darkPink, CircleShape)
        ) {
            Icon(
                imageVector = Icons.Default.Backspace,
                contentDescription = "Borrar",
                tint = Color.White
            )
        }

        Spacer(modifier = Modifier.weight(1f))

        // Teclado numérico
        Column(
            verticalArrangement = Arrangement.spacedBy(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            (1..9 step 3).forEach { rowStart ->
                Row(
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    (rowStart..minOf(rowStart + 2, 9)).forEach { number ->
                        NumberButton(number = number) {
                            if (currentIndex < 4) {
                                pin = pin.toMutableList().apply { this[currentIndex] = number.toString() }
                                currentIndex++
                            }
                        }
                    }
                }
            }
            Row {
                NumberButton(number = 0) {
                    if (currentIndex < 4) {
                        pin = pin.toMutableList().apply { this[currentIndex] = "0" }
                        currentIndex++
                    }
                }
            }
        }

        Button(
            onClick = {
                if (pin.all { it.isNotEmpty() }) {
                    navController.navigate(NavScreen.EdithFatherScreen.name)
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 16.dp),
            colors = ButtonDefaults.buttonColors(containerColor = darkPink),
            shape = RoundedCornerShape(8.dp)
        ) {
            Text(
                text = "Ingresar",
                fontFamily = happyMonkeyFont,
                fontSize = 18.sp
            )
        }
    }
}

@Composable
fun PinInput(value: String) {
    Box(
        modifier = Modifier
            .size(56.dp)
            .background(Color(0xFF98223E), RoundedCornerShape(8.dp)),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = value,
            fontFamily = happyMonkeyFont,
            fontSize = 24.sp,
            color = Color.White
        )
    }
}

@Composable
fun NumberButton(
    number: Int,
    onClick: () -> Unit
) {
    Button(
        onClick = onClick,
        modifier = Modifier.size(64.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color(0xFF98223E)
        ),
        shape = CircleShape
    ) {
        Text(
            text = number.toString(),
            fontFamily = happyMonkeyFont,
            fontSize = 24.sp
        )
    }
}
package com.example.wooperland_enserio.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Backspace
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.wooperland_enserio.R
import com.example.wooperland_enserio.navigation.NavScreen

val happyMonkeyFont = FontFamily(Font(R.font.happy_monkey))

@Composable
fun ChangePlayerPasswordScreen(navController: NavController) {
    val configuration = LocalConfiguration.current
    val screenWidth = configuration.screenWidthDp.dp
    val screenHeight = configuration.screenHeightDp.dp

    var pin by remember { mutableStateOf(listOf("", "", "", "")) }
    var currentIndex by remember { mutableStateOf(0) }

    val mainColor = Color(0xFFB43654)
    val darkPink = Color(0xFF98223E)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(mainColor)
            .verticalScroll(rememberScrollState())
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Perfil del padre",
            color = Color.White,
            fontSize = (screenWidth.value * 0.07f).sp,
            fontFamily = happyMonkeyFont,
            modifier = Modifier.padding(bottom = screenHeight * 0.03f)
        )

        Image(
            painter = painterResource(id = R.drawable.wooper_father),
            contentDescription = "Wooper Father",
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .size(screenWidth * 0.4f)
                .padding(bottom = screenHeight * 0.03f)
        )

        Text(
            text = "Para acceder a esta información pon el pin que ingresaste cuando hiciste el registro",
            color = Color.White,
            fontSize = (screenWidth.value * 0.04f).sp,
            fontFamily = happyMonkeyFont,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(bottom = screenHeight * 0.03f)
        )

        // PIN inputs
        Row(
            horizontalArrangement = Arrangement.spacedBy(screenWidth * 0.02f),
            modifier = Modifier.padding(bottom = screenHeight * 0.03f)
        ) {
            pin.forEachIndexed { index, digit ->
                PinInput(value = digit, size = screenWidth * 0.12f)
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
                .size(screenWidth * 0.12f)
                .background(darkPink, CircleShape)
        ) {
            Icon(
                imageVector = Icons.Default.Backspace,
                contentDescription = "Borrar",
                tint = Color.White
            )
        }

        Spacer(modifier = Modifier.height(screenHeight * 0.02f))

        // Teclado numérico
        Column(
            verticalArrangement = Arrangement.spacedBy(screenHeight * 0.02f),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            (1..9 step 3).forEach { rowStart ->
                Row(
                    horizontalArrangement = Arrangement.spacedBy(screenWidth * 0.04f)
                ) {
                    (rowStart..minOf(rowStart + 2, 9)).forEach { number ->
                        NumberButton(number = number, size = screenWidth * 0.15f) {
                            if (currentIndex < 4) {
                                pin = pin.toMutableList().apply { this[currentIndex] = number.toString() }
                                currentIndex++
                            }
                        }
                    }
                }
            }
            Row {
                NumberButton(number = 0, size = screenWidth * 0.15f) {
                    if (currentIndex < 4) {
                        pin = pin.toMutableList().apply { this[currentIndex] = "0" }
                        currentIndex++
                    }
                }
            }
        }

        Spacer(modifier = Modifier.height(screenHeight * 0.02f))

        Button(
            onClick = {
                if (pin.all { it.isNotEmpty() }) {
                    navController.navigate(NavScreen.EdithFatherScreen.name)
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(screenHeight * 0.07f),
            colors = ButtonDefaults.buttonColors(containerColor = darkPink),
            shape = RoundedCornerShape(8.dp)
        ) {
            Text(
                text = "Ingresar",
                fontFamily = happyMonkeyFont,
                fontSize = (screenWidth.value * 0.05f).sp
            )
        }
    }
}

@Composable
fun PinInput(value: String, size: Dp) {
    Box(
        modifier = Modifier
            .size(size)
            .background(Color(0xFF98223E), RoundedCornerShape(8.dp)),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = value,
            fontFamily = happyMonkeyFont,
            fontSize = (size.value * 0.4f).sp,
            color = Color.White
        )
    }
}

@Composable
fun NumberButton(
    number: Int,
    size: Dp,
    onClick: () -> Unit
) {
    Button(
        onClick = onClick,
        modifier = Modifier.size(size),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color(0xFF98223E)
        ),
        shape = CircleShape
    ) {
        Text(
            text = number.toString(),
            fontFamily = happyMonkeyFont,
            fontSize = (size.value * 0.4f).sp
        )
    }
}
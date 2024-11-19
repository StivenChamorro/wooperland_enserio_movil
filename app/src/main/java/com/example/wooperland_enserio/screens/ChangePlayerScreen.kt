package com.example.wooperland_enserio.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
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
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.wooperland_enserio.R

@Composable
fun ChangePlayerScreen(navController: NavController) {
    // Colors
    val mainColor = Color(0xFFB43654)
    val secondaryColor = Color(0xFF98223E)
    val textColor = Color.White

    // Font
    val happyMonkeyFont = FontFamily(Font(R.font.happy_monkey))

    // State
    var nickname by remember { mutableStateOf("") }
    var showError by remember { mutableStateOf(false) }

    // Screen dimensions for responsive design
    val configuration = LocalConfiguration.current
    val screenHeight = configuration.screenHeightDp.dp
    val screenWidth = configuration.screenWidthDp.dp

    // Scroll state
    val scrollState = rememberScrollState()

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(mainColor)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(scrollState)
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Text(
                text = "Cambiar de Jugador",
                color = textColor,
                fontSize = (screenWidth.value * 0.06f).sp,
                fontFamily = happyMonkeyFont,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(top = screenHeight * 0.02f)
            )

            Text(
                text = "Estas a punto de cambiar de\ncuenta de jugador",
                color = textColor,
                fontSize = (screenWidth.value * 0.04f).sp,
                fontFamily = happyMonkeyFont,
                textAlign = TextAlign.Center
            )

            Image(
                painter = painterResource(id = R.drawable.changeplayer),
                contentDescription = "Wooper Character",
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .size(screenWidth * 0.4f)
                    .padding(vertical = screenHeight * 0.02f)
            )

            Text(
                text = "Ingresa el nickname de la cuenta a la que\nquieres acceder",
                color = textColor,
                fontSize = (screenWidth.value * 0.04f).sp,
                fontFamily = happyMonkeyFont,
                textAlign = TextAlign.Center
            )

            OutlinedTextField(
                value = nickname,
                onValueChange = {
                    nickname = it
                    showError = false
                },
                label = {
                    Text(
                        "Aquí",
                        color = textColor,
                        fontFamily = happyMonkeyFont
                    )
                },
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = textColor,
                    unfocusedBorderColor = textColor,
                    focusedTextColor = textColor,
                    unfocusedTextColor = textColor
                ),
                shape = RoundedCornerShape(8.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = screenHeight * 0.02f),
                keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
                singleLine = true
            )

            if (showError) {
                Text(
                    text = "Este perfil no existe",
                    color = Color.Black,
                    fontSize = (screenWidth.value * 0.035f).sp,
                    fontFamily = happyMonkeyFont,
                    modifier = Modifier.padding(vertical = 8.dp)
                )
            }

            Spacer(modifier = Modifier.weight(1f))

            Button(
                onClick = {
                    // TODO: Implement API call to check if user exists
                    /*
                    viewModelScope.launch {
                        try {
                            val userExists = userRepository.checkUserExists(nickname)
                            if (!userExists) {
                                showError = true
                            } else {
                                // Navigate to next screen
                            }
                        } catch (e: Exception) {
                            showError = true
                        }
                    }
                    */
                    showError = true // Temporary implementation
                },
                enabled = nickname.isNotEmpty(),
                colors = ButtonDefaults.buttonColors(
                    containerColor = secondaryColor,
                    disabledContainerColor = secondaryColor.copy(alpha = 0.5f)
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp),
                shape = RoundedCornerShape(8.dp)
            ) {
                Text(
                    text = "Cambiar",
                    color = textColor,
                    fontSize = (screenWidth.value * 0.045f).sp,
                    fontFamily = happyMonkeyFont
                )
            }
        }
    }
}
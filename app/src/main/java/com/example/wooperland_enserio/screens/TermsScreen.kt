package com.example.wooperland_enserio.screens

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.wooperland_enserio.R
import com.example.wooperland_enserio.navigation.NavScreen
import com.example.wooperland_enserio.ui.theme.Wooperland_enserioTheme

@Composable
fun TermsScreen(navController: NavController) {
    val configuration = LocalConfiguration.current
    val orientation = configuration.orientation
    var isChecked by remember { mutableStateOf(false) }
    val scrollState = rememberScrollState()

    val gradient = Brush.verticalGradient(
        colors = listOf(
            Color(0xFFFFD166), // Amarillo claro
            Color(0xFFB43654)  // Rosa oscuro
        )
    )

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(gradient)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(id = R.drawable.image4_4153158),
                    contentDescription = null,
                    contentScale = ContentScale.FillBounds,
                    modifier = Modifier
                        .size(180.dp, 40.dp)
                        .padding(top = 16.dp)
                )

                Spacer(modifier = Modifier.height(24.dp))

                Text(
                    text = "Acepta nuestros términos y condiciones",
                    fontFamily = FontFamily(Font(R.font.happy_monkey)),
                    color = Color.White,
                    fontSize = 20.sp,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(modifier = Modifier.height(24.dp))

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color.White.copy(alpha = 0.3f), shape = RoundedCornerShape(25.dp))
                        .border(
                            width = 1.dp,
                            color = Color.White,
                            shape = RoundedCornerShape(25.dp)
                        )
                        .padding(20.dp)
                ) {
                    Column {
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(if (orientation == Configuration.ORIENTATION_LANDSCAPE) 200.dp else 400.dp)
                                .border(
                                    width = 1.dp,
                                    color = Color.White,
                                    shape = RoundedCornerShape(25.dp)
                                )
                                .padding(16.dp)
                                .verticalScroll(scrollState)
                        ) {
                            Text(
                                text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum." +
                                        "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.",
                                color = Color.White,
                                fontSize = 16.sp,
                                fontFamily = FontFamily(Font(R.font.happy_monkey))
                            )
                        }

                        Spacer(modifier = Modifier.height(16.dp))

                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.Start,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Checkbox(
                                checked = isChecked,
                                onCheckedChange = { isChecked = it },
                                colors = CheckboxDefaults.colors(
                                    checkedColor = Color(0xFFEF476F),
                                    uncheckedColor = Color.White,
                                    checkmarkColor = Color.White
                                )
                            )
                            Spacer(modifier = Modifier.width(8.dp))
                            Text(
                                text = "Acepta nuestros términos y condiciones",
                                fontSize = 14.sp,
                                color = Color.White,
                                fontFamily = FontFamily(Font(R.font.happy_monkey))
                            )
                        }

                        Spacer(modifier = Modifier.height(16.dp))

                        Button(
                            onClick = { navController.navigate(NavScreen.AddChildScreen.name) },
                            enabled = isChecked,
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(50.dp)
                                .shadow(8.dp, shape = RoundedCornerShape(25.dp)),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = if (isChecked) Color(0xFFEF476F) else Color(0xFF666666),
                                disabledContainerColor = Color(0xFF666666)
                            )
                        ) {
                            Text(
                                text = "Continuar",
                                fontFamily = FontFamily(Font(R.font.happy_monkey)),
                                fontSize = 18.sp,
                                color = Color.White
                            )
                        }
                    }
                }
            }

            Spacer(modifier = Modifier.weight(1f))

            Text(
                text = "©Wooperland 2024",
                fontFamily = FontFamily(Font(R.font.happy_monkey)),
                color = Color.White,
                fontSize = 14.sp,
                modifier = Modifier.padding(bottom = 16.dp)
            )
        }
    }
}


@Preview(showBackground = true, widthDp = 640, heightDp = 360)
@Composable
fun TermsScreenPreview() {
    Wooperland_enserioTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            TermsScreen(rememberNavController())
        }
    }
}
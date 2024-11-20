package com.example.wooperland_enserio.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
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
import com.example.wooperland_enserio.navigation.NavScreen
import com.example.wooperland_enserio.ui.theme.Wooperland_enserioTheme

@SuppressLint("InvalidColorHexValue")
@Composable
fun HomeScreen(navController: NavController) {
    val configuration = LocalConfiguration.current
    val screenWidth = configuration.screenWidthDp.dp
    val screenHeight = configuration.screenHeightDp.dp

    val gradient2 = Brush.verticalGradient(
        colors = listOf(
            Color(0xFFFFD166),
            Color(0xFFEF476F)
        )
    )

    val gradient = Brush.verticalGradient(
        colors = listOf(
            Color(0xFFFFFFFF).copy(alpha = 0.5f),
            Color(0xFFB43654).copy(alpha = 0.5f),
        )
    )

    val customFont = FontFamily(Font(R.font.press_start_2p))
    val customFont2 = FontFamily(Font(R.font.happy_monkey))

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(gradient2)
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Header
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(screenHeight * 0.15f)
                .background(Color.White)
        ) {
            Image(
                painter = painterResource(id = R.drawable.welcome),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )
        }

        // Main content
        Box(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            contentAlignment = Alignment.TopCenter
        ) {
            Column(
                modifier = Modifier
                    .background(gradient, shape = RoundedCornerShape(25.dp))
                    .padding(16.dp)
            ) {
                Text(
                    text = "Hola de nuevo Nick",
                    color = Color(0xFFEF476F),
                    fontFamily = customFont,
                    fontSize = (screenWidth.value * 0.06f).sp,
                    style = TextStyle(
                        shadow = Shadow(
                            color = Color.Black,
                            offset = Offset(4f, 4f),
                        )
                    ),
                    textAlign = TextAlign.Center,
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(modifier = Modifier.height(20.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.welcome2),
                        contentDescription = null,
                        contentScale = ContentScale.Fit,
                        modifier = Modifier
                            .weight(1f)
                            .height(screenHeight * 0.2f)
                    )
                    Column(
                        modifier = Modifier
                            .weight(1f)
                            .fillMaxHeight(), // Llena todo el espacio disponible verticalmente
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center // Centra los elementos verticalmente
                    ) {
                        Text(
                            text = "¿Estas listo para aprender?",
                            color = Color(0xFFEF476F),
                            fontFamily = customFont,
                            fontSize = (screenWidth.value * 0.04f).sp,
                            style = TextStyle(
                                shadow = Shadow(
                                    color = Color.Black,
                                    offset = Offset(4f, 4f),
                                )
                            ),
                            textAlign = TextAlign.Center
                        )

                        Spacer(modifier = Modifier.height(16.dp)) // Espacio entre el texto y el botón

                        Button(
                            onClick = { /*TODO*/ },
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(48.dp)
                                .shadow(8.dp, shape = RoundedCornerShape(25.dp))
                                .border(
                                    width = 1.dp,
                                    color = Color.White,
                                    shape = RoundedCornerShape(25.dp)
                                ),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Color(0xFFFFFFFF).copy(alpha = 0.5f)
                            )
                        ) {
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.Center,
                                verticalAlignment = Alignment.CenterVertically,
                            ) {
                                Text(
                                    text = "JUGAR",
                                    color = Color(0xFFEF476F),
                                    fontFamily = customFont,
                                    fontSize = (screenWidth.value * 0.03f).sp,
                                    style = TextStyle(
                                        shadow = Shadow(
                                            color = Color.Black,
                                            offset = Offset(4f, 4f),
                                        )
                                    )
                                )

                                Spacer(modifier = Modifier.width(5.dp))

                                Image(
                                    painter = painterResource(id = R.drawable.btnplay),
                                    contentDescription = null,
                                    contentScale = ContentScale.Fit,
                                    modifier = Modifier.size(24.dp)
                                )
                            }
                        }
                    }
                }
            }
        }

        Spacer(modifier = Modifier.height(30.dp))

        // Subjects section
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
        ) {
            Text(
                text = "Nuestros temas",
                color = Color.Black,
                fontFamily = customFont2,
                fontSize = (screenWidth.value * 0.05f).sp,
                modifier = Modifier.padding(bottom = 16.dp)
            )

            LazyRow(
                horizontalArrangement = Arrangement.spacedBy(15.dp)
            ) {
                items(3) {
                    SubjectCard(
                        navController,
                        modifier = Modifier
                            .width(screenWidth * 0.8f)
                            .height(screenHeight * 0.2f)
                    )
                }
            }
        }
    }
}

@Composable
fun SubjectCard(
    navController: NavController,
    modifier: Modifier = Modifier) {
    val customFont2 = FontFamily(Font(R.font.happy_monkey))

    Card(
        onClick = {navController.navigate(NavScreen.LevelPreviewScreen.name)},
        modifier = modifier,
        shape = RoundedCornerShape(16.dp)
    ) {
        Box(
            modifier = Modifier.fillMaxSize()
        ) {
            Image(
                painter = painterResource(id = R.drawable.math),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "Matematicas",
                    color = Color.White,
                    fontFamily = customFont2,
                    fontSize = 24.sp,
                )

                Text(
                    text = "Descripción de la materia que abarca conceptos básicos y avanzados.",
                    color = Color.White,
                    fontFamily = customFont2,
                    fontSize = 14.sp,
                )

                Row(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Spacer(modifier = Modifier.weight(1f))
                    Text(
                        text = "Ir >",
                        color = Color.White,
                        fontFamily = customFont2,
                        fontSize = 16.sp,
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    Wooperland_enserioTheme {
        val navController = rememberNavController()
        HomeScreen(navController = navController)
    }
}
package com.example.wooperland_enserio.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.wooperland_enserio.R
import com.example.wooperland_enserio.ui.theme.Wooperland_enserioTheme

@SuppressLint("InvalidColorHexValue")
@Composable
fun HomeScreen() {
    val gradient = Brush.verticalGradient(
        colors = listOf(
            Color(0xFFFFFFFF).copy(alpha = 0.5f), // Amarillo claro con opacidad del 80%
            Color(0xFFB43654).copy(alpha = 0.5f)  // Rosa oscuro con opacidad del 60%

        )
    )

    //variable para la fuente
    val customFont = FontFamily(Font(R.font.press_start_2p))
    val customFont2 = FontFamily(Font(R.font.happy_monkey))

    //estado del scroll
    val scrollState = rememberScrollState()

    // Aquí va el contenido de la pantalla
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color(0xFFFFD166)),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row (
            modifier = Modifier
                .background(color = Color(0xFFB43654))
                .fillMaxWidth()
                .padding(12.dp),
            verticalAlignment = Alignment.CenterVertically, // Alinea verticalmente
            horizontalArrangement = Arrangement.SpaceBetween// Espacio entre los inputs

        ){
            Row (
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(10.dp, Alignment.CenterHorizontally)

            ){
                Image(
                    painter = painterResource(id = R.drawable.logo),
                    contentDescription = null,
                    contentScale = ContentScale.FillBounds,
                    modifier = Modifier
                        .size(40.dp, 40.dp)
                )

                Image(
                    painter = painterResource(id = R.drawable.image4_4153158),
                    contentDescription = null,
                    contentScale = ContentScale.FillBounds,
                    modifier = Modifier
                        .size(100.dp, 15.dp)
                )
            }


            Image(
                painter = painterResource(id = R.drawable.profile),
                contentDescription = null,
                contentScale = ContentScale.FillBounds,
                modifier = Modifier
                    .size(40.dp, 40.dp)
                    .clip(CircleShape) // Hace la imagen circular
            )
        }
        Row(
            modifier = Modifier
                .background(color = Color.White)
                .fillMaxWidth() // El Row ocupa todo el ancho disponible
                .height(120.dp) // Define una altura fija
        ) {
            Image(
                painter = painterResource(id = R.drawable.welcome),
                contentDescription = null,
                contentScale = ContentScale.FillBounds, // Ajusta la imagen al contenedor sin deformarla
                modifier = Modifier
                    .fillMaxWidth() // La imagen ocupará todo el ancho del Row
                    .fillMaxHeight() // La imagen ocupará toda la altura del Row
            )
        }

        Box(
            modifier = Modifier
                .padding(16.dp),
            contentAlignment = Alignment.TopCenter // Alinea al centro horizontalmente, pero arriba

        ) {
            Column(
                modifier = Modifier
                    .background(gradient, shape = RoundedCornerShape(25.dp))
                    .padding(16.dp) // Espaciado interno del Box
            ) {
                Text(
                    text = "Hola de nuevo Nick",
                    color = Color(0xFFEF476F),
                    fontFamily = customFont,
                    fontSize = 24.sp, // Tamaño de la fuente
                    style = TextStyle(
                        shadow = Shadow(
                            color = Color.Black, // Color de la sombra
                            offset = Offset(4f, 4f), // Desplazamiento de la sombra
                        )
                    )
                )

                Spacer(modifier = Modifier.height(20.dp))

                Row ( modifier = Modifier

                    .fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(16.dp)
                ){
                    Column {
                        Image(
                            painter = painterResource(id = R.drawable.welcome2),
                            contentDescription = null,
                            contentScale = ContentScale.FillBounds, // Ajusta la imagen al contenedor sin deformarla
                            modifier = Modifier
                                .height(200.dp) // La imagen ocupará todo el ancho del Row
                                .width(180.dp) // La imagen ocupará toda la altura del Row
                        )
                    }
                    Column (
                        modifier = Modifier, 
                        horizontalAlignment = Alignment.CenterHorizontally, // Centra los hijos horizontalmente
                        verticalArrangement = Arrangement.spacedBy(30.dp, Alignment.CenterVertically)

                    ){
                        Text(
                            text = "¿Estas listo para aprender?",
                            color = Color(0xFFEF476F),
                            fontFamily = customFont,
                            fontSize = 24.sp, // Tamaño de la fuente
                            style = TextStyle(
                                shadow = Shadow(
                                    color = Color.Black, // Color de la sombra
                                    offset = Offset(4f, 4f), // Desplazamiento de la sombra
                                )
                            ),
                            textAlign = TextAlign.Center
                        )

                        Button(
                            onClick = { /*TODO*/ },
                            modifier = Modifier
                                .fillMaxWidth(0.6f)
                                .height(48.dp)
                                .shadow(8.dp, shape = RoundedCornerShape(25.dp))
                                .border(
                                    width = 1.dp,
                                    color = Color.White,
                                    shape = RoundedCornerShape(25.dp)
                                ),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Color(0xFFFFFFFF).copy(alpha = 0.5f) // Color de fondo
                            )
                        ) {
                            Row(
                                modifier = Modifier.padding(1.dp), // Padding interno del botón
                                horizontalArrangement = Arrangement.Center, // Centra horizontalmente
                                verticalAlignment = Alignment.CenterVertically, // Centra verticalmente
                            ) {
                                Text(
                                    text = "JUGAR",
                                    color = Color(0xFFEF476F),
                                    fontFamily = customFont,
                                    fontSize = 15.sp, // Tamaño de la fuente
                                    style = TextStyle(
                                        shadow = Shadow(
                                            color = Color.Black, // Color de la sombra
                                            offset = Offset(4f, 4f), // Desplazamiento de la sombra
                                        )
                                    )
                                )

                                Spacer(modifier = Modifier.width(5.dp)) // Espacio entre el texto y la imagen

                                Image(
                                    painter = painterResource(id = R.drawable.btnplay),
                                    contentDescription = null,
                                    contentScale = ContentScale.Fit, // Cambiar a Fit para mantener la proporción
                                    modifier = Modifier
                                        .size(24.dp) // Ajustar el tamaño de la imagen
                                )
                            }
                        }
                    }
                }
            }
        }
        Spacer(modifier = Modifier.height(30.dp))
        Column(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Row (
                modifier = Modifier
                    .padding(16.dp, 0.dp)
            ){
                Text(text = "Nuestros temas",
                    color = Color.Black,
                    fontFamily = customFont2,
                    fontSize = 20.sp, // Tamaño de la fuente
                )
            }
            Row (
                modifier = Modifier
                    .horizontalScroll(rememberScrollState())// Habilita scroll vertical
                    .padding(16.dp),
                horizontalArrangement = Arrangement.spacedBy(15.dp)
            ){
                Card(
                    onClick = { /*TODO*/ },
                    modifier = Modifier
                        .background(Color.White, shape = RoundedCornerShape(16.dp))
                        .height(250.dp)
                        .width(350.dp),
                    shape = RoundedCornerShape(16.dp) // Bordes redondeados

                ){
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                    ){
                        Image(
                            painter = painterResource(id = R.drawable.math),
                            contentDescription = null,
                            contentScale = ContentScale.FillBounds,
                            modifier = Modifier.fillMaxSize()
                        )

                        Column (
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(16.dp),
                            verticalArrangement = Arrangement.SpaceBetween
                        ){
                            Text(
                                text = "Matematicas",
                                color = Color.White,
                                fontFamily = customFont2,
                                fontSize = 30.sp, // Tamaño de la fuente
                                modifier = Modifier
                            )

                            Text(
                                text = "Descripción de la materia que abarca conceptos básicos y avanzados.",
                                color = Color.White,
                                fontFamily = customFont2,
                                fontSize = 18.sp, // Tamaño de la fuente de la descripción
                                        modifier = Modifier
                            )

                            Row (
                                modifier = Modifier
                                .fillMaxWidth()
                            ){
                                Spacer(modifier = Modifier.weight(1f))
                                Text(
                                    text = "Ir >",
                                    color = Color.White,
                                    fontFamily = customFont2,
                                    fontSize = 20.sp, // Tamaño de la fuente

                                )
                            }
                        }
                    }
                }

                //card2

                Card(
                    onClick = { /*TODO*/ },
                    modifier = Modifier
                        .background(Color.White, shape = RoundedCornerShape(16.dp))
                        .height(250.dp)
                        .width(350.dp),
                    shape = RoundedCornerShape(16.dp) // Bordes redondeados

                ){
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                    ){
                        Image(
                            painter = painterResource(id = R.drawable.math),
                            contentDescription = null,
                            contentScale = ContentScale.FillBounds,
                            modifier = Modifier.fillMaxSize()
                        )

                        Column (
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(16.dp),
                            verticalArrangement = Arrangement.SpaceBetween
                        ){
                            Text(
                                text = "Matematicas",
                                color = Color.White,
                                fontFamily = customFont2,
                                fontSize = 30.sp, // Tamaño de la fuente
                                modifier = Modifier
                            )

                            Text(
                                text = "Descripción de la materia que abarca conceptos básicos y avanzados.",
                                color = Color.White,
                                fontFamily = customFont2,
                                fontSize = 18.sp, // Tamaño de la fuente de la descripción
                                modifier = Modifier
                            )

                            Row (
                                modifier = Modifier
                                    .fillMaxWidth()
                            ){
                                Spacer(modifier = Modifier.weight(1f))
                                Text(
                                    text = "Ir >",
                                    color = Color.White,
                                    fontFamily = customFont2,
                                    fontSize = 20.sp, // Tamaño de la fuente

                                )
                            }
                        }
                    }
                }

                //card 3

                Card(
                    onClick = { /*TODO*/ },
                    modifier = Modifier
                        .background(Color.White, shape = RoundedCornerShape(16.dp))
                        .height(250.dp)
                        .width(350.dp),
                    shape = RoundedCornerShape(16.dp) // Bordes redondeados

                ){
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                    ){
                        Image(
                            painter = painterResource(id = R.drawable.math),
                            contentDescription = null,
                            contentScale = ContentScale.FillBounds,
                            modifier = Modifier.fillMaxSize()
                        )

                        Column (
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(16.dp),
                            verticalArrangement = Arrangement.SpaceBetween
                        ){
                            Text(
                                text = "Matematicas",
                                color = Color.White,
                                fontFamily = customFont2,
                                fontSize = 30.sp, // Tamaño de la fuente
                                modifier = Modifier
                            )

                            Text(
                                text = "Descripción de la materia que abarca conceptos básicos y avanzados.",
                                color = Color.White,
                                fontFamily = customFont2,
                                fontSize = 18.sp, // Tamaño de la fuente de la descripción
                                modifier = Modifier
                            )

                            Row (
                                modifier = Modifier
                                    .fillMaxWidth()
                            ){
                                Spacer(modifier = Modifier.weight(1f))
                                Text(
                                    text = "Ir >",
                                    color = Color.White,
                                    fontFamily = customFont2,
                                    fontSize = 20.sp, // Tamaño de la fuente

                                )
                            }
                        }
                    }
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    Wooperland_enserioTheme {
        HomeScreen()
    }
}
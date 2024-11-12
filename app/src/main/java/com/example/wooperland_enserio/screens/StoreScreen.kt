package com.example.wooperland_enserio.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.BiasAbsoluteAlignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.wooperland_enserio.R
import com.example.wooperland_enserio.ui.theme.Wooperland_enserioTheme



@Composable
fun WooperScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFFFA76E))
    ) {
        // Header Section
        HeaderSection()

        // Diamonds Display
        DiamondsSection()

        // Wooper Items Grid
        WooperGrid()
    }
}

@Composable
fun HeaderSection() {
    val scrollState = rememberScrollState()
    Box(
        modifier = Modifier.fillMaxWidth()
            .height(300.dp)
            .verticalScroll(scrollState)
    ) {
        // Imagen de fondo
        Image(
            painter = painterResource(id = R.drawable.seller),
            contentDescription = null,
            contentScale = ContentScale.FillBounds,
            modifier = Modifier.fillMaxWidth()
                .height(300.dp)
        )

        Box(
            modifier = Modifier.fillMaxWidth() // El contenedor ocupará todo el tamaño disponible
                .height(300.dp),
            contentAlignment = Alignment.Center // Centra el Box hijo dentro del padre
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
                    .padding(top = 10.dp)
                    .align(Alignment.TopStart)
            ) {
                IconButton(
                    onClick = { /* Handle back navigation */ },
                    modifier = Modifier
                        .size(34.dp)
                        .clickable { /* Acción de retroceso */ }
                        .background(
                            color = Color.White,
                            shape = RoundedCornerShape(25.dp)
                        )
                        .padding(5.dp)
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_back), // Coloca tu icono aquí
                        contentDescription = "Back",
                        modifier = Modifier.size(15.dp)
                    )
                }
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = "example: Wooper Superheroe",
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp,
                    fontFamily = FontFamily(Font(R.font.happy_monkey)),
                    color = Color.Gray,
                    modifier = Modifier.weight(1f).height(34.dp)
                        .background(color = Color.White,
                            shape = RoundedCornerShape(topStart = 25.dp, bottomStart = 25.dp))
                        .padding(5.dp)

                )
                IconButton(
                    onClick = { /* Handle back navigation */ },
                    modifier = Modifier
                        .size(34.dp)
                        .clickable { /* Acción de retroceso */ }
                        .background(
                            color = Color.White,
                            shape = RoundedCornerShape(topEnd = 25.dp , bottomEnd = 25.dp)
                        )
                        .padding(5.dp)
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_search), // Coloca tu icono aquí
                        contentDescription = "Back",
                        modifier = Modifier.size(16.dp)
                    )
                }
            }
        }
    }
}

@Composable
fun DiamondsSection() {
    Row(
        modifier = Modifier
            .width(300.dp)
            .padding(horizontal = 16.dp, vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = "Tus diamantes",
            fontFamily = FontFamily(Font(R.font.happy_monkey)),
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold
        )
        Button(
            onClick = { /* Acción de compra de diamantes */ },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFFE06C75),
                contentColor = Color.White
            ),
            shape = CircleShape,
            modifier = Modifier.height(36.dp)
        ) {
            Text(text = "1,000 💎", fontSize = 16.sp,fontFamily = FontFamily(Font(R.font.happy_monkey)),)
        }
    }
}

@Composable
fun WooperGrid() {

         // Puedes ajustar el número de filas
            Column(
                modifier = Modifier.fillMaxWidth()
                    .padding(16.dp),
               verticalArrangement = Arrangement.SpaceEvenly
            ) {
                WooperItem(
                    title = "Wooper Samurái",
                    price = "300 💎",
                    locked = true,
                    imagePainter = painterResource(id = R.drawable.wooper_samurai) // Coloca tu imagen aquí
                )
                Spacer(modifier = Modifier.height(16.dp))
                WooperItem(
                    title = "Super Wooper",
                    price = "300 💎",
                    locked = true,
                    imagePainter = painterResource(id = R.drawable.super_wooper) // Coloca tu imagen aquí
                )
            }
    Spacer(modifier = Modifier.height(16.dp))
    }


    /*
    LazyRow (modifier = Modifier.padding(16.dp)) {
        items(1) { // Puedes ajustar el número de filas
            Column(
                modifier = Modifier.fillMaxWidth()
                    .fillMaxHeight(),
                verticalArrangement = Arrangement.SpaceEvenly
            ) {
                WooperItem(
                    title = " Dragon Wooper",
                    price = "300 💎",
                    locked = true,
                    imagePainter = painterResource(id = R.drawable.dragon_wooper) // Coloca tu imagen aquí
                )
                WooperItem(
                    title = "Wooper Samurai",
                    price = "300 💎",
                    locked = true,
                    imagePainter = painterResource(id = R.drawable.wooper_samurai) // Coloca tu imagen aquí
                )
            }
            Spacer(modifier = Modifier.height(16.dp))
        }
    }
    LazyColumn (modifier = Modifier.padding(16.dp)) {
        items(1) { // Puedes ajustar el número de filas
            Row(
                modifier = Modifier.fillMaxWidth()
                    .fillMaxHeight(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                WooperItem(
                    title = "Super Wooper",
                    price = "300 💎",
                    locked = true,
                    imagePainter = painterResource(id = R.drawable.super_wooper) // Coloca tu imagen aquí
                )
                WooperItem(
                    title = "esquimal wooper",
                    price = "300 💎",
                    locked = true,
                    imagePainter = painterResource(id = R.drawable.esquimal_wooper) // Coloca tu imagen aquí
                )

            }
            Spacer(modifier = Modifier.height(16.dp))
        }
    }
    LazyColumn (modifier = Modifier.padding(16.dp)) {
        items(1) { // Puedes ajustar el número de filas
            Row(
                modifier = Modifier.fillMaxWidth()
                    .fillMaxHeight(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                WooperItem(
                    title = "Hallo Wooper",
                    price = "300 💎",
                    locked = true,
                    imagePainter = painterResource(id = R.drawable.hallo_wooper) // Coloca tu imagen aquí
                )
                WooperItem(
                    title = "fr1 Wooper",
                    price = "300 💎",
                    locked = true,
                    imagePainter = painterResource(id = R.drawable.f1_wooper) // Coloca tu imagen aquí
                )
            }
            Spacer(modifier = Modifier.height(16.dp))
        }
    }
    LazyColumn (modifier = Modifier.padding(16.dp)) {
        items(1) { // Puedes ajustar el número de filas
            Row(
                modifier = Modifier.fillMaxWidth()
                    .fillMaxHeight(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                WooperItem(
                    title = "Bombera Wooper",
                    price = "300 💎",
                    locked = true,
                    imagePainter = painterResource(id = R.drawable.bombero_wooper) // Coloca tu imagen aquí
                )
                WooperItem(
                    title = "Fut Wooper",
                    price = "300 💎",
                    locked = true,
                    imagePainter = painterResource(id = R.drawable.fut_wooper) // Coloca tu imagen aquí
                )
            }
            Spacer(modifier = Modifier.height(16.dp))
        }
    }
    LazyColumn (modifier = Modifier.padding(16.dp)) {
        items(1) { // Puedes ajustar el número de filas
            Row(
                modifier = Modifier.fillMaxWidth()
                    .fillMaxHeight(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                WooperItem(
                    title = "Dead Wooper",
                    price = "300 💎",
                    locked = true,
                    imagePainter = painterResource(id = R.drawable.dead_wooper) // Coloca tu imagen aquí
                )
                WooperItem(
                    title = "Mona Wooper",
                    price = "300 💎",
                    locked = true,
                    imagePainter = painterResource(id = R.drawable.trabajadora_x_wooper) // Coloca tu imagen aquí
                )
            }
            Spacer(modifier = Modifier.height(16.dp))
        }
    }
    LazyColumn (modifier = Modifier.padding(16.dp)) {
        items(1) { // Puedes ajustar el número de filas
            Row(
                modifier = Modifier.fillMaxWidth()
                    .fillMaxHeight(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                WooperItem(
                    title = "Astronauta Wooper",
                    price = "300 💎",
                    locked = true,
                    imagePainter = painterResource(id = R.drawable.astronauta_wooper) // Coloca tu imagen aquí
                )
                WooperItem(
                    title = "Wooper campeon",
                    price = "300 💎",
                    locked = true,
                    imagePainter = painterResource(id = R.drawable.wooper_campeon) // Coloca tu imagen aquí
                )
            }
            Spacer(modifier = Modifier.height(16.dp))
        }
    }
    LazyColumn (modifier = Modifier.padding(16.dp)) {
        items(1) { // Puedes ajustar el número de filas
            Row(
                modifier = Modifier.fillMaxWidth()
                    .fillMaxHeight(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                WooperItem(
                    title = "Zhasam Wooper",
                    price = "300 💎",
                    locked = true,
                    imagePainter = painterResource(id = R.drawable.zhasam_wooper) // Coloca tu imagen aquí
                )
                WooperItem(
                    title = "Harry Wooper",
                    price = "300 💎",
                    locked = true,
                    imagePainter = painterResource(id = R.drawable.harry_wooper) // Coloca tu imagen aquí
                )
            }
            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}*/

@Composable
fun WooperItem(
    title: String,
    price: String,
    locked: Boolean,
    imagePainter: Painter
) {
    Box(
        modifier = Modifier
            .size(150.dp)
            .background(Color.White, shape = MaterialTheme.shapes.medium)

    ) {
        Image(
            painter = imagePainter,
            contentDescription = title,
            modifier = Modifier
                .fillMaxSize()
                .clickable { /* Acción al hacer clic en el elemento */ }
        )
        if (locked) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .fillMaxHeight()
                    .background(Color(0xAA000000)),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = price,
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    fontFamily = FontFamily(Font(R.font.happy_monkey)),
                    textAlign = TextAlign.Center
                )
            }
        }
        Text(
            text = title,
            fontWeight = FontWeight.Bold,
            fontFamily = FontFamily(Font(R.font.happy_monkey)),
            fontSize = 14.sp,
            color = Color.White,
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(8.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun StoreScreenPreview() {
    Wooperland_enserioTheme {
        WooperScreen()
    }
}

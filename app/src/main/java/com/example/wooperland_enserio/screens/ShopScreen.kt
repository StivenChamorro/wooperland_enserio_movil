@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.wooperland_enserio.screens

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.SearchBar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
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
fun ShopScreen() {
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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HeaderSection() {
    val scrollState = rememberScrollState()
    val ctx = LocalContext.current
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
                    .padding(top = 0.dp)
                    .align(Alignment.TopStart)
            ) {
                Spacer(modifier = Modifier.width(8.dp))
                var query by remember { mutableStateOf("") }
                var active by remember { mutableStateOf(false) }
                SearchBar(
                    query =query ,
                    onQueryChange = { query = it },
                    onSearch = {
                        Toast.makeText(ctx,query, Toast.LENGTH_LONG).show()
                        active = false
                    },
                    active = active,
                    onActiveChange = { active = it},
                    modifier = Modifier.wrapContentHeight(),
                    placeholder = {Text(text = "Example: Wooper Samurái",
                        color = Color.Gray,
                        fontFamily = FontFamily(Font(R.font.happy_monkey))
                    )},
                    trailingIcon = { IconButton(onClick = {/*TODO*/}){
                        Icon(imageVector = Icons.Default.Search,
                            contentDescription = null)
                    } }
                ){

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
    val scrollState = rememberScrollState()
    Row(
        modifier = Modifier.verticalScroll(scrollState)
            .fillMaxWidth()
            .padding(15.dp),
        horizontalArrangement = Arrangement.Center
    )
    {
        // Puedes ajustar el número de filas
        Column(
            modifier = Modifier
                .weight(1f)
                .padding(end = 0.dp),
            verticalArrangement = Arrangement.SpaceEvenly
        ) {
            WooperItem(
                title = "Wooper dragon",
                price = "300 💎",
                locked = true,
                imagePainter = painterResource(id = R.drawable.dragon_wooper) // Coloca tu imagen aquí
            )
            Spacer(modifier = Modifier.height(16.dp))
            WooperItem(
                title = "super Wooper",
                price = "300 💎",
                locked = true,
                imagePainter = painterResource(id = R.drawable.super_wooper) // Coloca tu imagen aquí
            )
            Spacer(modifier = Modifier.height(16.dp))
            WooperItem(
                title = "Fr1 Wooper",
                price = "300 💎",
                locked = true,
                imagePainter = painterResource(id = R.drawable.f1_wooper) // Coloca tu imagen aquí
            )
            Spacer(modifier = Modifier.height(16.dp))
            WooperItem(
                title = "Wooper futbolista",
                price = "300 💎",
                locked = true,
                imagePainter = painterResource(id = R.drawable.fut_wooper) // Coloca tu imagen aquí
            )
            Spacer(modifier = Modifier.height(16.dp))
            WooperItem(
                title = "Mona   Wooper",
                price = "300 💎",
                locked = true,
                imagePainter = painterResource(id = R.drawable.trabajadora_x_wooper) // Coloca tu imagen aquí
            )
            Spacer(modifier = Modifier.height(16.dp))
            WooperItem(
                title = "Wooper Futurista",
                price = "300 💎",
                locked = true,
                imagePainter = painterResource(id = R.drawable.wooper_robot) // Coloca tu imagen aquí
            )
            Spacer(modifier = Modifier.height(16.dp))
            WooperItem(
                title = "Zhasam Wooper",
                price = "300 💎",
                locked = true,
                imagePainter = painterResource(id = R.drawable.zhasam_wooper) // Coloca tu imagen aquí
            )
        }
        Spacer(modifier = Modifier.width(16.dp))
        Column(
            modifier = Modifier
                .weight(1f)
                .padding(end = 0.dp),
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
                title = "Wooper winter-soldier",
                price = "300 💎",
                locked = true,
                imagePainter = painterResource(id = R.drawable.hallo_wooper) // Coloca tu imagen aquí
            )
            Spacer(modifier = Modifier.height(16.dp))
            WooperItem(
                title = "Wooper Bombero",
                price = "300 💎",
                locked = true,
                imagePainter = painterResource(id = R.drawable.bombero_wooper) // Coloca tu imagen aquí
            )
            Spacer(modifier = Modifier.height(16.dp))
            WooperItem(
                title = "Dead wooper",
                price = "300 💎",
                locked = true,
                imagePainter = painterResource(id = R.drawable.dead_wooper) // Coloca tu imagen aquí
            )
            Spacer(modifier = Modifier.height(16.dp))
            WooperItem(
                title = "Wooper Astronauta",
                price = "300 💎",
                locked = true,
                imagePainter = painterResource(id = R.drawable.astronauta_wooper) // Coloca tu imagen aquí
            )
            Spacer(modifier = Modifier.height(16.dp))
            WooperItem(
                title = "Super Wooper",
                price = "300 💎",
                locked = true,
                imagePainter = painterResource(id = R.drawable.harry_wooper) // Coloca tu imagen aquí
            )
            Spacer(modifier = Modifier.height(16.dp))
            WooperItem(
                title = "Harry Wooper",
                price = "300 💎",
                locked = true,
                imagePainter = painterResource(id = R.drawable.wooper_campeon) // Coloca tu imagen aquí
            )
        }
        Spacer(modifier = Modifier.height(16.dp))
    }
}

@Composable
fun WooperItem(
    title: String,
    price: String,
    locked: Boolean,
    imagePainter: Painter
) {
    Box(
        modifier = Modifier
            .width(170.dp)
            .height(180.dp)
            .background(Color.White)

    ) {
        Image(
            painter = imagePainter,
            contentDescription = title,
            modifier = Modifier
                .width(170.dp)
                .height(180.dp)
                .clickable { /* Acción al hacer clic en el elemento */ }
        )
        if (locked) {
            Box(
                modifier = Modifier
                    .width(170.dp)
                    .height(180.dp)
                    .padding(1.dp)
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
fun ShopScreenPreview() {
    Wooperland_enserioTheme {
        ShopScreen()
    }
}
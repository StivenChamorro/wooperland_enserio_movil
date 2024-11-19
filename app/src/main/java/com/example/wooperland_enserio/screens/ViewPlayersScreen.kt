package com.example.wooperland_enserio.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.wooperland_enserio.R
import com.example.wooperland_enserio.ui.theme.Wooperland_enserioTheme


@Composable
fun ViewPlayerScreen() {
    val scrollState = rememberScrollState()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFFFD180))
    ) {
        // Top Bar with back button and profile
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    color = Color(0xFFFFB74D),
                    shape = RoundedCornerShape(bottomEnd = 25.dp, bottomStart = 25.dp)
                )
                .height(170.dp)
                .align(Alignment.CenterHorizontally)

        ) {
            IconButton(
                onClick = { /* Handle back navigation */ },
                modifier = Modifier.align(Alignment.CenterStart)
            ) {
                Icon(Icons.Default.ArrowBack, contentDescription = "Back")
            }
            Box(modifier = Modifier
                .width(270.dp)
                .align(Alignment.Center))
            {
                Column(modifier = Modifier.padding(10.dp)
                    .align(Alignment.CenterStart)) {
                    Image(
                        painter = painterResource(id = R.drawable.person),
                        contentDescription = "Profile Picture",
                        modifier = Modifier
                            .size(64.dp)
                            .clip(CircleShape),
                        contentScale = ContentScale.Crop
                    )
                }
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.align(Alignment.CenterEnd)
                ) {
                    Text(
                        text = "John Smith",
                        fontSize = 20.sp,
                        fontFamily = FontFamily(Font(R.font.happy_monkey)),
                        color = Color.Black
                    )
                    Text(
                        text = "johnsmith@example.com",
                        fontSize = 14.sp,
                        fontFamily = FontFamily(Font(R.font.happy_monkey)),
                        color = Color.Black
                    )
                }
            }
            Button(
                onClick = { /* Handle profile view */ },
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFF4081)),
                shape = RoundedCornerShape(20.dp),
                modifier = Modifier.padding(top = 8.dp, bottom = 8.dp)
                    .height(35.dp)
                    .align(Alignment.BottomCenter)


            ) {
                Text(
                    "Ver perfil",
                    fontFamily = FontFamily(Font(R.font.happy_monkey)),
                    color = Color.Black
                )
            }

        }

        // Player Management Buttons
        Row(
            horizontalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 16.dp)
                .height(35.dp)
        ) {
            Button(
                onClick = { /* Handle add player */ },
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFF4081)),
                shape = RoundedCornerShape(20.dp),

                ) {
                Text(
                    "Agregar Jugador",
                    fontFamily = FontFamily(Font(R.font.happy_monkey)),
                    color = Color.Black
                )

            }
            Button(
                onClick = { /* Handle remove player */ },
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFF4081)),
                shape = RoundedCornerShape(20.dp)
            ) {
                Text(
                    "Eliminar Jugador",
                    fontFamily = FontFamily(Font(R.font.happy_monkey)),
                    color = Color.Black
                )
            }
        }

        // Player List
        Column(modifier = Modifier
            .weight(1f)
            .padding(15.dp)) {
            Column(
                modifier = Modifier
                    .weight(1f)
                    .verticalScroll(scrollState)
                    .background(
                        color = Color(0xFFFFB74D),
                        shape = RoundedCornerShape(percent = 3)
                    )
                    .padding(16.dp)
            ) {
                repeat(6) {
                    PlayerCard()
                    Spacer(modifier = Modifier.height(8.dp))
                }
            }
            Spacer(modifier = Modifier.height(15.dp))
            // Logout Button
            Button(
                onClick = { /* Cerrar sesión */ },
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(percent = 15))
                    .background(Color(0xFFFFB74D)),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFFB74D)),
                contentPadding = PaddingValues(16.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.close),
                    contentDescription = "Perfil",
                    modifier = Modifier
                        .size(50.dp)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    "Cerrar sesión",
                    fontFamily = FontFamily(Font(R.font.happy_monkey)),
                    fontSize = 12.sp,
                    color = Color.Black,
                    modifier = Modifier.padding(start = 8.dp)
                )
            }
        }
    }
}

@Composable
fun PlayerCard() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(80.dp),
        shape = RoundedCornerShape(8.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFFFFBF00))
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.player_avatar),
                contentDescription = "Player Avatar",
                modifier = Modifier
                    .size(40.dp)
                    .clip(CircleShape),
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.width(8.dp))
            Column {

                Text(
                    text = "Nick",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    fontFamily = FontFamily(Font(R.font.happy_monkey)),
                    color = Color.Black)

                Text(
                    text = "Nicolas Smith Pines",
                    fontSize = 14.sp,
                    fontFamily = FontFamily(Font(R.font.happy_monkey)),
                    color = Color.Black)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ViewPlayerPreview(){
    Wooperland_enserioTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background,
        ) {
            ViewPlayerScreen()
        }
    }
}
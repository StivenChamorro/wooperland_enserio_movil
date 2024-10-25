package com.example.wooperland_enserio.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.wooperland_enserio.R
import com.example.wooperland_enserio.ui.theme.Wooperland_enserioTheme
import okhttp3.internal.cookieToString

@Composable
fun ViewPlayerScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFFFD180))
    ) {
        // Top Bar with back button and profile
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xFFFFB74D)),

        ) {
            IconButton(
                onClick = { /* Handle back navigation */ },
                modifier = Modifier.align(Alignment.CenterStart)
            ) {
                Icon(Icons.Default.ArrowBack, contentDescription = "Back")
            }

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.align(Alignment.Center)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.person),
                    contentDescription = "Profile Picture",
                    modifier = Modifier
                        .size(64.dp)
                        .clip(CircleShape),
                    contentScale = ContentScale.Crop
                )
                Text(
                    text = "John Smith",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "johnsmith@example.com",
                    fontSize = 14.sp,
                    color = Color.DarkGray
                )
                Button(
                    onClick = { /* Handle profile view */ },
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFF4081)),
                    shape = RoundedCornerShape(20.dp),
                    modifier = Modifier.padding(top = 8.dp)
                ) {
                    Text("Ver perfil")
                }
            }
        }

        // Player Management Buttons
        Row(
            horizontalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 16.dp)
        ) {
            Button(
                onClick = { /* Handle add player */ },
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFF4081)),
                shape = RoundedCornerShape(20.dp)
            ) {
                Text("Agregar Jugador")
            }
            Button(
                onClick = { /* Handle remove player */ },
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFF4081)),
                shape = RoundedCornerShape(20.dp)
            ) {
                Text("Eliminar Jugador")
            }
        }

        // Player List
        Column(
            modifier = Modifier
                .weight(1f)
                .background(
                    color = Color(0xFFDAA520),
                    shape = RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp)
                )
                .padding(16.dp)
        ) {
            repeat(6) {
                PlayerCard()
                Spacer(modifier = Modifier.height(8.dp))
            }
        }

        // Logout Button
        Button(
            onClick = { /* Handle logout */ },
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFF4081)),
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            shape = RoundedCornerShape(20.dp)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.close),
                contentDescription = "Logout",
                modifier = Modifier.size(24.dp)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text("Cerrar sesión")
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
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "Nicolas Smith Pines",
                    fontSize = 14.sp,
                    color = Color(0xFFFF4081)
                )
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
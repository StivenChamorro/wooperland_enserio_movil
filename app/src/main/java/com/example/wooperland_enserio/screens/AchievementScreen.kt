package com.example.wooperland_enserio.screens


import android.graphics.Paint.Align
import androidx.compose.runtime.Composable

import androidx.compose.ui.tooling.preview.Preview
import com.example.wooperland_enserio.ui.theme.Wooperland_enserioTheme
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.snapping.SnapPosition
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.style.TextAlign
import com.example.wooperland_enserio.R



@Composable
fun AchievementsScreen() {
    //var         iable para la fuente
    val customFont2 = FontFamily(Font(R.font.happy_monkey))

    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        Color(0xFFFFD166),
                        Color(0xFFF78D6B)
                    )
                )
            )
            .padding(16.dp)
            .verticalScroll(scrollState)
    ) {
Box(modifier = Modifier
    .fillMaxWidth()
    .height(50.dp) ){

            Spacer(modifier = Modifier.width(8.dp))

            IconButton(onClick = { /*TODO*/ }, modifier = Modifier.align(Alignment.TopStart)) {
            Icon( Icons.Default.ArrowBack, contentDescription = "Back") }

            Text(
                text = "Logros",
                fontSize = 28.sp,
                fontFamily = customFont2,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.Center)
                    .height(42.dp),
                textAlign = TextAlign.Center
            )
}
        // Encabezado de logros
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 16.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.imglogros),
                contentDescription = "Imagen de fondo",
                modifier = Modifier
                    .size(100.dp)
                    .clip(RoundedCornerShape(8.dp)),
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.width(16.dp))
            Column {

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp),
                    verticalAlignment = Alignment.CenterVertically // Alinea verticalmente al centro
                ) {
                    Text(
                        text = "Matemáticas",
                        fontFamily = customFont2,
                        fontSize = 22.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black,
                        modifier = Modifier.weight(1f) // Hace que el texto ocupe el espacio restante
                    )

                    IconButton(onClick = { /* Acción de la flecha */ }) {
                        Icon(
                            imageVector = Icons.Default.KeyboardArrowDown,
                            contentDescription = "Flecha abajo"
                        )
                    }
                }

                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = "💎 Diamantes del Jugador: 120/1200",
                    fontFamily = customFont2,
                    fontSize = 14.sp,
                    color = Color.DarkGray
                )
                Text(
                    text = "🏆 Logros Completados: 2/10",
                    fontSize = 14.sp,
                    fontFamily = customFont2,
                    color = Color.DarkGray
                )
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Lista de logros
        val achievements = listOf(
            Achievement("Super Wooper", "Completa un nivel sin equivocarte ninguna vez", R.drawable.wooperlogro, 20, true),
            Achievement("Francesco es tres veces veloz", "Completa el nivel 5 en menos de 2 minutos", R.drawable.franchescologro, 20, true),
            Achievement("Compañerismo", "Utiliza la ayuda de Wooper en un nivel", R.drawable.logrobloqueado, 20, false),
            Achievement("Compañerismo", "Utiliza la ayuda de Wooper en un nivel", R.drawable.logrobloqueado, 20, false),
            Achievement("Compañerismo", "Utiliza la ayuda de Wooper en un nivel", R.drawable.logrobloqueado, 20, false),
            Achievement("Compañerismo", "Utiliza la ayuda de Wooper en un nivel", R.drawable.logrobloqueado, 20, false),
            Achievement("Compañerismo", "Utiliza la ayuda de Wooper en un nivel", R.drawable.logrobloqueado, 20, false)
        )

        achievements.forEach { achievement ->
            AchievementItem(achievement)
            Spacer(modifier = Modifier.height(8.dp))
        }
    }
}

@Composable
fun AchievementItem(achievement: Achievement) {
    //variable para la fuente
    val customFont2 = FontFamily(Font(R.font.happy_monkey))
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .background(
                Color(0xFFFFD166),
                RoundedCornerShape(12.dp)
            )
            .padding(16.dp)
    ) {
        Image(
            painter = painterResource(id = achievement.imageRes),
            contentDescription = "Icono de logro",
            modifier = Modifier
                .size(80.dp)
                .clip(RoundedCornerShape(8.dp)),
            contentScale = ContentScale.Crop
        )
        Spacer(modifier = Modifier.width(16.dp))
        Column {
            Text(
                text = achievement.title,
                fontSize = 17.sp,
                fontFamily = customFont2,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )
            Text(
                text = achievement.description,
                fontSize = 14.sp,
                fontFamily = customFont2,
                color = Color.Gray
            )
        }
        Spacer(modifier = Modifier.weight(1f))
    }
}

// Modelo de datos de logro
data class Achievement(
    val title: String,
    val description: String,
    val imageRes: Int,
    val points: Int,
    val isUnlocked: Boolean
)



@Preview
@Composable
fun AchievementcreenPreview(){
    Wooperland_enserioTheme {
        AchievementsScreen()
    }

}

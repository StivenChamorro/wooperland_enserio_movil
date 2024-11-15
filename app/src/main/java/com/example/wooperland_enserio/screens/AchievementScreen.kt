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
import androidx.compose.foundation.border
import androidx.compose.foundation.gestures.snapping.SnapPosition
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Diamond
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.outlined.Games
import androidx.compose.material.icons.outlined.ManageAccounts
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.DarkGray
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.style.TextAlign
import androidx.navigation.NavHostController
import com.example.wooperland_enserio.R
import com.example.wooperland_enserio.navigation.NavScreen
import com.example.wooperland_enserio.ui.theme.Rosa_wooper
import androidx.navigation.compose.rememberNavController




@Composable
fun AchievementsScreen(navController: NavHostController) {
    //variable para la fuente
    val customFont2 = FontFamily(Font(R.font.happy_monkey))
    var showMenu by remember { mutableStateOf(false) }

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
                        .height(100.dp),
                    verticalAlignment = Alignment.CenterVertically // Alinea verticalmente al centro
                ) {
                    Text(
                        text = "Matemáticas",
                        fontFamily = customFont2,
                        fontSize = 30.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black,
                        modifier = Modifier.weight(1f) // Hace que el texto ocupe el espacio restante
                    )

                    IconButton(onClick = { showMenu = !showMenu }) {
                        Icon(
                            imageVector = Icons.Default.KeyboardArrowDown,
                            contentDescription = "Flecha abajo"
                        )
                    }
                    DropdownMenu(
                        expanded = showMenu,
                        onDismissRequest = { showMenu = false },
                        modifier = Modifier
                            .background(Color(0xFFFFD166))
                            .border(2.dp, Color.Transparent, RoundedCornerShape(10.dp))
                            .height(130.dp)
                            .width(280.dp)
                        )
                    {
                        Text(
                            text = "Elige un tema",
                            color = Color.Black,
                            modifier = Modifier
                                .padding(start = 10.dp),
                            fontSize = 20.sp,
                            fontFamily = FontFamily(
                                Font(R.font.happy_monkey)
                            )
                        )
                        DropdownMenuItem(
                            text = {
                                Row(
                                ) {
                                    Image(
                                        painter = painterResource(id = R.drawable.imglogros),
                                        contentDescription = null,
                                        modifier = Modifier
                                            .size(70.dp)
                                            .align(alignment = Alignment.Top)
                                    )
                                    Text(
                                        text = "MATEMATICAS",
                                        color = Color.Black,
                                        modifier = Modifier
                                            .padding(start = 10.dp)
                                            .align(alignment = Alignment.Top),
                                        fontSize = 20.sp,
                                        fontFamily = FontFamily(
                                            Font(R.font.happy_monkey)
                                        )
                                    )
                                    Row(
                                        modifier = Modifier
                                            .height(30.dp)
                                            .fillMaxHeight()
                                            .align(Alignment.Bottom)
                                    ){
                                        Image(
                                            painter = painterResource(id = R.drawable.iconcup),
                                            contentDescription = null,
                                            alignment = Alignment.CenterStart,
                                            modifier = Modifier
                                                .size(25.dp)
                                        )
                                        Text(
                                            text = "20",
                                            color = Color.Black,
                                            fontSize = 13.sp,
                                            fontFamily = FontFamily(Font(R.font.happy_monkey))
                                        )
                                    }
                                }
                            },
                            onClick = { })

                        DropdownMenuItem(
                            text = {
                                Row(
                                ) {
                                    Image(
                                        painter = painterResource(id = R.drawable.imglogros),
                                        contentDescription = null,
                                        modifier = Modifier
                                            .size(70.dp)
                                            .align(alignment = Alignment.Top)
                                    )
                                    Text(
                                        text = "MATEMATICAS",
                                        color = Color.Black,
                                        modifier = Modifier
                                            .padding(start = 10.dp)
                                            .align(alignment = Alignment.Top),
                                        fontSize = 20.sp,
                                        fontFamily = FontFamily(
                                            Font(R.font.happy_monkey)
                                        )
                                    )
                                    Row(
                                        modifier = Modifier
                                            .height(30.dp)
                                            .fillMaxHeight()
                                            .align(Alignment.Bottom)
                                    ){
                                        Image(
                                            painter = painterResource(id = R.drawable.iconcup),
                                            contentDescription = null,
                                            alignment = Alignment.CenterStart,
                                            modifier = Modifier
                                                .size(20.dp)
                                        )
                                        Text(
                                            text = "20",
                                            color = Color.Black,
                                            fontSize = 13.sp,
                                            fontFamily = FontFamily(Font(R.font.happy_monkey))
                                        )
                                    }
                                }
                            },
                            onClick = { })

                    }
                }

                Spacer(modifier = Modifier.height(4.dp))

                Row(
                    verticalAlignment = Alignment.CenterVertically, // Alinea verticalmente al centro
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.icondiamont),
                        contentDescription = null,
                        contentScale = ContentScale.Fit,
                        modifier = Modifier.size(20.dp)
                    )
                    Spacer(modifier = Modifier.width(4.dp)) // Espacio entre la imagen y el texto
                    Text(
                        text = "Diamantes del Jugador: 120/1200",
                        fontFamily = customFont2,
                        fontSize = 12.sp,
                        color = Color.DarkGray
                    )
                }

                Row(
                    verticalAlignment = Alignment.CenterVertically, // Alinea verticalmente al centro
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.iconcup),
                        contentDescription = null,
                        contentScale = ContentScale.Fit,
                        modifier = Modifier.size(20.dp)
                    )
                    Spacer(modifier = Modifier.width(4.dp)) // Espacio entre la imagen y el texto
                    Text(
                        text = "Logros Completados: 2/10",
                        fontSize = 12.sp,
                        fontFamily = customFont2,
                        color = Color.DarkGray
                    )
                }

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

        val achievementpoints = listOf(
            Image(R.drawable.icondiamont,"20"),
            Image(R.drawable.icondiamont,"20"),
            Image(R.drawable.icondiamont,"20"),
            Image(R.drawable.icondiamont,"20")
        )

        achievements.forEachIndexed { index, achievement ->
            val image = achievementpoints.getOrNull(index) ?: Image(R.drawable.icondiamont, "20")
            AchievementItem(achievement = achievement, image = image)
            Spacer(modifier = Modifier.height(8.dp))

        }
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

data class Image(
    val imagediamont: Int,
    val quantity:String
)

@Composable
fun AchievementItem(achievement: Achievement, image:Image) {

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
                color = colorResource(id = R.color.other_gray)
            )
            Row(verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .align(Alignment.End)){
            Image(
                painter = painterResource(id = image.imagediamont),
                contentDescription = "Icono de logro",
                modifier = Modifier
                    .size(18.dp)
                    .clip(RoundedCornerShape(8.dp)),
                contentScale = ContentScale.Crop
            )
                Text(
                    text = image.quantity,
                    fontSize = 14.sp,
                    fontFamily = customFont2,
                    color = colorResource(id = R.color.black)
                )
            }

        }
        Spacer(modifier = Modifier.weight(1f))
    }
}

@Preview
@Composable
fun AchievementcreenPreview(){
    val navController = rememberNavController() // Simulación del NavController
    Wooperland_enserioTheme {
        AchievementsScreen(navController = navController)
    }

}

package com.example.wooperland_enserio.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
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
import androidx.compose.material3.Shapes
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
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
fun AvatarScreen() {
    //variable para la fuente
    val customFont2 = FontFamily(Font(R.font.happy_monkey))
    var showMenu by remember { mutableStateOf(false) }
    val scrollState = rememberScrollState()
    val images = listOf(
        R.drawable.avatar1,
        R.drawable.avatar2,
        R.drawable.deadpoolwooper,
        R.drawable.avatar3,
        R.drawable.avatar4,
        R.drawable.avatar5,
        R.drawable.avatar6,
        R.drawable.avatar7,
        R.drawable.avatar1,
        R.drawable.avatar2,
        R.drawable.deadpoolwooper,
        R.drawable.avatar3,
        R.drawable.avatar4,
        R.drawable.avatar5,
        R.drawable.avatar6,
        R.drawable.avatar7,
        R.drawable.avatar1,
        R.drawable.avatar2,
        R.drawable.deadpoolwooper,
        R.drawable.avatar3,
        R.drawable.avatar4,
        R.drawable.avatar5,
        R.drawable.avatar6,
        R.drawable.avatar7,
    )

    // Variable de estado para la imagen seleccionada
    var deadpoolwooper by remember { mutableStateOf(images[0]) }

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
            .padding(5.dp)
            .verticalScroll(scrollState)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
        ) {

            Spacer(modifier = Modifier.width(8.dp))

            Text(
                text = "Avatares",
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
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .padding(vertical = 16.dp)
                .align(alignment = Alignment.CenterHorizontally)
        ) {
            // Esta imagen se reemplazará con la imagen que el usuario seleccione
            Image(
                painter = painterResource(id = deadpoolwooper),
                contentDescription = "Imagen Principal",
                modifier = Modifier
                    .size(100.dp)
                    .clip(RoundedCornerShape(9.dp)),
            )
        }
    }
    Spacer(modifier = Modifier.height(10.dp))

    // Contenedor para los avatares
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp)
            .height(600.dp)
            .padding(top = 170.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally

    ) {
        Box(
            modifier = Modifier
                .background(
                    Color(0xFFA33B54),
                    shape = RoundedCornerShape(30.dp)
                )
                .padding(16.dp)
        ) {
            Column (
                modifier = Modifier
                    .verticalScroll(scrollState)
                    .background(
                        color = Color.Transparent,
                        shape = RoundedCornerShape(50.dp)
                    )
            ){
                for (i in images.indices step 3) {
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(30.dp),
                        modifier = Modifier
                            .padding(bottom = 50.dp),
                        verticalAlignment = Alignment.Bottom,
                    ) {
                        for (j in 0..2) {
                            if (i + j < images.size) {
                                ImageItem(
                                    imageRes = images[i + j],
                                    onClick = {
                                        deadpoolwooper = images[i + j] // Cambia la imagen principal
                                    }
                                )
                            }
                        }
                    }

                }
            }
        }
    }

    // botones de aceptar y cancelar
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp)
            .padding(top = 600.dp),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Button(
            onClick = { },
            colors = ButtonDefaults.buttonColors( Color.Transparent)
        ) {
            Box(
                modifier = Modifier
                    .background(
                        color = colorResource(id = R.color.other_rose),
                        shape = RoundedCornerShape(40.dp)
                    )
                    .width(130.dp)
                    .height(40.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    "Aceptar",
                    fontFamily = customFont2,
                    color = Color.White
                )
            }
        }

        Button(
            onClick = { },
            colors = ButtonDefaults.buttonColors( Color.Transparent)
        ) {
            Box(
                modifier = Modifier
                    .background(
                        color = colorResource(id = R.color.other_rose),
                        shape = RoundedCornerShape(40.dp)
                    )
                    .width(130.dp)
                    .height(40.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    "Cancelar",
                    fontFamily = customFont2,
                    color = Color.White
                )
            }
        }
    }
}

@Composable
fun ImageItem(imageRes: Int, onClick: () -> Unit) {
    Image(
        painter = painterResource(id = imageRes),
        contentDescription = null,
        modifier = Modifier
            .size(80.dp)
            .clip(CircleShape)
            .clickable(onClick = onClick),
        contentScale = ContentScale.Crop
    )
}


@Preview
@Composable
fun AvatarPreview() {
    Wooperland_enserioTheme {
        AvatarScreen()
    }
}
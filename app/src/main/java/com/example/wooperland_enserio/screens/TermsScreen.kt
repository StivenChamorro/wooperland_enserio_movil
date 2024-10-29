package com.example.wooperland_enserio.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
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
fun TermsScreen(navController: NavController){
    val gradient = Brush.verticalGradient(
        colors = listOf(
            Color(0xFFFFD166), // Amarillo claro
            Color(0xFFB43654)  // Rosa oscuro
        )
    )
    val scrollState = rememberScrollState()
    var isChecked by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(gradient)
            .padding(16.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.image4_4153158),
            contentDescription = null,
            contentScale = ContentScale.FillBounds,
            modifier = Modifier
                .size(180.dp, 25.dp)
                .align(Alignment.CenterHorizontally)
        )
        Spacer(modifier = Modifier.height(50.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth() // Asegura que ocupe todo el ancho disponible
                .padding(16.dp), // Añade un poco de espaciado alrededor
            horizontalArrangement = Arrangement.Center, // Centra horizontalmente el contenido
            verticalAlignment = Alignment.CenterVertically // Centra verticalmente los elementos
        ) {
            Text(
                text = "Acepta nuestros términos y condiciones",
                fontFamily = FontFamily(Font(R.font.happy_monkey)),
                color = Color.White,
                fontSize = 20.sp,
                textAlign = TextAlign.Center // Asegura que el texto esté centrado si ocupa varias líneas
            )
        }

        Spacer(modifier = Modifier.height(30.dp))

        Box(
            modifier = Modifier
                .background(Color.White.copy(alpha = 0.3f), shape = RoundedCornerShape(25.dp))
                .border(
                    width = 1.dp,
                    color = Color.White,
                    shape = RoundedCornerShape(25.dp)
                )
                .padding(30.dp)
        ) {
            Column(
                modifier = Modifier.fillMaxWidth()
            ) {
                // Caja interna con texto desplazable
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(550.dp) // Altura fija
                        .border(
                            width = 1.dp,
                            color = Color.White,
                            shape = RoundedCornerShape(25.dp)
                        )
                        .padding(25.dp)
                        .verticalScroll(rememberScrollState()) // Habilita scroll vertical
                ) {
                    Text(
                        text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum." +
                                "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum." +
                                "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum." +
                                "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.",
                        color = Color.White,
                        fontSize = 20.sp
                    )
                }

                Spacer(modifier = Modifier.height(20.dp)) // Espacio entre el texto y el Checkbox

                // Row con el Checkbox al final del Box principal
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center, // Centrado horizontalmente
                    verticalAlignment = Alignment.CenterVertically // Centrado verticalmente
                ) {
                    Checkbox(
                        checked = isChecked,
                        onCheckedChange = { isChecked = it }, // Cambia el estado al hacer clic
                        colors = CheckboxDefaults.colors(
                            checkedColor =  Color(0xFFEF476F), // Color marcado
                            uncheckedColor = Color.White, // Color desmarcado
                            checkmarkColor = Color.White // Color del ícono de check
                        )
                    )
                    Text(
                        text = "Acepta nuestros términos y condiciones",
                        fontSize = 16.sp,
                        color = Color.White,
                        fontFamily = FontFamily(Font(R.font.happy_monkey))
                    )
                }

                Spacer(modifier = Modifier.height(20.dp))

                Button(
                    onClick = { navController.navigate(NavScreen.AddChildScreen.name) },
                    enabled = isChecked, // Habilita o deshabilita el botón según el checkbox
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp)
                        .shadow(8.dp, shape = RoundedCornerShape(25.dp)),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = if (isChecked) Color(0xFFEF476F) else Color(0xFF666666) // Cambia el color según el estado
                    )
                ) {
                    Text(
                        text = "Continuar",
                        fontFamily = FontFamily(Font(R.font.happy_monkey)),
                        fontSize = 20.sp
                    )
                }
            }
        }
        Spacer(modifier = Modifier.height(50.dp))

        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.Bottom
        )
        {
            Text(
                text = "©Wooperland 2024", fontFamily = FontFamily(Font(R.font.happy_monkey)),
                color = Color.White,
                fontSize = 15.sp
            )
        }
    }
}



@Preview(showBackground = true)
@Composable
fun TermsScreenPreview(){
    Wooperland_enserioTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            TermsScreen(rememberNavController())
        }
    }
}
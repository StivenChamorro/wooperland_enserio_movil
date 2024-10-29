package com.example.wooperland_enserio.screens

import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.wooperland_enserio.R
import com.example.wooperland_enserio.ui.theme.Wooperland_enserioTheme
import coil.compose.rememberAsyncImagePainter
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.wooperland_enserio.navigation.NavScreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddChildScreen(navController: NavController) {
    var imageUri by remember { mutableStateOf<Uri?>(null) }
    var name by remember { mutableStateOf("") }
    var lastname by remember { mutableStateOf("") }
    var age by remember { mutableStateOf("") }
    var relation by remember { mutableStateOf("") }
    var gender by remember { mutableStateOf("") }
    var nickname by remember { mutableStateOf("") }

    val gradient = Brush.verticalGradient(
        colors = listOf(
            Color(0xFFEF476F).copy(alpha = 0.9f), // Color con 90% de opacidad
            Color(0xFF892940).copy(alpha = 0.9f)  // Color con 90% de opacidad
        )
    )

    // Lanzador para abrir el selector de imágenes
    val launcher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent()
    ) { uri: Uri? ->
        imageUri = uri // Guardar la URI seleccionada
    }

    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        // Imagen de fondo
        Image(
            painter = painterResource(id = R.drawable.addchild),
            contentDescription = null,
            contentScale = ContentScale.FillBounds,
            modifier = Modifier.fillMaxSize()
        )

        Box(
            modifier = Modifier.fillMaxSize(), // El contenedor ocupará todo el tamaño disponible
            contentAlignment = Alignment.Center // Centra el Box hijo dentro del padre
        ) {
            Box(
                modifier = Modifier
                    .background(gradient, shape = RoundedCornerShape(25.dp))
                    .padding(16.dp, 50.dp) // Espaciado interno del Box
            ) {
                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "Crea un nuevo perfil",
                        color = Color.White,
                        fontFamily = FontFamily(Font(R.font.happy_monkey)),
                        fontSize = 24.sp
                    )

                    Spacer(modifier = Modifier.height(50.dp))

                    // Campo de selección de imagen
                    Box(
                        modifier = Modifier
                            .size(100.dp) // Tamaño del contenedor de la imagen
                            .clip(RoundedCornerShape(50.dp)) // Forma circular para la imagen de perfil
                            .background(Color.Gray) // Fondo inicial
                            .clickable { launcher.launch("image/*") }, // Abre la galería
                        contentAlignment = Alignment.Center
                    ) {
                        if (imageUri != null) {
                            // Si hay una imagen seleccionada, mostrarla
                            Image(
                                painter = rememberAsyncImagePainter(imageUri),
                                contentDescription = "Imagen de perfil",
                                modifier = Modifier.fillMaxSize(),
                                contentScale = ContentScale.Crop
                            )
                        } else {
                            // Placeholder: ícono o texto
                            Icon(
                                painter = painterResource(id = R.drawable.ic_person), // Reemplaza con tu ícono
                                contentDescription = "Placeholder",
                                modifier = Modifier.size(80.dp),
                                tint = Color.White
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(50.dp))

                    // Input para name
                    OutlinedTextField(
                        value = name,
                        onValueChange = { name = it },
                        label = { Text("Nombres", fontSize = 20.sp ,color = Color.White, fontFamily = FontFamily(Font(R.font.happy_monkey))) },
                        modifier = Modifier
                            .fillMaxWidth(0.9f)
                            .height(56.dp),
                        shape = RoundedCornerShape(25.dp),
                        colors = TextFieldDefaults.outlinedTextFieldColors(
                            focusedBorderColor = Color.White, // Borde blanco al enfocar
                            unfocusedBorderColor = Color.White, // Borde blanco al desenfocar
                            cursorColor = Color.White // Color del cursor
                        )
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    // Input para lastname
                    OutlinedTextField(
                        value = lastname,
                        onValueChange = { lastname = it },
                        label = { Text("Apellidos", fontSize = 20.sp ,color = Color.White, fontFamily = FontFamily(Font(R.font.happy_monkey))) },
                        modifier = Modifier
                            .fillMaxWidth(0.9f)
                            .height(56.dp),
                        shape = RoundedCornerShape(25.dp),
                        colors = TextFieldDefaults.outlinedTextFieldColors(
                            focusedBorderColor = Color.White, // Borde blanco al enfocar
                            unfocusedBorderColor = Color.White, // Borde blanco al desenfocar
                            cursorColor = Color.White // Color del cursor
                        )
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    // Input para age
                    OutlinedTextField(
                        value = age,
                        onValueChange = { age = it },
                        label = { Text("Fecha de nacimiento", fontSize = 20.sp ,color = Color.White, fontFamily = FontFamily(Font(R.font.happy_monkey))) },
                        modifier = Modifier
                            .fillMaxWidth(0.9f)
                            .height(56.dp),
                        shape = RoundedCornerShape(25.dp),
                        colors = TextFieldDefaults.outlinedTextFieldColors(
                            focusedBorderColor = Color.White, // Borde blanco al enfocar
                            unfocusedBorderColor = Color.White, // Borde blanco al desenfocar
                            cursorColor = Color.White // Color del cursor
                        )
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    // Input para relation
                    OutlinedTextField(
                        value = relation,
                        onValueChange = { relation = it },
                        label = { Text("Relación con el usuario", fontSize = 20.sp ,color = Color.White, fontFamily = FontFamily(Font(R.font.happy_monkey))) },
                        modifier = Modifier
                            .fillMaxWidth(0.9f)
                            .height(56.dp),
                        shape = RoundedCornerShape(25.dp),
                        colors = TextFieldDefaults.outlinedTextFieldColors(
                            focusedBorderColor = Color.White, // Borde blanco al enfocar
                            unfocusedBorderColor = Color.White, // Borde blanco al desenfocar
                            cursorColor = Color.White // Color del cursor
                        )
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    OutlinedTextField(
                        value = gender,
                        onValueChange = { gender = it },
                        label = {
                            Text(
                                "Género",
                                fontSize = 20.sp,
                                color = Color.White,
                                fontFamily = FontFamily(Font(R.font.happy_monkey))
                            )
                        },
                        modifier = Modifier
                            .fillMaxWidth(0.9f)
                            .height(56.dp),
                        shape = RoundedCornerShape(25.dp),
                        colors = TextFieldDefaults.outlinedTextFieldColors(
                            focusedBorderColor = Color.White, // Borde blanco al enfocar
                            unfocusedBorderColor = Color.White, // Borde blanco al desenfocar
                            cursorColor = Color.White // Color del cursor
                        )
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    OutlinedTextField(
                        value = nickname,
                        onValueChange = { nickname = it },
                        label = { Text("Nickname", fontSize = 20.sp , color = Color.White,fontFamily = FontFamily(Font(R.font.happy_monkey))) },
                        modifier = Modifier
                            .fillMaxWidth(0.9f)
                            .height(56.dp),
                        shape = RoundedCornerShape(25.dp),
                        colors = TextFieldDefaults.outlinedTextFieldColors(
                            focusedBorderColor = Color.White, // Borde blanco al enfocar
                            unfocusedBorderColor = Color.White, // Borde blanco al desenfocar
                            cursorColor = Color.White // Color del cursor
                        )
                    )

                    Spacer(modifier = Modifier.height(60.dp))

                    // Botón de continuar
                    Button(
                        onClick = { navController.navigate(NavScreen.HomeScreen.name) },
                        modifier = Modifier
                            .fillMaxWidth(.9f)
                            .height(56.dp)
                            .shadow(8.dp, shape = RoundedCornerShape(25.dp)), // Agrega sombra
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(0xFFEF476F) // Color de fondo
                        )
                    ) {
                        Text(text = "Continuar", fontFamily = FontFamily(Font(R.font.happy_monkey)),fontSize = 30.sp,)
                    }
                }
            }
        }
    }
}



@Preview(showBackground = true)
@Composable
fun AddChildPreview() {
    Wooperland_enserioTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            AddChildScreen(rememberNavController())
        }
    }
}

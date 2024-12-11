package com.example.wooperland_enserio.screens

import android.content.res.Configuration
import android.net.Uri
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import com.example.wooperland_enserio.R
import com.example.wooperland_enserio.navigation.NavScreen
import com.example.wooperland_enserio.viewmodel.AddChildViewModel
import java.io.File
import java.io.FileOutputStream
import java.text.SimpleDateFormat
import java.util.*

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddChildScreen(
    navController: NavController,
    viewModel: AddChildViewModel = androidx.lifecycle.viewmodel.compose.viewModel()
) {
    // Estados locales
    var imageUri by remember { mutableStateOf<Uri?>(null) }
    var name by remember { mutableStateOf("") }
    var lastname by remember { mutableStateOf("") }
    var birthDate by remember { mutableStateOf("") }
    var relation by remember { mutableStateOf("") }
    var gender by remember { mutableStateOf("") }
    var nickname by remember { mutableStateOf("") }
    var showDatePicker by remember { mutableStateOf(false) }
    var isLoading by remember { mutableStateOf(false) }

    val context = LocalContext.current
    val response by viewModel.responseState.collectAsState()
    val errorMessage by viewModel.errorState.collectAsState()

    val happyMonkeyFont = FontFamily(Font(R.font.happy_monkey))
    val gradient = Brush.verticalGradient(
        colors = listOf(Color(0xFFEF476F).copy(alpha = 0.9f), Color(0xFF892940).copy(alpha = 0.9f))
    )

    // Image Picker
    val imagePicker = rememberLauncherForActivityResult(ActivityResultContracts.GetContent()) { uri ->
        imageUri = uri
    }

    LaunchedEffect(response) {
        response?.let {
            Toast.makeText(context, "Perfil creado exitosamente.", Toast.LENGTH_SHORT).show()
            navController.navigate(NavScreen.HomeScreen.name)
        }
    }

    LaunchedEffect(errorMessage) {
        errorMessage?.let {
            Toast.makeText(context, "Error: $it", Toast.LENGTH_SHORT).show()
        }
    }

    Box(modifier = Modifier.fillMaxSize()) {
        BackgroundImage()
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            contentAlignment = Alignment.Center
        ) {
            Box(
                modifier = Modifier
                    .background(gradient, shape = RoundedCornerShape(25.dp))
                    .padding(16.dp)
                    .fillMaxWidth()
                    .fillMaxHeight(0.9f)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .verticalScroll(rememberScrollState()),
                    verticalArrangement = Arrangement.spacedBy(16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    // Título
                    Text(
                        text = "Crea un nuevo perfil",
                        color = Color.White,
                        fontFamily = happyMonkeyFont,
                        fontSize = 24.sp,
                        modifier = Modifier.padding(top = 24.dp)
                    )

                    // Selector de imagen
                    ProfileImagePicker(imageUri) { imagePicker.launch("image/*") }

                    // Campos de texto
                    ProfileTextField(value = name, onValueChange = { name = it }, label = "Nombres", icon = Icons.Default.Person, happyMonkeyFont)
                    ProfileTextField(value = lastname, onValueChange = { lastname = it }, label = "Apellidos", icon = Icons.Default.Person, happyMonkeyFont)
                    ProfileTextField(
                        value = birthDate,
                        onValueChange = {},
                        label = "Fecha de nacimiento",
                        icon = Icons.Default.DateRange,
                        font = happyMonkeyFont,
                        readOnly = true,
                        trailingIcon = {
                            IconButton(onClick = { showDatePicker = true }) {
                                Icon(Icons.Default.CalendarToday, contentDescription = "Seleccionar fecha", tint = Color.White)
                            }
                        }
                    )
                    ProfileTextField(value = relation, onValueChange = { relation = it }, label = "Relación", icon = Icons.Default.Favorite, happyMonkeyFont)
                    ProfileTextField(value = gender, onValueChange = { gender = it }, label = "Género", icon = Icons.Default.Face, happyMonkeyFont)
                    ProfileTextField(value = nickname, onValueChange = { nickname = it }, label = "Nickname", icon = Icons.Default.Star, happyMonkeyFont)

                    // Botón Continuar
                    Button(
                        onClick = {
                            if (name.isBlank() || lastname.isBlank() || birthDate.isBlank() || nickname.isBlank()) {
                                Toast.makeText(context, "Completa todos los campos.", Toast.LENGTH_SHORT).show()
                                return@Button
                            }

                            isLoading = true
                            val avatarPath = imageUri?.let { uri ->
                                val file = File(context.cacheDir, "avatar.jpg")
                                context.contentResolver.openInputStream(uri)?.use { input ->
                                    FileOutputStream(file).use { output -> input.copyTo(output) }
                                }
                                file.path
                            }

                            val dto = viewModel.createAddChildDto(
                                name = name,
                                lastname = lastname,
                                birthdate = birthDate,
                                nickname = nickname,
                                relation = relation,
                                gender = gender,
                                about = null,
                                avatarPath = avatarPath
                            )
                            viewModel.addChild(dto)
                        },
                        enabled = !isLoading,
                        modifier = Modifier
                            .fillMaxWidth(0.9f)
                            .height(56.dp)
                            .shadow(8.dp, RoundedCornerShape(25.dp)),
                        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFEF476F))
                    ) {
                        if (isLoading) CircularProgressIndicator(color = Color.White) else Text("Continuar", fontFamily = happyMonkeyFont, fontSize = 20.sp)
                    }

                    Spacer(modifier = Modifier.height(16.dp))
                }
            }
        }
    }

    // DatePicker
    if (showDatePicker) {
        val datePickerState = rememberDatePickerState()
        DatePickerDialog(
            onDismissRequest = { showDatePicker = false },
            confirmButton = {
                TextButton(onClick = {
                    datePickerState.selectedDateMillis?.let {
                        birthDate = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault()).format(Date(it))
                    }
                    showDatePicker = false
                }) {
                    Text("OK")
                }
            },
            dismissButton = { TextButton(onClick = { showDatePicker = false }) { Text("Cancelar") } }
        ) {
            DatePicker(state = datePickerState)
        }
    }
}




@Composable
fun BackgroundImage() {
    Image(
        painter = painterResource(id = R.drawable.addchild),
        contentDescription = null,
        contentScale = ContentScale.FillBounds,
        modifier = Modifier.fillMaxSize()
    )
}

@Composable
fun ProfileImagePicker(imageUri: Uri?, onClick: () -> Unit) {
    Box(
        modifier = Modifier
            .size(100.dp)
            .clip(RoundedCornerShape(50.dp))
            .background(Color.Gray)
            .clickable { onClick() },
        contentAlignment = Alignment.Center
    ) {
        if (imageUri != null) {
            Image(
                painter = rememberAsyncImagePainter(imageUri),
                contentDescription = "Imagen de perfil",
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )
        } else {
            Icon(
                imageVector = Icons.Default.AddAPhoto,
                contentDescription = "Añadir foto",
                modifier = Modifier.size(80.dp),
                tint = Color.White
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileTextField(
    value: String,
    onValueChange: (String) -> Unit,
    label: String,
    icon: ImageVector,
    font: FontFamily,
    readOnly: Boolean = false,
    trailingIcon: @Composable (() -> Unit)? = null
) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        label = { Text(label, fontSize = 18.sp, color = Color.White, fontFamily = font) },
        modifier = Modifier
            .fillMaxWidth(0.9f)
            .height(56.dp),
        shape = RoundedCornerShape(25.dp),
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = Color.White,
            unfocusedBorderColor = Color.White,
            cursorColor = Color.White
        ),
        leadingIcon = { Icon(icon, contentDescription = null, tint = Color.White) },
        readOnly = readOnly,
        trailingIcon = trailingIcon
    )
}

package com.example.wooperland_enserio.screens

import android.content.Context
import android.icu.lang.UCharacter.getAge
import android.net.Uri
import android.util.Log
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CameraAlt
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.navigation.NavController
import coil.compose.rememberImagePainter
import com.example.wooperland_enserio.R
import com.example.wooperland_enserio.viewmodel.ChildProfileViewModel
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date
import java.util.Locale


@Composable
fun ProfileScreen(
    viewModel: ChildProfileViewModel,
) {

//    val childId by ProfileUserViewModel.childId.collectAsState()
//    val childResponse by ViewModel.childResponse.collectAsState()
//    val errorMessage by ViewModel.errorMessage.collectAsState()
//
//    LaunchedEffect(childId) {
//        childId?.let {
//            viewModel.getChildDetails(it, "tu_jwt_token_aqui")
//        }
//    }

    val context = LocalContext.current
    val sharedPreferences = context.getSharedPreferences("AppPreferences", Context.MODE_PRIVATE)
    val token = sharedPreferences.getString("jwt_token", null)

    LaunchedEffect(Unit) {
        if (token != null) {
            viewModel.fetchChildProfile()
        }else{
            Log.e("HomeScreen", "Token is null")
        }
    }

    val child by viewModel.children.observeAsState()

    val gradient = Brush.verticalGradient(
        colors = listOf(
            Color(0xFFFFD166), // Amarillo claro
            Color(0xFFEF476F)  // Rosa oscuro
        )
    )

    val happyMonkeyFont = FontFamily(Font(R.font.happy_monkey))

    var isEditing by remember { mutableStateOf(false) }
    var showNicknameModal by remember { mutableStateOf(false) }
    var showAboutModal by remember { mutableStateOf(false) }
    var profileImageUri by remember { mutableStateOf<Uri?>(null) }

    var nickname by remember { mutableStateOf("") }
    var about by remember { mutableStateOf("") }

    val pink = Color(0xFFFF4081)
    val lightGray = Color(0xFFF5F5F5)

    LaunchedEffect(child) {
        child?.child?.let {
            nickname = it.nickname ?: ""
            about = it.about ?: ""
        }
    }

    val launcher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent()
    ) { uri: Uri? ->
        uri?.let { profileImageUri = it }
    }

    Box(modifier = Modifier
        .fillMaxSize()
        .background(gradient)
    ) {
        Image(
            painter = painterResource(id = R.drawable.background_profile),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.4f),
            contentScale = ContentScale.Crop
        )

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(30.dp)
                .padding(top = 50.dp)
        ) {
            // Tarjeta de perfil
            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.cardColors(containerColor = Color.White)
            ) {
                Column(
                    modifier = Modifier.padding(16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    // Imagen de perfil con icono de edición
                    Box(contentAlignment = Alignment.Center) {
                        Image(
                            painter = rememberImagePainter(data = child?.child?.avatar),
                            contentDescription = "Profile Picture",
                            modifier = Modifier
                                .size(120.dp)
                                .clip(CircleShape),
                            contentScale = ContentScale.Crop
                        )
                        if (isEditing) {
                            IconButton(
                                onClick = { launcher.launch("image/*") },
                                modifier = Modifier
                                    .size(40.dp)
                                    .align(Alignment.BottomEnd)
                                    .background(pink, CircleShape)
                            ) {
                                Icon(
                                    imageVector = Icons.Default.CameraAlt,
                                    contentDescription = "Change profile picture",
                                    tint = Color.White
                                )
                            }
                        }
                    }

                    // Información del perfil
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.padding(top = 8.dp)
                    ) {
                        Text(
                            text = nickname,
                            fontSize = 24.sp,
                            fontWeight = FontWeight.Bold,
                            fontFamily = happyMonkeyFont
                        )
                        if (isEditing) {
                            IconButton(onClick = { showNicknameModal = true }) {
                                Icon(Icons.Default.Edit, "Edit nickname")
                            }
                        }
                    }
                    Spacer(modifier = Modifier.height(8.dp))
                    Text("${child?.child?.name} ${child?.child?.lastname}", fontFamily = happyMonkeyFont)
                    Spacer(modifier = Modifier.height(8.dp))

                    Text("Fecha de nacimiento: ${child?.child?.birthdate}", fontFamily = happyMonkeyFont)
                    Spacer(modifier = Modifier.height(8.dp))
                    Text("Relación: ${child?.child?.relation}", fontFamily = happyMonkeyFont)
                    Spacer(modifier = Modifier.height(8.dp))

                    Button(
                        onClick = { isEditing = !isEditing },
                        colors = ButtonDefaults.buttonColors(containerColor = pink),
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 8.dp)
                    ) {
                        Text(
                            if (isEditing) "Guardar información" else "Editar información",
                            fontFamily = happyMonkeyFont
                        )
                    }
                }
            }

            // Sección "Escribe sobre ti"
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 25.dp),
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.cardColors(containerColor = Color.White)
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            "Escribe sobre ti",
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold,
                            fontFamily = happyMonkeyFont
                        )
                        if (isEditing) {
                            IconButton(onClick = { showAboutModal = true }) {
                                Icon(Icons.Default.Edit, "Edit about")
                            }
                        }
                    }
                    Text(about, fontFamily = happyMonkeyFont)
                }
            }

            // Sección "Temas recientes"
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 25.dp),
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.cardColors(containerColor = Color.White)
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text(
                        "Temas recientes",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        fontFamily = happyMonkeyFont
                    )
                    RecentTopicItem("Matemáticas")
                    RecentTopicItem("Ciencias sociales")
                    RecentTopicItem("Astronomía")
                }
            }
        }

        // Modal para editar nickname
        if (showNicknameModal) {
            EditNicknameDialog(
                currentNickname = nickname,
                onDismiss = { showNicknameModal = false },
                onSave = { newNickname ->
                    nickname = newNickname
                    showNicknameModal = false
                },
                viewModel = viewModel
            )
        }

        // Modal para editar "Sobre ti"
        if (showAboutModal) {
            EditAboutDialog(
                currentAbout = about,
                onDismiss = { showAboutModal = false },
                onSave = { newAbout ->
                    about = newAbout
                    showAboutModal = false
                },
                viewModel = viewModel
            )
        }
    }
}

@Composable
fun RecentTopicItem(topic: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = R.drawable.math),
            contentDescription = null,
            modifier = Modifier
                .size(24.dp)
                .clip(CircleShape)
        )
        Text(
            text = topic,
            modifier = Modifier.padding(start = 8.dp),
            fontFamily = happyMonkeyFont
        )
    }
}

@Composable
fun EditNicknameDialog(
    currentNickname: String,
    onDismiss: () -> Unit,
    onSave: (String) -> Unit,
    viewModel: ChildProfileViewModel
) {
    var nickname by remember { mutableStateOf(currentNickname) }

    Dialog(onDismissRequest = onDismiss) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            shape = RoundedCornerShape(16.dp),
            colors = CardDefaults.cardColors(containerColor = Color.White)
        ) {
            Column(
                modifier = Modifier.padding(16.dp)
            ) {
                Text(
                    "Cambia tu nickname",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    fontFamily = happyMonkeyFont
                )

                OutlinedTextField(
                    value = nickname,
                    onValueChange = {
                        if (it.length <= 20) nickname = it
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp),
                    maxLines = 1,
                    textStyle = androidx.compose.ui.text.TextStyle(fontFamily = happyMonkeyFont)
                )

                Text(
                    "${nickname.length}/20",
                    modifier = Modifier.align(Alignment.End),
                    fontFamily = happyMonkeyFont
                )

                Button(onClick = {
                    viewModel.updateChildProfile(nickname, viewModel.children.value?.child?.about ?: "")
                    onSave(nickname)
                    onDismiss()
                }) {
                    Text("Guardar")
                }

            }
        }
    }
}

@Composable
fun EditAboutDialog(
    currentAbout: String,
    onDismiss: () -> Unit,
    onSave: (String) -> Unit,
    viewModel: ChildProfileViewModel
) {
    var about by remember { mutableStateOf(currentAbout) }

    Dialog(onDismissRequest = onDismiss) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            shape = RoundedCornerShape(16.dp),
            colors = CardDefaults.cardColors(containerColor = Color.White)
        ) {
            Column(
                modifier = Modifier.padding(16.dp)
            ) {
                Text(
                    "Escribe sobre ti",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    fontFamily = happyMonkeyFont
                )

                OutlinedTextField(
                    value = about,
                    onValueChange = {
                        if (it.length <= 300) about = it
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(150.dp)
                        .padding(vertical = 8.dp),
                    maxLines = 5,
                    textStyle = androidx.compose.ui.text.TextStyle(fontFamily = happyMonkeyFont)
                )

                Text(
                    "${about.length}/300",
                    modifier = Modifier.align(Alignment.End),
                    fontFamily = happyMonkeyFont
                )

                Button(onClick = {
                    viewModel.updateChildProfile(viewModel.children.value?.child?.nickname ?: "", about)
                    onSave(about)
                    onDismiss()
                }) {
                    Text("Guardar")
                }

            }
        }
    }
}

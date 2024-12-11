package com.example.wooperland_enserio.ui.components

import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import java.io.File

@Composable
fun ImagePicker(onImageSelected: (File?) -> Unit) {
    var imageFile by remember { mutableStateOf<File?>(null) }

    val launcher = rememberLauncherForActivityResult(ActivityResultContracts.GetContent()) { uri ->
        uri?.let {
            val path = uri.path // Convertir URI a String o utilizar alguna librería para obtener el path real
            val file = File(path ?: "")
            imageFile = file
            onImageSelected(file)
        } ?: onImageSelected(null)
    }

    Button(onClick = { launcher.launch("image/*") }) {
        Text("Seleccionar Imagen")
    }
}
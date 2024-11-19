package com.example.wooperland_enserio.models

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Accessibility
import androidx.compose.material.icons.outlined.Group
import androidx.compose.material.icons.outlined.Logout
import androidx.compose.ui.graphics.vector.ImageVector

enum class DraweItem(
    val icon: ImageVector,
    val title: String

){
    CambiarJugador(Icons.Outlined.Group, "Cambiar Jugador"),
    ProfileAdult(Icons.Outlined.Accessibility, "Perfil Adulto"),
    CerrarSesion(Icons.Outlined.Logout, "Cerrar Sesión")
}
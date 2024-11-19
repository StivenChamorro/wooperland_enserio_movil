package com.example.wooperland_enserio.model

import java.time.LocalDate

data class UserResponse(
    val id: Int, // ID del usuario
    val name: String, // Nombre del usuario
    val lastName: String, // Apellido del usuario
    val birthdate: String, // Fecha de nacimiento en formato de cadena (puedes cambiarla a LocalDate si es necesario)
    val email: String, // Correo electrónico del usuario
    val user: String?, // Nombre de usuario, puede ser null
    val password: String?, // Contraseña, evita exponerla directamente por seguridad
    val role: String = "user", // Rol del usuario, con valor predeterminado "user"
)

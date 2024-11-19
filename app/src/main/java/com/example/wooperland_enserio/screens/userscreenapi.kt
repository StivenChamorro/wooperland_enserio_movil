package com.example.wooperland_enserio.screens

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.wooperland_enserio.model.UserResponse
import com.example.wooperland_enserio.viewmodel.UsersViewModel

@Composable
fun userscreenapi(viewModel: UsersViewModel) {
    val users by viewModel.users.observeAsState(emptyList()) // Observamos una lista
    LaunchedEffect(Unit) {
        viewModel.fetchUsers()
    }
    Column {
        if (users.isEmpty()) {
            // Mostrar mensaje si no hay usuarios
            Text(text = "No hay usuarios")
            Log.d("UserScreen", "Lista vacía o no cargada.")
        } else {
            // Mostrar la lista de usuarios
            Text(text = "Usuarios")
            users.forEach { user -> // Iteramos por cada usuario
                UserItem(user)
            }
            Log.d("UserScreen", users.toString())
        }
    }
}

@Composable
fun UserItem(user: UserResponse) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
        ) {
            Text(
                text = user.name,
                style = MaterialTheme.typography.bodyLarge
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "Email: ${user.email}",
                style = MaterialTheme.typography.bodyLarge
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "Rol: ${user.role}",
                style = MaterialTheme.typography.bodyLarge
            )
        }
    }
}


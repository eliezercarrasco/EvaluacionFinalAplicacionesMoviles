package com.example.pasteleriayy.ui.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.navigation.NavController

data class NavItem(
    val route: String,
    val label: String
)

private val navItems = listOf(
    NavItem("inicio", "Inicio"),
    NavItem("menu", "Menú"),
    NavItem("promociones", "Promociones"),
    NavItem("contacto", "Contacto"),
    NavItem("apiRecetas", "Buscar"),
    NavItem("registro", "Registro"),
    NavItem("login", "Login"),
    NavItem("crud_usuarios", "CRUD Usuarios")
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBarMenu(
    navController: NavController
) {
    var expanded by remember { mutableStateOf(false) }

    TopAppBar(
        title = {
            Text(
                text = "Pastelería Mil Sabores",
                color = Color.White,
                fontWeight = FontWeight.Bold
            )
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Color.Black
        ),
        actions = {
            IconButton(onClick = { expanded = true }) {
                Icon(
                    imageVector = Icons.Filled.MoreVert,
                    contentDescription = "Menu Opciones",
                    tint = Color.White
                )
            }

            DropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false },
                containerColor = Color.DarkGray
            ) {
                navItems.forEach { item ->
                    DropdownMenuItem(
                        text = { Text(item.label, color = Color.White) },
                        onClick = {
                            expanded = false
                            navController.navigate(item.route) {
                                launchSingleTop = true
                                restoreState = true
                            }
                        }
                    )
                }
            }
        }
    )
}

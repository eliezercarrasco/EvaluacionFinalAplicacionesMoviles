package com.example.pasteleriayy.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.pasteleriayy.ui.screens.*

object AppScreens {
    const val INICIO = "inicio"
    const val MENU = "menu"
    const val PROMOCIONES = "promociones"
    const val CONTACTO = "contacto"
    const val API_RECETAS = "apiRecetas"
    const val REGISTRO = "registro"
    const val LOGIN = "login"
    const val CRUD_USUARIOS = "crud_usuarios"
}

@Composable
fun AppNavigation(navController: NavHostController, modifier: Modifier = Modifier) {

    NavHost(
        navController = navController,
        startDestination = AppScreens.INICIO,
        modifier = modifier
    ) {
        composable(AppScreens.INICIO) {
            InicioScreen(navController)
        }

        composable(AppScreens.MENU) {
            MenuProductosScreen(navController)
        }

        composable(AppScreens.PROMOCIONES) {
            PromocionesScreen(navController)
        }

        composable(AppScreens.CONTACTO) {
            ContactoScreen(navController)
        }

        composable(AppScreens.API_RECETAS) {
            RecetasScreen(navController)
        }

        composable(AppScreens.REGISTRO) {
            FormularioValidacion(navController)
        }

        composable(AppScreens.LOGIN) {
            LoginScreen(navController)
        }

        composable(AppScreens.CRUD_USUARIOS) {
            PantallaCrud(navController)
        }

        composable("editar_usuario/{id}") { backStack ->
            val id = backStack.arguments?.getString("id")!!.toLong()
            PantallaEditarUsuario(idUsuario = id, navController = navController)
        }
    }
}

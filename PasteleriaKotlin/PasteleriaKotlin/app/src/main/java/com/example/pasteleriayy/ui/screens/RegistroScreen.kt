package com.example.pasteleriayy.ui.screens

import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import android.graphics.Bitmap
import android.util.Base64
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CameraAlt
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Photo
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.pasteleriayy.model.Usuario
import com.example.pasteleriayy.viewmodel.RegistroViewModel
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import java.io.ByteArrayOutputStream
import android.graphics.BitmapFactory

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FormularioValidacion(navController: NavController, modifier: Modifier = Modifier) {

    val viewModel: RegistroViewModel = viewModel()
    val mensaje by viewModel.mensaje.collectAsState()

    val context = LocalContext.current

    var nombre by remember { mutableStateOf("") }
    var correo by remember { mutableStateOf("") }
    var contrasena by remember { mutableStateOf("") }
    var confirmarContrasena by remember { mutableStateOf("") }
    var telefono by remember { mutableStateOf("") }
    var rol by remember { mutableStateOf(1) }
    var verPass by remember { mutableStateOf(false) }
    var verPass2 by remember { mutableStateOf(false) }
    var bitmap by remember { mutableStateOf<Bitmap?>(null) }
    var imagenBase64 by remember { mutableStateOf<String?>(null) }

    val launcherCamara = rememberLauncherForActivityResult(
        ActivityResultContracts.TakePicturePreview()
    ) { result ->
        result?.let {
            bitmap = it
            imagenBase64 = convertirBitmapBase64(it)
        }
    }

    val launcherPermisoCamara = rememberLauncherForActivityResult(
        ActivityResultContracts.RequestPermission()
    ) { granted ->
        if (granted) launcherCamara.launch(null)
    }

    val launcherGaleria = rememberLauncherForActivityResult(
        ActivityResultContracts.GetContent()
    ) { uri ->
        uri?.let {
            val stream = context.contentResolver.openInputStream(it)
            val bmp = BitmapFactory.decodeStream(stream)
            bitmap = bmp
            imagenBase64 = convertirBitmapBase64(bmp)
        }
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Registro de Usuario") },
                navigationIcon = {}
            )
        }
    ) { padding ->

        Column(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            if (bitmap != null) {
                Box(
                    modifier = Modifier
                        .size(180.dp)
                        .background(Color.LightGray),
                    contentAlignment = Alignment.TopEnd
                ) {
                    Image(
                        bitmap = bitmap!!.asImageBitmap(),
                        contentDescription = null,
                        modifier = Modifier.fillMaxSize()
                    )

                    IconButton(onClick = {
                        bitmap = null
                        imagenBase64 = null
                    }) {
                        Icon(Icons.Default.Delete, contentDescription = null, tint = Color.Red)
                    }
                }

                Spacer(modifier = Modifier.height(10.dp))

                Button(onClick = { launcherPermisoCamara.launch(android.Manifest.permission.CAMERA) }) {
                    Icon(Icons.Default.CameraAlt, contentDescription = null)
                    Spacer(modifier = Modifier.width(8.dp))
                    Text("Tomar otra foto")
                }
            } else {
                Row(horizontalArrangement = Arrangement.spacedBy(10.dp)) {

                    Button(onClick = { launcherPermisoCamara.launch(android.Manifest.permission.CAMERA) }) {
                        Icon(Icons.Default.CameraAlt, contentDescription = null)
                        Spacer(modifier = Modifier.width(8.dp))
                        Text("Cámara")
                    }

                    Button(onClick = { launcherGaleria.launch("image/*") }) {
                        Icon(Icons.Default.Photo, contentDescription = null)
                        Spacer(modifier = Modifier.width(8.dp))
                        Text("Galería")
                    }
                }
            }

            Spacer(modifier = Modifier.height(20.dp))

            OutlinedTextField(
                value = nombre,
                onValueChange = { nombre = it },
                label = { Text("Nombre") },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(10.dp))

            OutlinedTextField(
                value = correo,
                onValueChange = { correo = it },
                label = { Text("Correo") },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(10.dp))

            OutlinedTextField(
                value = contrasena,
                onValueChange = { contrasena = it },
                label = { Text("Contraseña") },
                visualTransformation = if (verPass) VisualTransformation.None else PasswordVisualTransformation(),
                trailingIcon = {
                    IconButton(onClick = { verPass = !verPass }) {
                        Icon(
                            imageVector = if (verPass) Icons.Default.VisibilityOff else Icons.Default.Visibility,
                            contentDescription = null
                        )
                    }
                },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(10.dp))

            OutlinedTextField(
                value = confirmarContrasena,
                onValueChange = { confirmarContrasena = it },
                label = { Text("Confirmar Contraseña") },
                visualTransformation = if (verPass2) VisualTransformation.None else PasswordVisualTransformation(),
                trailingIcon = {
                    IconButton(onClick = { verPass2 = !verPass2 }) {
                        Icon(
                            imageVector = if (verPass2) Icons.Default.VisibilityOff else Icons.Default.Visibility,
                            contentDescription = null
                        )
                    }
                },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(10.dp))

            OutlinedTextField(
                value = telefono,
                onValueChange = { telefono = it },
                label = { Text("Teléfono (opcional)") },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(10.dp))

            Text("Seleccionar Rol:")
            Row(verticalAlignment = Alignment.CenterVertically) {
                RadioButton(selected = rol == 1, onClick = { rol = 1 })
                Text("Usuario")
                Spacer(modifier = Modifier.width(20.dp))
                RadioButton(selected = rol == 2, onClick = { rol = 2 })
                Text("Administrador")
            }

            Spacer(modifier = Modifier.height(20.dp))

            Button(
                onClick = {

                    if (contrasena != confirmarContrasena) {
                        viewModel.actualizarMensaje("Las contraseñas no coinciden")
                        return@Button
                    }

                    val user = Usuario(
                        id = null,
                        nombre = nombre,
                        correo = correo,
                        contrasena = contrasena,
                        telefono = telefono.ifBlank { null },
                        rol = rol,
                        imagenBase64 = imagenBase64
                    )

                    viewModel.registrarUsuario(user)
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Registrar Usuario")
            }

            if (mensaje.isNotEmpty()) {
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = mensaje,
                    color = if (mensaje.contains("exito", ignoreCase = true)) Color.Green else Color.Red
                )
            }
        }
    }
}

fun convertirBitmapBase64(bitmap: Bitmap): String {
    val stream = ByteArrayOutputStream()
    bitmap.compress(Bitmap.CompressFormat.JPEG, 90, stream)
    val bytes = stream.toByteArray()
    return Base64.encodeToString(bytes, Base64.DEFAULT)
}

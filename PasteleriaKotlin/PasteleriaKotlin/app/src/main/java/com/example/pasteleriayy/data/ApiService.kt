package com.example.pasteleriayy.data

import com.example.pasteleriayy.model.Usuario
import retrofit2.Response
import retrofit2.http.*

interface ApiService {

    // Crear usuario (POST)
    @POST("api/registro")
    suspend fun registrarUsuario(@Body usuario: Usuario): Response<Usuario>

    // Listar todos (GET)
    @GET("api/registro")
    suspend fun listarUsuarios(): List<Usuario>

    // Obtener por id (GET)
    @GET("api/registro/{id}")
    suspend fun obtenerUsuario(@Path("id") id: Long): Usuario

    // Actualizar (PUT)
    @PUT("api/registro/{id}")
    suspend fun actualizarUsuario(
        @Path("id") id: Long,
        @Body usuario: Usuario
    ): Response<Usuario>

    // Eliminar (DELETE)
    @DELETE("api/registro/{id}")
    suspend fun eliminarUsuario(@Path("id") id: Long): Response<Void>
}

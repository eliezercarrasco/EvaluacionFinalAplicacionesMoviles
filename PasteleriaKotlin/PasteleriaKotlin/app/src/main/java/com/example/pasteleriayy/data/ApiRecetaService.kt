package com.example.pasteleriayy.data

import com.example.pasteleriayy.model.RecetaResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiRecetaService {

    @GET("search.php")
    suspend fun buscarRecetas(@Query("s") nombre: String): RecetaResponse
}

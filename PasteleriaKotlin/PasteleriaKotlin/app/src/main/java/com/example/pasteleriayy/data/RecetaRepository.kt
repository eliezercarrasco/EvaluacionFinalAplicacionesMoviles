package com.example.pasteleriayy.data

import com.example.pasteleriayy.model.RecetaResponse

class RecetaRepository {

    private val api = RetrofitRecetaClient.instance.create(ApiRecetaService::class.java)

    suspend fun buscar(nombre: String): RecetaResponse {
        return api.buscarRecetas(nombre)
    }
}

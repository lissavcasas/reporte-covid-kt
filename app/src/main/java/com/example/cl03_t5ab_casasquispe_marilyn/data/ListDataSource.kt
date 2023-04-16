package com.example.cl03_t5ab_casasquispe_marilyn.data

import com.example.cl03_t5ab_casasquispe_marilyn.entidad.Data
import com.example.cl03_t5ab_casasquispe_marilyn.entidad.Resultado
import com.example.cl03_t5ab_casasquispe_marilyn.entidad.SimpleMensaje
import com.example.cl03_t5ab_casasquispe_marilyn.network.ConexionApi

class ListDataSource {
    suspend fun listarCiudades(): Resultado<Data> {
        try {
            val response = ConexionApi.retrofitService.getCiudades()
            return Resultado.Exito(response)
        } catch (ex: Exception) {
            val error = SimpleMensaje("001", ex.toString())
            return Resultado.Error(error)

        }
    }
}
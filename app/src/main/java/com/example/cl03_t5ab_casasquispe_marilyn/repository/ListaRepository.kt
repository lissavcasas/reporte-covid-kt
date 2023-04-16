package com.example.cl03_t5ab_casasquispe_marilyn.repository

import com.example.cl03_t5ab_casasquispe_marilyn.data.ListDataSource
import com.example.cl03_t5ab_casasquispe_marilyn.entidad.CiudadCasas
import com.example.cl03_t5ab_casasquispe_marilyn.entidad.Resultado


class ListaRepository(private val dataSource: ListDataSource) {

    suspend fun getCiudades(): Resultado<List<CiudadCasas>> {
        when (val respuesta = dataSource.listarCiudades()) {
            is Resultado.Exito -> {
                val ciudades = respuesta.data.data
                return Resultado.Exito(ciudades)
            }
            is Resultado.Error -> {
                return respuesta
            }
        }
    }
}

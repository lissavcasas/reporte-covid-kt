package com.example.cl03_t5ab_casasquispe_marilyn.network

import com.example.cl03_t5ab_casasquispe_marilyn.entidad.Data
import retrofit2.http.GET

interface Services {
    @GET("api/reports?q=Peru&iso=PER")
    suspend fun getCiudades(): Data
}
package com.example.cl03_t5ab_casasquispe_marilyn.entidad

class CiudadCasas(
    val confirmed: Int,
    val deaths: Int,
    val region: Region
) {
    override fun toString(): String {
        return "CiudadCasas(confirmed=$confirmed, deaths=$deaths, region=$region)"
    }
}


package com.example.cl03_t5ab_casasquispe_marilyn.entidad

sealed class Resultado<out T> {
    data class Exito<out T : Any>(val data: T) : Resultado<T>()
    data class Error(val mensaje: SimpleMensaje) : Resultado<Nothing>()
}
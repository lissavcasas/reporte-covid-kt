package com.example.cl03_t5ab_casasquispe_marilyn.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cl03_t5ab_casasquispe_marilyn.entidad.CiudadCasas
import com.example.cl03_t5ab_casasquispe_marilyn.entidad.Resultado
import com.example.cl03_t5ab_casasquispe_marilyn.entidad.SimpleMensaje
import com.example.cl03_t5ab_casasquispe_marilyn.repository.ListaRepository

import kotlinx.coroutines.launch

class MainViewModel(private val repository: ListaRepository) : ViewModel() {
    private var _ciudades = MutableLiveData<List<CiudadCasas>>()
    val ciudades: LiveData<List<CiudadCasas>> get() = _ciudades

    private var _error = MutableLiveData<SimpleMensaje>()
    val error: LiveData<SimpleMensaje> get() = _error

    fun obtenerCiudades() {
        viewModelScope.launch {
            when (val respuesta = repository.getCiudades()) {
                is Resultado.Exito -> {
                    _ciudades.value = respuesta.data
                }
                is Resultado.Error -> {
                    _error.value = respuesta.mensaje
                }
            }
        }
    }
}
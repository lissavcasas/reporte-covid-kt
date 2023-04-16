package com.example.cl03_t5ab_casasquispe_marilyn.ui.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.cl03_t5ab_casasquispe_marilyn.data.ListDataSource
import com.example.cl03_t5ab_casasquispe_marilyn.repository.ListaRepository

class ViewModelFactory : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        when {
            modelClass.isAssignableFrom(MainViewModel::class.java) -> {
                val repoLista = ListaRepository(ListDataSource())
                return MainViewModel(repoLista) as T
            }
        }
        return super.create(modelClass)
    }
}
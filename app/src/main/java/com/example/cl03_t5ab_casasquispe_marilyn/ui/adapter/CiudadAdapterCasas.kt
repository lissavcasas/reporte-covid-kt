package com.example.cl03_t5ab_casasquispe_marilyn.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.cl03_t5ab_casasquispe_marilyn.databinding.ItemCityBinding
import com.example.cl03_t5ab_casasquispe_marilyn.entidad.CiudadCasas


class CiudadAdapterCasas(val lista: List<CiudadCasas>) :
    Adapter<CiudadAdapterCasas.CiudadViewHolderCasas>() {
    class CiudadViewHolderCasas(private val binding: ItemCityBinding) : ViewHolder(binding.root) {
        fun bind(ciudadCasas: CiudadCasas) {
            binding.lblConfirmed.text = ciudadCasas.confirmed.toString()
            binding.lblDeaths.text = ciudadCasas.deaths.toString()
            binding.lblRegion.text = ciudadCasas.region.province
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CiudadViewHolderCasas {
        val view = ItemCityBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CiudadViewHolderCasas(view)
    }

    override fun getItemCount(): Int {
        return lista.size
    }

    override fun onBindViewHolder(holder: CiudadViewHolderCasas, index: Int) {
        val ciudadCasas = lista[index]
        holder.bind(ciudadCasas)
    }
}
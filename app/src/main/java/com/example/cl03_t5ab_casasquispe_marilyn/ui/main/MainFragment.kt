package com.example.cl03_t5ab_casasquispe_marilyn.ui.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.cl03_t5ab_casasquispe_marilyn.R
import androidx.fragment.app.viewModels
import com.example.cl03_t5ab_casasquispe_marilyn.databinding.FragmentMainBinding
import com.example.cl03_t5ab_casasquispe_marilyn.ui.adapter.CiudadAdapterCasas
import com.google.android.material.dialog.MaterialAlertDialogBuilder


class MainFragment : Fragment() {

    private var _binding: FragmentMainBinding? = null
    val binding get() = _binding!!

    companion object {
        fun newInstance() = MainFragment()
    }

    private val viewModel: MainViewModel by viewModels {
        ViewModelFactory()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.obtenerCiudades()

        viewModel.ciudades.observe(viewLifecycleOwner) { data ->
            val adapter = CiudadAdapterCasas(data)
            binding.rvCities.adapter = adapter
        }

        viewModel.error.observe(viewLifecycleOwner) { error ->
            MaterialAlertDialogBuilder(requireContext())
                .setTitle(getString(R.string.error))
                .setMessage(error.descripcion)
                .setPositiveButton(getString(R.string.aceptar), null)
                .show()
        }
    }
}
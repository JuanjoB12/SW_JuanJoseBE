package com.example.sw_juanjosebe.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.sw_juanjosebe.databinding.ItemPersonajeBinding

class PersonajeViewHolder(view: View): RecyclerView.ViewHolder(view) {
    val binding = ItemPersonajeBinding.bind(view)

    fun render (personajeModel: com.example.sw_juanjosebe.Result){

        binding.TVNombre.text = personajeModel.name
        binding.TVAltura.text = personajeModel.height
        binding.TVnpeliculas.text = personajeModel.films.toString()

    }

}
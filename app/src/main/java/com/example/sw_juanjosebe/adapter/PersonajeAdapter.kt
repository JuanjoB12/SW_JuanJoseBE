package com.example.sw_juanjosebe.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.sw_juanjosebe.R

class PersonajeAdapter (var personajeList:List<com.example.sw_juanjosebe.Result>): RecyclerView.Adapter<PersonajeViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonajeViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return PersonajeViewHolder(layoutInflater.inflate(R.layout.item_personaje, parent, false))

    }

    override fun onBindViewHolder(holder: PersonajeViewHolder, position: Int) {
        val item = personajeList[position]
        holder.render(item)
    }

    override fun getItemCount(): Int {
        return personajeList.size
    }

}
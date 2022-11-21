package com.example.sw_juanjosebe

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.sw_juanjosebe.adapter.PersonajeAdapter
import com.example.sw_juanjosebe.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.recyclerView.layoutManager = LinearLayoutManager(this)

        val adapterPersonaje = PersonajeAdapter(emptyList())
        binding.recyclerView.adapter = adapterPersonaje
        binding.BotonVerListado.setOnClickListener{

            CoroutineScope(Dispatchers.IO).launch {
                val call = getRetrofit().create(APIService::class.java).getPersonaje("people/")
                val personaje = call.body()

                runOnUiThread{
                    if (call.isSuccessful){
                        val npersonaje = personaje?.results ?: emptyList()
                        adapterPersonaje.personajeList = npersonaje
                        adapterPersonaje.notifyDataSetChanged()


                    }
                    else{
                        Toast.makeText(this@MainActivity,"Ha ocurrido un error", Toast.LENGTH_SHORT).show()
                    }

                }
            }


        }
    }
    private fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://swapi.dev/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}
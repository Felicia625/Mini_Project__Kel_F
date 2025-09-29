package com.example.mini_project

import android.view.LayoutInflater
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import android.widget.ImageView
import com.example.mini_project.model.PokemonModel
import android.widget.LinearLayout
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import com.example.mini_project.model.PokemonType

// ViewHolder untuk menampilkan item Pokemon di RecyclerView
class PokemonViewHolder(
    private val containerView: View,
    private val imageLoader: ImageLoader
) : RecyclerView.ViewHolder(containerView) {

    // View komponen dari layout item
    private val pokemonNameView: TextView by lazy {
        containerView.findViewById(R.id.pokemon_name) // Nama Pokemon
    }
    private val pokemonImageView: ImageView by lazy {
        containerView.findViewById(R.id.pokemon_image) // Gambar Pokemon
    }
    private val pokemonTypeContainer: LinearLayout by lazy {
        containerView.findViewById(R.id.pokemon_type_container) // Container untuk tipe Pokemon
    }
    private val pokedexIdView: TextView by lazy {
        containerView.findViewById(R.id.pokedex_id) // ID Pokedex
    }
    private val pokemonDescriptionView: TextView by lazy {
        containerView.findViewById(R.id.pokemon_description) // Deskripsi Pokemon
    }

    /**
     * Fungsi untuk mengikat data dari PokemonModel ke dalam ViewHolder
     * @param pokemon data Pokemon yang akan ditampilkan
     * @param isGridMode apakah tampilan dalam mode grid atau list
     */
    fun bindData(pokemon: PokemonModel, isGridMode: Boolean = false) {

        // Load gambar Pokemon ke ImageView menggunakan Glide melalui ImageLoader
        pokemonImageView.let { imageLoader.loadImage(pokemon.imageUrl, it) }

        // Set nama dan ID Pokedex
        pokemonNameView.text = pokemon.name
        pokedexIdView.text = pokemon.pokedexId

        // Bersihkan container tipe agar tidak menumpuk
        pokemonTypeContainer.removeAllViews()

        // Tambahkan setiap tipe Pokemon ke dalam container
        for (type in pokemon.type) {
            // Inflate layout untuk tampilan tipe (CardView dengan TextView di dalamnya)
            val typeView = LayoutInflater.from(containerView.context)
                .inflate(R.layout.bg_type, pokemonTypeContainer, false) as CardView

            // Ambil TextView dari layout tipe dan isi dengan nama tipe
            val textView = typeView.findViewById<TextView>(R.id.pokemon_type)
            textView.text = type.name

            // Set warna background CardView sesuai tipe Pokemon
            typeView.setCardBackgroundColor(getTypeColor(type))

            // Tambahkan tampilan tipe ke container
            pokemonTypeContainer.addView(typeView)
        }

        // Jika bukan grid mode, tampilkan deskripsi (grid biasanya hanya gambar dan nama saja)
        if (!isGridMode) {
            pokemonDescriptionView.text = pokemon.description
        }
    }

    /**
     * Fungsi untuk menentukan warna berdasarkan tipe Pokemon
     * @param type tipe Pokemon (Normal, Water, Grass, dll)
     * @return warna dalam bentuk Int yang sudah diambil dari resources
     */
    private fun getTypeColor(type: PokemonType): Int {
        val context = containerView.context
        return when (type) {
            PokemonType.Normal -> ContextCompat.getColor(context, R.color.normal)
            PokemonType.Psychic -> ContextCompat.getColor(context, R.color.psychic)
            PokemonType.Water -> ContextCompat.getColor(context, R.color.water)
            PokemonType.Steel -> ContextCompat.getColor(context, R.color.steel)
            PokemonType.Ground -> ContextCompat.getColor(context, R.color.ground)
            PokemonType.Grass -> ContextCompat.getColor(context, R.color.grass)
            PokemonType.Electric -> ContextCompat.getColor(context, R.color.electric)
        }
    }
}

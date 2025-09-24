package com.example.mini_project

import android.view.LayoutInflater
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import android.widget.ImageView
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mini_project.model.PokemonModel
import com.example.mini_project.R
import android.widget.LinearLayout
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import com.example.mini_project.model.PokemonType

class PokemonViewHolder(private val containerView: View, private val imageLoader: ImageLoader) : RecyclerView.ViewHolder(containerView) {
    private val pokemonNameView: TextView by lazy{
        containerView.findViewById(R.id.pokemon_name)
    }
    private val pokemonImageView: ImageView by lazy{
        containerView.findViewById(R.id.pokemon_image)
    }
    private val pokemonTypeContainer: LinearLayout by lazy{
        containerView.findViewById(R.id.pokemon_type_container)
    }
    private val pokedexIdView: TextView by lazy{
        containerView.findViewById(R.id.pokedex_id)
    }
    private val pokemonDescriptionView: TextView by lazy{
        containerView.findViewById(R.id.pokemon_description)
    }

    fun bindData(pokemon: PokemonModel) {
        imageLoader.loadImage(pokemon.imageUrl, pokemonImageView)
        pokemonNameView.text = pokemon.name
        pokedexIdView.text = pokemon.pokedexId
        pokemonDescriptionView.text = pokemon.description

        pokemonTypeContainer.removeAllViews()
        for(type in pokemon.type){
            val typeView = LayoutInflater.from(containerView.context)
                .inflate(R.layout.bg_type, pokemonTypeContainer, false) as CardView

            val textView = typeView.findViewById<TextView>(R.id.pokemon_type)
            textView.text = type.name

            typeView.setCardBackgroundColor(getTypeColor(type))

            pokemonTypeContainer.addView(typeView)
        }
    }

    private fun getTypeColor(type: PokemonType): Int{
        val context = containerView.context
        return when(type){
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
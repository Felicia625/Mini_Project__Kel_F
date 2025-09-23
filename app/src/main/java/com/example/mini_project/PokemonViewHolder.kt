package com.example.mini_project

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import android.widget.ImageView
import com.example.mini_project.model.PokemonModel
import com.example.mini_project.R

class PokemonViewHolder(private val containerView: View, private val imageLoader: ImageLoader) : RecyclerView.ViewHolder(containerView) {
    private val pokemonNameView: TextView by lazy{
        containerView.findViewById(R.id.pokemon_name)
    }
    private val pokemonImageView: ImageView by lazy{
        containerView.findViewById(R.id.pokemon_image)
    }
    private val pokemonTypeView: TextView by lazy{
        containerView.findViewById(R.id.pokemon_type)
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
        pokemonTypeView.text = pokemon.type.joinToString(", ")
        pokedexIdView.text = pokemon.pokedexId
        pokemonDescriptionView.text = pokemon.description
    }

}
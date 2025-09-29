package com.example.mini_project.model

data class PokemonModel(
    val pokedexId: String,
    val name: String,
    val type: List<PokemonType>,
    val description: String,
    val imageUrl: String,
    val description_detail: String // Added new field
)
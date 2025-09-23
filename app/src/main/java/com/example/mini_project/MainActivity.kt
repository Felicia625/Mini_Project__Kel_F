package com.example.mini_project

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mini_project.model.PokemonModel
import com.example.mini_project.model.PokemonType
import androidx.recyclerview.widget.ItemTouchHelper

class MainActivity : AppCompatActivity() {
    private val recyclerView: RecyclerView by lazy {
        findViewById(R.id.pokemon_recycler)
    }

    private val pokemonAdapter by lazy{
        PokemonAdapter(layoutInflater, GlideImageLoader(this))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        recyclerView.adapter = pokemonAdapter

        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        pokemonAdapter.setData(
            listOf(
                PokemonModel(
                    "#0025",
                    "Pikachu",
                    listOf(PokemonType.Electric),
                    "Mouse Pokémon",
                    "https://assets.pokemon.com/assets/cms2/img/pokedex/full/025.png"
                ),
                PokemonModel(
                    "#0054",
                    "Psyduck",
                    listOf(PokemonType.Water),
                    "Duck Pokémon",
                    "https://assets.pokemon.com/assets/cms2/img/pokedex/full/054.png"
                ),
                PokemonModel(
                    "#0079",
                    "Slowpoke",
                    listOf(PokemonType.Water, PokemonType.Psychic),
                    "Dopey Pokémon",
                    "https://assets.pokemon.com/assets/cms2/img/pokedex/full/079.png"
                ),
                PokemonModel(
                    "#0132",
                    "Ditto",
                    listOf(PokemonType.Normal),
                    "Transform Pokémon",
                    "https://assets.pokemon.com/assets/cms2/img/pokedex/full/132.png"
                ),
                PokemonModel(
                    "#0143",
                    "Snorlax",
                    listOf(PokemonType.Normal),
                    "Sleeping Pokémon",
                    "https://assets.pokemon.com/assets/cms2/img/pokedex/full/143.png"
                ),
                PokemonModel(
                    "#0150",
                    "Mewtwo",
                    listOf(PokemonType.Psychic),
                    "Genetic Pokémon",
                    "https://assets.pokemon.com/assets/cms2/img/pokedex/full/150.png"
                ),
                PokemonModel(
                    "#0194",
                    "Wooper",
                    listOf(PokemonType.Water, PokemonType.Ground),
                    "Water Fish Pokémon",
                    "https://assets.pokemon.com/assets/cms2/img/pokedex/full/194.png"
                ),
                PokemonModel(
                    "#0385",
                    "Jirachi",
                    listOf(PokemonType.Psychic, PokemonType.Steel),
                    "Wish Pokémon",
                    "https://assets.pokemon.com/assets/cms2/img/pokedex/full/385.png"
                ),
                PokemonModel(
                    "#0393",
                    "Piplup",
                    listOf(PokemonType.Water),
                    "Penguin Pokémon",
                    "https://assets.pokemon.com/assets/cms2/img/pokedex/full/393.png"
                ),
                PokemonModel(
                    "#0492",
                    "Shaymin",
                    listOf(PokemonType.Grass),
                    "Gratitude Pokémon",
                    "https://assets.pokemon.com/assets/cms2/img/pokedex/full/492.png"
                ),
                PokemonModel(
                    "#0501",
                    "Oshawott",
                    listOf(PokemonType.Water),
                    "Sea Otter Pokémon",
                    "https://assets.pokemon.com/assets/cms2/img/pokedex/full/501.png"
                )
            )
        )

        val itemTouchHelper = ItemTouchHelper(pokemonAdapter.swipteToDeleteCallback)
        itemTouchHelper.attachToRecyclerView(recyclerView)
    }
}
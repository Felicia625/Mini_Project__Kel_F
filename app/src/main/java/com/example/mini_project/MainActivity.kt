package com.example.mini_project

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mini_project.model.PokemonModel
import com.example.mini_project.model.PokemonType
import androidx.recyclerview.widget.ItemTouchHelper
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {

    private val recyclerView: RecyclerView by lazy {
        findViewById(R.id.pokemon_recycler)
    }

    private val pokemonAdapter by lazy{
        PokemonAdapter(layoutInflater, GlideImageLoader(this))
    }

    var isGrid = false

    override fun onOptionsItemSelected(item: MenuItem): Boolean{
        return when(item.itemId){
            R.id.action_toggle->{
                toggleLayout(item)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun toggleLayout(item: MenuItem){
        isGrid = !isGrid
        pokemonAdapter.isGridMode = isGrid
        recyclerView.layoutManager = if(isGrid) GridLayoutManager(this, 2) else LinearLayoutManager(this)
        recyclerView.adapter = pokemonAdapter

        if(isGrid) {
            item.setIcon(R.drawable.view_list_24px)
        }else{
            item.setIcon(R.drawable.baseline_grid_view_24)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val fab: FloatingActionButton = findViewById(R.id.fab)

        recyclerView.adapter = pokemonAdapter
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        fab.setOnClickListener{
            isGrid = !isGrid
            pokemonAdapter.isGridMode = isGrid
            recyclerView.layoutManager = if(isGrid) GridLayoutManager(this, 2) else LinearLayoutManager(this)


        }

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

        val itemTouchHelper = ItemTouchHelper(pokemonAdapter.swipeToDeleteCallback)
        itemTouchHelper.attachToRecyclerView(recyclerView)
    }
}
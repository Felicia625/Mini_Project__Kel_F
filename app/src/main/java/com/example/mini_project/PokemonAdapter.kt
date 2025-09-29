package com.example.mini_project

import android.util.Log
import android.view.LayoutInflater
import androidx.recyclerview.widget.RecyclerView
import com.example.mini_project.model.PokemonModel
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.ItemTouchHelper

/**
 * Adapter untuk RecyclerView yang menampilkan daftar Pokémon.
 * Mendukung 2 mode tampilan: List dan Grid.
 * Juga menyediakan fitur swipe-to-delete dan navigasi ke DetailFragment.
 */
class PokemonAdapter(
    private val layoutInflater: LayoutInflater,
    private val imageLoader: ImageLoader
) : RecyclerView.Adapter<PokemonViewHolder>() {

    // Data Pokémon yang akan ditampilkan
    private val pokemons = mutableListOf<PokemonModel>()

    // Callback swipe-to-delete yang digunakan oleh ItemTouchHelper
    val swipeToDeleteCallback = SwipeDeleteCallback()

    /**
     * Mengisi ulang data Pokémon di adapter.
     * Dipanggil setiap kali repository mengirimkan data baru.
     */
    fun setData(newPokemons: List<PokemonModel>) {
        pokemons.clear()
        pokemons.addAll(newPokemons)
        notifyDataSetChanged() // Refresh semua item
    }

    /**
     * Menghapus item Pokémon dari daftar (dipanggil saat user swipe item).
     */
    fun removeItem(position: Int) {
        pokemons.removeAt(position)
        notifyItemRemoved(position)
    }

    // Flag untuk mode tampilan (true = grid, false = list)
    var isGridMode: Boolean = false

    /**
     * Tentukan tipe view berdasarkan mode tampilan (Grid atau List).
     */
    override fun getItemViewType(position: Int): Int {
        return if (isGridMode) 1 else 0
    }

    /**
     * Membuat ViewHolder baru untuk item Pokémon.
     * Layout yang digunakan tergantung pada mode tampilan.
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonViewHolder {
        val layout = if (viewType == 1) {
            R.layout.pokemon_grid_item // layout grid
        } else {
            R.layout.pokemon_list // layout list
        }
        val containerView = LayoutInflater.from(parent.context).inflate(layout, parent, false)
        return PokemonViewHolder(containerView, imageLoader)
    }

    // Mengembalikan jumlah item di daftar
    override fun getItemCount() = pokemons.size

    /**
     * Mengikat data Pokémon ke ViewHolder.
     * Juga menambahkan click listener untuk navigasi ke DetailFragment.
     */
    override fun onBindViewHolder(holder: PokemonViewHolder, position: Int) {
        val pokemon = pokemons[position]
        holder.bindData(pokemon, isGridMode)

        // Klik item → navigasi ke DetailFragment
        holder.itemView.setOnClickListener {
            val pokemonId = pokemon.pokedexId
            Log.d("PokemonAdapter", "Clicked on Pokemon ID: $pokemonId from item at position: $position")

            try {
                // Gunakan SafeArgs untuk membuat action ke DetailFragment
                val action = PokemonListFragmentDirections
                    .actionPokemonListFragmentToDetailFragment(pokemonId)

                // Jalankan navigasi
                holder.itemView.findNavController().navigate(action)
                Log.d("PokemonAdapter", "Navigation action created and navigate() called.")
            } catch (e: Exception) {
                Log.e("PokemonAdapter", "Navigation failed. Error: ${e.message}", e)
            }
        }
    }

    /**
     * Inner class untuk menangani swipe-to-delete dengan ItemTouchHelper.
     */
    inner class SwipeDeleteCallback : ItemTouchHelper.SimpleCallback(
        0, ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT
    ) {
        // Tidak perlu mendukung drag-and-drop, jadi return false
        override fun onMove(
            recyclerView: RecyclerView,
            viewHolder: RecyclerView.ViewHolder,
            target: RecyclerView.ViewHolder
        ): Boolean {
            return false
        }

        // Tentukan arah swipe yang didukung
        override fun getMovementFlags(
            recyclerView: RecyclerView,
            viewHolder: RecyclerView.ViewHolder
        ) = if (viewHolder is PokemonViewHolder) {
            makeMovementFlags(
                ItemTouchHelper.ACTION_STATE_IDLE,
                ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT
            ) or makeMovementFlags(
                ItemTouchHelper.ACTION_STATE_SWIPE,
                ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT
            )
        } else {
            0
        }

        // Hapus item dari daftar ketika di-swipe
        override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
            val position = viewHolder.bindingAdapterPosition
            removeItem(position)
        }
    }
}

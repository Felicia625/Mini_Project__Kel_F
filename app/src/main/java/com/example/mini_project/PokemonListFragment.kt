package com.example.mini_project

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mini_project.model.PokemonRepository
import com.google.android.material.floatingactionbutton.FloatingActionButton

// Fragment untuk menampilkan daftar Pokemon (dalam bentuk list atau grid)
class PokemonListFragment : Fragment(R.layout.fragment_pokemon_list) {

    // Variabel UI & adapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var pokemonAdapter: PokemonAdapter
    private lateinit var fab: FloatingActionButton
    private var isGrid = false // flag untuk menandai apakah tampilan grid atau list

    // Dipanggil ketika fragment sudah dibuat dan view sudah siap digunakan
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Hubungkan RecyclerView dan FAB dari layout XML
        recyclerView = view.findViewById(R.id.pokemon_recycler_view_in_fragment)
        fab = view.findViewById(R.id.fab_in_fragment)

        // Buat adapter dengan GlideImageLoader untuk load gambar Pokemon
        pokemonAdapter = PokemonAdapter(layoutInflater, GlideImageLoader(requireContext()))

        // Pasang adapter dan layout awalnya (list/vertikal)
        recyclerView.adapter = pokemonAdapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        // Pasang swipe-to-delete ke RecyclerView
        ItemTouchHelper(pokemonAdapter.swipeToDeleteCallback).attachToRecyclerView(recyclerView)

        // FAB akan mengubah layout list <-> grid
        fab.setOnClickListener { toggleLayoutInternal() }

        // Load data Pokemon dari repository dan tampilkan
        loadPokemonData()
    }

    // Fungsi untuk toggle layout antara list dan grid
    private fun toggleLayoutInternal() {
        // Ubah nilai flag
        isGrid = !isGrid
        // Beritahu adapter untuk menyesuaikan tampilan item
        pokemonAdapter.isGridMode = isGrid

        // Atur layout manager sesuai mode
        recyclerView.layoutManager = if (isGrid) {
            GridLayoutManager(requireContext(), 2) // 2 kolom untuk grid
        } else {
            LinearLayoutManager(requireContext()) // list vertikal
        }

        // Ganti ikon FAB supaya sesuai mode
        fab.setImageResource(
            if (isGrid) R.drawable.view_list_24px
            else R.drawable.baseline_grid_view_24
        )
    }

    // Fungsi untuk load data Pokemon dari repository
    private fun loadPokemonData() {
        pokemonAdapter.setData(PokemonRepository.getPokemonList())
    }
}

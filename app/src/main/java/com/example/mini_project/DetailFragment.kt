package com.example.mini_project

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.example.mini_project.model.PokemonRepository
import com.example.mini_project.model.PokemonType

class DetailFragment : Fragment() {

    // Mengambil argument yang dikirim dari PokemonListFragment (Safe Args)
    private val args: DetailFragmentArgs by navArgs()

    /**
     * Dipanggil untuk membuat tampilan fragment.
     * Fungsi ini meng-inflate layout pokemon_details.xml
     */
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.pokemon_details, container, false)
    }

    /**
     * Dipanggil setelah view berhasil dibuat.
     * Di sini kita mengambil data pokemon berdasarkan ID yang dikirim,
     * lalu menampilkan detail pokemon (nama, deskripsi, gambar, dan tipe).
     */
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Ambil ID pokemon dari args (Safe Args)
        val receivedPokemonId = args.pokemonId
        Log.d("DetailFragment", "Received Pokemon ID: $receivedPokemonId")

        // Inisialisasi view yang ada di layout
        val pokedexIdTextView: TextView = view.findViewById(R.id.pokedex_id)
        val pokemonNameTextView: TextView = view.findViewById(R.id.pokemon_name)
        val pokemonDescriptionTextView: TextView = view.findViewById(R.id.pokemon_description)
        val pokemonImageView: ImageView = view.findViewById(R.id.pokemon_image)
        val pokemonTypeContainer: LinearLayout = view.findViewById(R.id.pokemon_type_container)

        // Cari pokemon berdasarkan ID
        val pokemon = PokemonRepository.getPokemonById(receivedPokemonId)

        if (pokemon != null) {
            // Set data pokemon ke TextView
            pokedexIdTextView.text = pokemon.pokedexId
            pokemonNameTextView.text = pokemon.name
            pokemonDescriptionTextView.text = pokemon.description_detail

            // Load gambar menggunakan Glide
            Glide.with(this)
                .load(pokemon.imageUrl)
                .placeholder(R.drawable.baseline_grid_view_24) // gambar sementara saat loading
                .error(R.drawable.view_list_24px) // gambar error jika gagal load
                .into(pokemonImageView)

            // Hapus view lama lalu tambahkan TextView untuk setiap tipe pokemon
            pokemonTypeContainer.removeAllViews()
            pokemon.type.forEach { type: PokemonType ->
                val typeView = TextView(requireContext()).apply {
                    text = type.name
                    val padding = (8 * resources.displayMetrics.density).toInt()
                    setPadding(padding, padding / 2, padding, padding / 2)
                    val marginEnd = (4 * resources.displayMetrics.density).toInt()
                    layoutParams = LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.WRAP_CONTENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT
                    ).apply {
                        this.marginEnd = marginEnd
                    }
                    // Set background sesuai warna type (ex: Electric = kuning)
                    setBackgroundColor(android.graphics.Color.parseColor(getTypeColor(type)))
                    setTextColor(android.graphics.Color.WHITE)
                }
                pokemonTypeContainer.addView(typeView)
            }
            Log.d("DetailFragment", "Displaying data for ${pokemon.name}")

        } else {
            // Jika pokemon tidak ditemukan
            pokedexIdTextView.text = receivedPokemonId
            pokemonNameTextView.text = "Pokemon Not Found"
            pokemonDescriptionTextView.text = "Could not load details for this Pokémon."
            Log.e("DetailFragment", "Pokemon with ID $receivedPokemonId not found in repository.")
        }
    }

    /**
     * Fungsi helper untuk mengembalikan warna background
     * sesuai dengan tipe Pokemon.
     */
    private fun getTypeColor(type: PokemonType): String {
        return when (type) {
            PokemonType.Electric -> "#FFD700"
            PokemonType.Water -> "#6495ED"
            PokemonType.Psychic -> "#FF69B4"
            PokemonType.Normal -> "#A8A878"
            PokemonType.Ground -> "#E0C068"
            PokemonType.Steel -> "#B8B8D0"
            PokemonType.Grass -> "#78C850"
            else -> "#CCCCCC" // default abu-abu
        }
    }
}
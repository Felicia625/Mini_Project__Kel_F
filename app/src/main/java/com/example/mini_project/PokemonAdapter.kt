package com.example.mini_project

import android.view.LayoutInflater
import androidx.recyclerview.widget.RecyclerView
import com.example.mini_project.model.PokemonModel
import android.view.ViewGroup
import androidx.recyclerview.widget.ItemTouchHelper


class PokemonAdapter(private val layoutInflater: LayoutInflater, private val imageLoader: ImageLoader) : RecyclerView.Adapter<PokemonViewHolder>() {
    private val pokemons = mutableListOf<PokemonModel>()

    val swipteToDeleteCallback = SwipeDeleteCallback()

    fun setData(newPokemons: List<PokemonModel>){
        pokemons.clear()
        pokemons.addAll(newPokemons)
        notifyDataSetChanged()
    }

    fun removeItem(position: Int){
        pokemons.removeAt(position)
        notifyItemRemoved(position)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonViewHolder {
        val containerView = layoutInflater.inflate(R.layout.pokemon_list, parent, false)
        return PokemonViewHolder(containerView, imageLoader)
    }

    override fun getItemCount() = pokemons.size
    override fun onBindViewHolder(holder: PokemonViewHolder, position: Int) {
        holder.bindData(pokemons[position])
    }

    inner class SwipeDeleteCallback : ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT){
        override fun onMove(
            recyclerView: RecyclerView,
            viewHolder: RecyclerView.ViewHolder,
            target: RecyclerView.ViewHolder
        ): Boolean {
            return false
        }

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

        override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
            val position = viewHolder.adapterPosition
            removeItem(position)
        }
    }
}
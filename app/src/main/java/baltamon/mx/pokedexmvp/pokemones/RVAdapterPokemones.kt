package baltamon.mx.pokedexmvp.pokemones

import android.content.Context
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import baltamon.mx.pokedexmvp.R
import baltamon.mx.pokedexmvp.extensions.inflate
import baltamon.mx.pokedexmvp.extensions.showToast
import baltamon.mx.pokedexmvp.models.NamedAPIResource
import baltamon.mx.pokedexmvp.pokemon_detail.PokemonDetailActivity
import baltamon.mx.pokedexmvp.viewholders.CVViewHolder

/**
 * Created by Baltazar Rodriguez on 02/07/2017.
 */

private const val INTENT_POKEMON_NAME = "pokemon_name"

class RVAdapterPokemones(val pokemones: ArrayList<NamedAPIResource>,
                         val context: Context): RecyclerView.Adapter<CVViewHolder>() {

    override fun onBindViewHolder(holder: CVViewHolder, position: Int) {
        holder.textView.text = pokemones[position].name
        holder.cv.setOnClickListener {
            val intent = Intent(context, PokemonDetailActivity::class.java)
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int = pokemones.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CVViewHolder =
            CVViewHolder(parent.inflate(R.layout.item_title))
}
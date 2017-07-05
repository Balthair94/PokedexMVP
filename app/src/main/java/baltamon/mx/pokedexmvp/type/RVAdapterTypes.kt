package baltamon.mx.pokedexmvp.type

import android.support.v4.app.FragmentManager
import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import baltamon.mx.pokedexmvp.R
import baltamon.mx.pokedexmvp.extensions.inflate
import baltamon.mx.pokedexmvp.models.NamedAPIResource
import baltamon.mx.pokedexmvp.viewholders.CVViewHolder

/**
 * Created by Baltazar Rodriguez on 05/07/2017.
 */
class RVAdapterTypes(val types: ArrayList<NamedAPIResource>): RecyclerView.Adapter<CVViewHolder>() {

    override fun onBindViewHolder(holder: CVViewHolder, position: Int) {
        holder.textView.text = types[position].name
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CVViewHolder =
    CVViewHolder(parent.inflate(R.layout.item_title))

    override fun getItemCount(): Int = types.size
}
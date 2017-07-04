package baltamon.mx.pokedexmvp.ability

import android.support.v4.app.FragmentManager
import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import baltamon.mx.pokedexmvp.R
import baltamon.mx.pokedexmvp.extensions.inflate
import baltamon.mx.pokedexmvp.models.Ability
import baltamon.mx.pokedexmvp.models.NamedAPIResource
import baltamon.mx.pokedexmvp.viewholders.CVViewHolder

/**
 * Created by Baltazar Rodriguez on 04/07/2017.
 */
class RVAdapterAbilities(val abilities: ArrayList<NamedAPIResource>,
                         val fragmentManager: FragmentManager): RecyclerView.Adapter<CVViewHolder>() {

    override fun onBindViewHolder(holder: CVViewHolder, position: Int) {
        holder.textView.text = abilities[position].name
        holder.cv.setOnClickListener {
            val dialogFragment = AbilityDialogFragment.newInstance(abilities[position].name)
            dialogFragment.show(fragmentManager, "Detail")
        }
    }

    override fun getItemCount(): Int = abilities.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CVViewHolder =
            CVViewHolder(parent.inflate(R.layout.item_title))
}
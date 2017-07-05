package baltamon.mx.pokedexmvp.move

import android.support.v4.app.FragmentManager
import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import baltamon.mx.pokedexmvp.R
import baltamon.mx.pokedexmvp.extensions.inflate
import baltamon.mx.pokedexmvp.models.NamedAPIResource
import baltamon.mx.pokedexmvp.viewholders.CVViewHolder

/**
 * Created by Baltazar Rodriguez on 04/07/2017.
 */
class RVAdapterMoves(val moves: ArrayList<NamedAPIResource>,
                     val fragmentManager: FragmentManager) : RecyclerView.Adapter<CVViewHolder>() {

    override fun onBindViewHolder(holder: CVViewHolder, position: Int) {
        holder.textView.text = moves[position].name
        holder.cv.setOnClickListener {
            val dialogFragment = MoveDialogFragment.newInstance(moves[position].name)
            dialogFragment.show(fragmentManager, "Detail")
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CVViewHolder =
            CVViewHolder(parent.inflate(R.layout.item_title))

    override fun getItemCount(): Int = moves.size
}
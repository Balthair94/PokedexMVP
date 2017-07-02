package baltamon.mx.pokedexmvp.viewholders

import android.support.v7.widget.RecyclerView
import android.view.View
import kotlinx.android.synthetic.main.item_title.view.*

/**
 * Created by Baltazar Rodriguez on 30/06/2017.
 */
class CVViewHolder (itemView: View): RecyclerView.ViewHolder(itemView){
    val cv = itemView.card_view
    val textView = itemView.tv_title_item
}
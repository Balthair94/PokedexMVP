package baltamon.mx.pokedexmvp.move

import android.os.Bundle
import android.os.Parcelable
import baltamon.mx.pokedexmvp.models.NamedAPIResource
import baltamon.mx.pokedexmvp.presenters.Presenter

/**
 * Created by Baltazar Rodriguez on 04/07/2017.
 */
class MovesPresenter(val view: MovesView, val arguments: Bundle): Presenter {

    val MY_OBJECT_KEY = "moves_list"
    var moves: ArrayList<NamedAPIResource>? = null

    override fun onCreate() {
        moves = arguments.getParcelableArrayList<Parcelable>(MY_OBJECT_KEY) as ArrayList<NamedAPIResource>
        view.onPokemonMoves(moves!!)
    }

    override fun onPause() {
    }

    override fun onResume() {
    }

    override fun onDestroy() {
    }
}
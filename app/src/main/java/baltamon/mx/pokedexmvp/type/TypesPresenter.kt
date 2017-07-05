package baltamon.mx.pokedexmvp.type

import android.os.Bundle
import android.os.Parcelable
import baltamon.mx.pokedexmvp.models.NamedAPIResource
import baltamon.mx.pokedexmvp.presenters.Presenter

/**
 * Created by Baltazar Rodriguez on 05/07/2017.
 */
class TypesPresenter(val view: TypesView, val arguments: Bundle): Presenter {

    val MY_OBJECT_KEY = "types_list"
    var types: ArrayList<NamedAPIResource>? = null

    override fun onCreate() {
        types = arguments.getParcelableArrayList<Parcelable>(MY_OBJECT_KEY) as ArrayList<NamedAPIResource>
        view.onPokemonTypes(types!!)
    }

    override fun onPause() {
    }

    override fun onResume() {
    }

    override fun onDestroy() {
    }
}
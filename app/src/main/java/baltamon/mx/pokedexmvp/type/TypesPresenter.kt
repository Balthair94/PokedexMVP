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

    override fun onCreate() {
        val types = arguments.getParcelableArrayList<Parcelable>(MY_OBJECT_KEY) as ArrayList<NamedAPIResource>
        view.onPokemonTypes(types)
    }
}
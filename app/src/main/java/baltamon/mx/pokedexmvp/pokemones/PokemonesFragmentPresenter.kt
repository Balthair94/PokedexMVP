package baltamon.mx.pokedexmvp.pokemones

import android.os.Bundle
import android.os.Parcelable
import baltamon.mx.pokedexmvp.models.NamedAPIResource
import baltamon.mx.pokedexmvp.presenters.Presenter

/**
 * Created by Baltazar Rodriguez on 02/07/2017.
 */
class PokemonesFragmentPresenter(val view: PokemonesFragmentView, val arguments: Bundle): Presenter {

    val MY_OBJECT_KEY = "pokemones_list"

    override fun onCreate() {
        val pokemones = arguments.getParcelableArrayList<Parcelable> (MY_OBJECT_KEY) as ArrayList<NamedAPIResource>
        view.showPokemonesList(pokemones)
    }

}
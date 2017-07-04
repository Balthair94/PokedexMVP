package baltamon.mx.pokedexmvp.ability

import android.os.Bundle
import baltamon.mx.pokedexmvp.models.NamedAPIResource
import baltamon.mx.pokedexmvp.presenters.Presenter

/**
 * Created by Baltazar Rodriguez on 04/07/2017.
 */
class AbilitiesPresenter(val view: AbilitiesView, val arguments: Bundle): Presenter {

    val MY_OBJECT_KEY = "abilities_list"
    var abilities: ArrayList<NamedAPIResource>? = null

    override fun onCreate() {
        abilities = arguments.getIntegerArrayList(MY_OBJECT_KEY) as ArrayList<NamedAPIResource>
        view.onPokemonAbilities(abilities!!)
    }

    override fun onPause() {
    }

    override fun onResume() {
    }

    override fun onDestroy() {
    }

}
package baltamon.mx.pokedexmvp.pokemones

import android.view.View
import baltamon.mx.pokedexmvp.models.NamedAPIResource
import baltamon.mx.pokedexmvp.presenters.Presenter

/**
 * Created by Baltazar Rodriguez on 02/07/2017.
 */
class PokemonesFragmentPresenter(val view: PokemonesFragmentView): Presenter {

    var pokemones: ArrayList<NamedAPIResource>? = null

    fun setPokemonesList(list: ArrayList<NamedAPIResource>){
        pokemones = list
    }

    fun loadPokemonesList(){
        view.showPokemonesList(pokemones!!)
    }

    override fun onCreate() {
    }

    override fun onPause() {
    }

    override fun onResume() {
    }

    override fun onDestroy() {
    }

}
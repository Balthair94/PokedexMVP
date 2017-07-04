package baltamon.mx.pokedexmvp.about_pokemon

import android.os.Bundle
import android.os.Parcelable
import baltamon.mx.pokedexmvp.models.Pokemon
import baltamon.mx.pokedexmvp.presenters.Presenter

/**
 * Created by Baltazar Rodriguez on 03/07/2017.
 */
class AboutPokemonPresenter(val view: AboutPokemonView, val arguments: Bundle): Presenter {

    val MY_OBJECT_KEY = "pokemon"
    var pokemon: Pokemon? = null

    override fun onCreate() {
        pokemon = arguments.getParcelable<Parcelable>(MY_OBJECT_KEY) as Pokemon
        view.onPokemonInformation(pokemon!!)
    }

    override fun onPause() {
    }

    override fun onResume() {
    }

    override fun onDestroy() {
    }

}
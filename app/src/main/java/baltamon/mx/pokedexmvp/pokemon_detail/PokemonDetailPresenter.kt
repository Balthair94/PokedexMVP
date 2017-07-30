package baltamon.mx.pokedexmvp.pokemon_detail

import android.app.ProgressDialog
import android.content.Context
import android.content.Intent
import baltamon.mx.pokedexmvp.extensions.showLoadDialog
import baltamon.mx.pokedexmvp.extensions.showToast
import baltamon.mx.pokedexmvp.models.Pokemon
import baltamon.mx.pokedexmvp.presenters.Presenter
import baltamon.mx.pokedexmvp.providers.PokemonProvider
import baltamon.mx.pokedexmvp.providers.PokemonProviderInterface

/**
 * Created by Baltazar Rodriguez on 03/07/2017.
 */
class PokemonDetailPresenter(val view: PokemonDetailView,
                             val context: Context,
                             val intent: Intent): Presenter, PokemonProviderInterface {

    val INTENT_POKEMON_NAME = "pokemon_name"
    var provider = PokemonProvider(this)
    var dialog: ProgressDialog? = null
    var pokemon: Pokemon? = null

    override fun onCreate() {
        loadPokemon()
    }

    fun loadPokemon(){
        dialog = context.showLoadDialog()
        val pokemonName = intent.getStringExtra(INTENT_POKEMON_NAME)
        provider.loadPokemon(pokemonName)
    }

    override fun onSuccess(pokemon: Pokemon) {
        dialog?.dismiss()
        this.pokemon = pokemon
        view.onLoadTabView(pokemon)
    }

    override fun onFailure(fail: String) {
        dialog?.dismiss()
        context.showToast(fail)
    }
}
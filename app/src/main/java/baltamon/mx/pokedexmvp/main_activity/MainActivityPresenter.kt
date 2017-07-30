package baltamon.mx.pokedexmvp.main_activity

import android.app.ProgressDialog
import android.content.Context
import android.support.v4.app.Fragment
import baltamon.mx.pokedexmvp.extensions.showLoadDialog
import baltamon.mx.pokedexmvp.extensions.showToast
import baltamon.mx.pokedexmvp.models.Generation
import baltamon.mx.pokedexmvp.move.MovesFragment
import baltamon.mx.pokedexmvp.presenters.Presenter
import baltamon.mx.pokedexmvp.providers.GenerationProvider
import baltamon.mx.pokedexmvp.providers.GenerationProviderInterface
import baltamon.mx.pokedexmvp.pokemones.PokemonesFragment
import baltamon.mx.pokedexmvp.type.TypesFragment

/**
 * Created by Baltazar Rodriguez on 28/06/2017.
 */
class MainActivityPresenter(val view: MainActivityView,
                            val context: Context) : Presenter, GenerationProviderInterface {

    val provider = GenerationProvider(this)
    var dialog: ProgressDialog? = null

    override fun onCreate() {
        dialog = context.showLoadDialog()
        provider.loadPokemonGeneration()
    }

    fun loadFragment(fragmentId: Int, generation: Generation) {
        val replaceFragment = when (fragmentId) {
            1 -> PokemonesFragment.newInstance(generation.pokemon_species)
            2 -> MovesFragment.newInstance(generation.moves)
            3 -> context.showToast("NO DATA")
            4 -> TypesFragment.newInstance(generation.types)
            else -> context.showToast("No valid fragment")
        }

        if (replaceFragment is Fragment)
            view.onFragmentSelected(replaceFragment)
        else
            view.onFragmentFailure("View no available")
    }

    override fun onSuccess(generation: Generation) {
        dialog?.dismiss()
        loadFragment(1, generation)
    }

    override fun onFailure(fail: String) {
        dialog?.dismiss()
        context.showToast(fail)
    }

}
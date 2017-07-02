package baltamon.mx.pokedexmvp.main_activity

import android.app.ProgressDialog
import android.content.Context
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import baltamon.mx.pokedexmvp.R
import baltamon.mx.pokedexmvp.extensions.showLoadDialog
import baltamon.mx.pokedexmvp.extensions.showToast
import baltamon.mx.pokedexmvp.models.Generation
import baltamon.mx.pokedexmvp.presenters.Presenter
import baltamon.mx.pokedexmvp.providers.GenerationProvider
import baltamon.mx.pokedexmvp.providers.GenerationProviderInterface
import baltamon.mx.pokedexmvp.pokemones.PokemonesFragment

/**
 * Created by Baltazar Rodriguez on 28/06/2017.
 */
class MainActivityPresenter(val view: MainActivityView,
                            val context: Context,
                            val supportFragmentManager: FragmentManager): Presenter, GenerationProviderInterface {

    val provider = GenerationProvider(this)
    var generation: Generation? = null
    var dialog: ProgressDialog? = null

    override fun onCreate() {
        dialog = context.showLoadDialog()
        provider.loadPokemonGeneration()
    }

    fun loadFragment(fragmentId: Int, generation: Generation) {
        val replaceFragment = when (fragmentId){
            1 -> PokemonesFragment.newInstance(generation.pokemon_species)
            else -> context.showToast("No valid fragment")
        }

        if (replaceFragment is Fragment)
            supportFragmentManager.beginTransaction()
                    .replace(R.id.frame_layout, replaceFragment)
                    .commit()
    }

    override fun onPause() {
    }

    override fun onResume() {
    }

    override fun onDestroy() {
    }

    override fun onSuccess(generation: Generation) {
        dialog!!.dismiss()
        this.generation = generation
        loadFragment(1, generation)
    }

    override fun onFailure(fail: String) {
        dialog!!.dismiss()
        context.showToast(fail)
    }

}
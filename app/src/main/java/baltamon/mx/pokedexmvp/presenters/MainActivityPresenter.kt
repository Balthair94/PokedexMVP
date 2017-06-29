package baltamon.mx.pokedexmvp.presenters

import android.app.ProgressDialog
import android.content.Context
import baltamon.mx.pokedexmvp.extensions.showLoadDialog
import baltamon.mx.pokedexmvp.extensions.showToast
import baltamon.mx.pokedexmvp.models.Generation
import baltamon.mx.pokedexmvp.providers.GenerationProvider
import baltamon.mx.pokedexmvp.providers.GenerationProviderInterface
import baltamon.mx.pokedexmvp.views.MainActivityView

/**
 * Created by Baltazar Rodriguez on 28/06/2017.
 */
class MainActivityPresenter(val view: MainActivityView, val context: Context): Presenter, GenerationProviderInterface {

    val provider = GenerationProvider(this)
    var generation: Generation? = null
    var dialog: ProgressDialog? = null

    override fun onCreate() {
        dialog = context.showLoadDialog()
        provider.loadPokemonGeneration()
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
        view.loadFragment(1, generation)
    }

    override fun onFailure(fail: String) {
        dialog!!.dismiss()
        context.showToast(fail)
    }

}
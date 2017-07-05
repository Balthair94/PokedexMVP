package baltamon.mx.pokedexmvp.move

import baltamon.mx.pokedexmvp.models.Move
import baltamon.mx.pokedexmvp.presenters.Presenter
import baltamon.mx.pokedexmvp.providers.MoveProvider
import baltamon.mx.pokedexmvp.providers.MoveProviderInterface

/**
 * Created by Baltazar Rodriguez on 04/07/2017.
 */
class MovePresenter(val view: MoveView, val moveName: String): Presenter, MoveProviderInterface {

    val provider = MoveProvider(this)
    var move: Move? = null

    override fun onCreate() {
        provider.loadMove(moveName)
    }

    override fun onPause() {
    }

    override fun onResume() {
    }

    override fun onDestroy() {
    }

    override fun onSuccess(move: Move) {
        view.onPokemonMove(move)
    }

    override fun onFailure(text: String) {
        view.onFailure(text)
    }
}
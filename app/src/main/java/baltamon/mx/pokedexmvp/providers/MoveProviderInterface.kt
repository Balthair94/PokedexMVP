package baltamon.mx.pokedexmvp.providers

import baltamon.mx.pokedexmvp.models.Move

/**
 * Created by Baltazar Rodriguez on 04/07/2017.
 */
interface MoveProviderInterface {
    fun onSuccess(move: Move)
    fun onFailure(text: String)
}
package baltamon.mx.pokedexmvp.move

import baltamon.mx.pokedexmvp.models.Move

/**
 * Created by Baltazar Rodriguez on 04/07/2017.
 */
interface MoveView {
    fun onPokemonMove(move: Move)
    fun onFailure(text: String)
}
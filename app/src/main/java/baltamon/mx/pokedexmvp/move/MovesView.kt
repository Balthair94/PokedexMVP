package baltamon.mx.pokedexmvp.move

import baltamon.mx.pokedexmvp.models.NamedAPIResource

/**
 * Created by Baltazar Rodriguez on 04/07/2017.
 */
interface MovesView {
    fun onPokemonMoves(moves: ArrayList<NamedAPIResource>)
}
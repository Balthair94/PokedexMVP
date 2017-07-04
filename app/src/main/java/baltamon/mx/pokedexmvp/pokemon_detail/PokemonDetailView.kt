package baltamon.mx.pokedexmvp.pokemon_detail

import baltamon.mx.pokedexmvp.models.Pokemon

/**
 * Created by Baltazar Rodriguez on 03/07/2017.
 */
interface PokemonDetailView {
    fun onLoadTabView(pokemon: Pokemon)
}
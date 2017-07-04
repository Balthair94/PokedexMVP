package baltamon.mx.pokedexmvp.about_pokemon

import baltamon.mx.pokedexmvp.models.Pokemon

/**
 * Created by Baltazar Rodriguez on 03/07/2017.
 */
interface AboutPokemonView {
    fun onPokemonInformation(pokemon: Pokemon)
}
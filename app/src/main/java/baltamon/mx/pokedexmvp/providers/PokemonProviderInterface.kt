package baltamon.mx.pokedexmvp.providers

import baltamon.mx.pokedexmvp.models.Pokemon

/**
 * Created by Baltazar Rodriguez on 03/07/2017.
 */
interface PokemonProviderInterface {
    fun onSuccess(pokemon: Pokemon)
    fun onFailure(fail: String)
}
package baltamon.mx.pokedexmvp.providers

import baltamon.mx.pokedexmvp.models.Generation

/**
 * Created by Baltazar Rodriguez on 28/06/2017.
 */
interface GenerationProviderInterface {
    fun onSuccess(generation: Generation)
    fun onFailure(fail: String)
}
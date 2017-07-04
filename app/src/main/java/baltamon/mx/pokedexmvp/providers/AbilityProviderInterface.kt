package baltamon.mx.pokedexmvp.providers

import baltamon.mx.pokedexmvp.models.Ability

/**
 * Created by Baltazar Rodriguez on 04/07/2017.
 */
interface AbilityProviderInterface {
    fun onSuccess(ability: Ability)
    fun onFailure(fail: String)
}
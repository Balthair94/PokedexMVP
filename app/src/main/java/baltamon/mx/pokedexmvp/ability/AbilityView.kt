package baltamon.mx.pokedexmvp.ability

import baltamon.mx.pokedexmvp.models.Ability

/**
 * Created by Baltazar Rodriguez on 04/07/2017.
 */
interface AbilityView {
    fun onFailure(text: String)
    fun onAbilityInformation(ability: Ability)
}
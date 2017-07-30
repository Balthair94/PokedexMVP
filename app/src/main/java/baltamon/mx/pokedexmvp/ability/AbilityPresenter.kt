package baltamon.mx.pokedexmvp.ability

import baltamon.mx.pokedexmvp.models.Ability
import baltamon.mx.pokedexmvp.presenters.Presenter
import baltamon.mx.pokedexmvp.providers.AbilityProvider
import baltamon.mx.pokedexmvp.providers.AbilityProviderInterface

/**
 * Created by Baltazar Rodriguez on 04/07/2017.
 */
class AbilityPresenter(val view: AbilityView, val abilityName: String): Presenter, AbilityProviderInterface {

    val provider = AbilityProvider(this)
    var ability: Ability? = null

    override fun onCreate() {
        provider.loadAbility(abilityName)
    }

    override fun onSuccess(ability: Ability) {
        this.ability = ability
        view.onAbilityInformation(ability)
    }

    override fun onFailure(fail: String) {
        view.onFailure(fail)
    }

}
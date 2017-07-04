package baltamon.mx.pokedexmvp.ability

import baltamon.mx.pokedexmvp.models.NamedAPIResource

/**
 * Created by Baltazar Rodriguez on 04/07/2017.
 */
interface AbilitiesView {
    fun onPokemonAbilities(abilities: ArrayList<NamedAPIResource>)
}
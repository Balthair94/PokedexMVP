package baltamon.mx.pokedexmvp.pokemones

import baltamon.mx.pokedexmvp.models.NamedAPIResource

/**
 * Created by Baltazar Rodriguez on 02/07/2017.
 */
interface PokemonesFragmentView {
    fun showPokemonesList(pokemones: ArrayList<NamedAPIResource>)
}
package baltamon.mx.pokedexmvp.type

import baltamon.mx.pokedexmvp.models.NamedAPIResource

/**
 * Created by Baltazar Rodriguez on 05/07/2017.
 */
interface TypesView {
    fun onPokemonTypes(types: ArrayList<NamedAPIResource>)
}
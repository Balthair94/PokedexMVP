package baltamon.mx.pokedexmvp.pokemon_detail

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import baltamon.mx.pokedexmvp.ability.AbilitiesFragment
import baltamon.mx.pokedexmvp.about_pokemon.AboutPokemonFragment
import baltamon.mx.pokedexmvp.models.NamedAPIResource
import baltamon.mx.pokedexmvp.models.Pokemon
import baltamon.mx.pokedexmvp.move.MovesFragment

/**
 * Created by Baltazar Rodriguez on 02/07/2017.
 */
class TabPokemonFragmentAdapter(fm: FragmentManager, val pokemon: Pokemon): FragmentPagerAdapter(fm) {

    val titles = arrayOf("About", "Abilities", "Moves")

    override fun getItem(position: Int): Fragment =
        when (position) {
            0 -> AboutPokemonFragment.newInstance(pokemon)
            1 -> {
                val abilities: ArrayList<NamedAPIResource> = ArrayList()
                pokemon.abilities.mapTo(abilities) { it.ability }
                AbilitiesFragment.newInstance(abilities)
            }
            else -> {
                val moves: ArrayList<NamedAPIResource> = ArrayList()
                pokemon.moves.mapTo(moves) { it.move }
                MovesFragment.newInstance(moves)
            }
        }

    override fun getCount(): Int = titles.size

    override fun getPageTitle(position: Int): CharSequence = titles[position]

}
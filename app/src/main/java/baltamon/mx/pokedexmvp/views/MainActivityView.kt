package baltamon.mx.pokedexmvp.views

import baltamon.mx.pokedexmvp.models.Generation

/**
 * Created by Baltazar Rodriguez on 28/06/2017.
 */
interface MainActivityView {
    fun loadFragment(fragmentId: Int, generation: Generation)
}
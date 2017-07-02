package baltamon.mx.pokedexmvp.pokemones

import android.os.Bundle
import android.support.v4.app.Fragment
import baltamon.mx.pokedexmvp.R
import baltamon.mx.pokedexmvp.models.NamedAPIResource


/**
 * Created by Baltazar Rodriguez on 27/06/2017.
 */

private const val MY_OBJECT_KEY = "pokemones_list"

class PokemonesFragment: Fragment() {

    companion object {
        fun newInstance(pokemones: ArrayList<NamedAPIResource>): PokemonesFragment {
            val fragment = PokemonesFragment()
            val bundle = Bundle()
            bundle.putParcelableArrayList(MY_OBJECT_KEY, pokemones)
            fragment.arguments = bundle
            return fragment
        }
    }

    override fun onCreateView(inflater: android.view.LayoutInflater,
                              container: android.view.ViewGroup?,
                              savedInstanceState: android.os.Bundle?): android.view.View? {
        val view = inflater.inflate(R.layout.fragment_pokemones,
                container, false)
        return view
    }

}
package baltamon.mx.pokedexmvp.pokemones

import android.os.Bundle
import android.os.Parcelable
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import baltamon.mx.pokedexmvp.R
import baltamon.mx.pokedexmvp.models.NamedAPIResource
import kotlinx.android.synthetic.main.recycler_view.*


/**
 * Created by Baltazar Rodriguez on 27/06/2017.
 */

private const val MY_OBJECT_KEY = "pokemones_list"

class PokemonesFragment: Fragment(), PokemonesFragmentView {

    var presenter: PokemonesFragmentPresenter? = null

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
        return inflater.inflate(R.layout.fragment_list, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter = PokemonesFragmentPresenter(this, arguments)
        presenter?.onCreate()
    }

    override fun showPokemonesList(pokemones: ArrayList<NamedAPIResource>) {
        recycler_view.setHasFixedSize(true)
        recycler_view.layoutManager = LinearLayoutManager(context)
        recycler_view.adapter = RVAdapterPokemones(pokemones, context)
    }

}
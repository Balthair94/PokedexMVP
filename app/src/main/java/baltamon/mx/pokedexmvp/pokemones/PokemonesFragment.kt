package baltamon.mx.pokedexmvp.pokemones

import android.os.Bundle
import android.os.Parcelable
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import baltamon.mx.pokedexmvp.R
import baltamon.mx.pokedexmvp.models.NamedAPIResource


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

    override fun onCreate(savedInstanceState: Bundle?) {
        presenter = PokemonesFragmentPresenter(this)
        presenter!!.setPokemonesList(arguments.getParcelableArrayList<Parcelable>
        (MY_OBJECT_KEY) as ArrayList<NamedAPIResource>)
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: android.view.LayoutInflater,
                              container: android.view.ViewGroup?,
                              savedInstanceState: android.os.Bundle?): android.view.View? {
        val view = inflater.inflate(R.layout.fragment_pokemones,
                container, false)
        presenter!!.loadPokemonesList(view)
        return view
    }

    override fun showPokemonesList(pokemones: ArrayList<NamedAPIResource>, view: View) {
        val recyclerView: RecyclerView = view.findViewById(R.id.recycler_view) as RecyclerView
        val adapter = RVAdapterPokemones(pokemones, context)
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = adapter
    }

}
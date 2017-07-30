package baltamon.mx.pokedexmvp.type

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import baltamon.mx.pokedexmvp.R
import baltamon.mx.pokedexmvp.models.NamedAPIResource
import kotlinx.android.synthetic.main.fragment_list.*

/**
 * Created by Baltazar Rodriguez on 04/07/2017.
 */

private const val MY_OBJECT_KEY = "types_list"

class TypesFragment: Fragment(), TypesView {

    var presenter: TypesPresenter? = null

    companion object{
        fun newInstance(types: ArrayList<NamedAPIResource>): TypesFragment{
            val fragment = TypesFragment()
            val bundle = Bundle()
            bundle.putParcelableArrayList(MY_OBJECT_KEY, types)
            fragment.arguments = bundle
            return fragment
        }
    }

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_list, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter = TypesPresenter(this, arguments)
        presenter?.onCreate()
    }

    override fun onPokemonTypes(types: ArrayList<NamedAPIResource>) {
        recycler_view.setHasFixedSize(true)
        recycler_view.layoutManager = LinearLayoutManager(context)
        recycler_view.adapter = RVAdapterTypes(types)
    }

}
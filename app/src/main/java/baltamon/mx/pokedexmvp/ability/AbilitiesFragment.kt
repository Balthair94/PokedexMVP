package baltamon.mx.pokedexmvp.ability

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import baltamon.mx.pokedexmvp.R
import baltamon.mx.pokedexmvp.models.NamedAPIResource
import baltamon.mx.pokedexmvp.presenters.Presenter
import kotlinx.android.synthetic.main.fragment_list.*

/**
 * Created by Baltazar Rodriguez on 02/07/2017.
 */

private const val MY_OBJECT_KEY = "abilities_list"

class AbilitiesFragment: Fragment(), AbilitiesView {

    var presenter: Presenter? = null

    companion object {
        fun newInstance(abilities: ArrayList<NamedAPIResource>): AbilitiesFragment {
            val fragment = AbilitiesFragment()
            val bundle = Bundle()
            bundle.putParcelableArrayList(MY_OBJECT_KEY, abilities)
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
        presenter = AbilitiesPresenter(this, arguments)
        presenter?.onCreate()
    }

    override fun onPokemonAbilities(abilities: ArrayList<NamedAPIResource>) {
        recycler_view.setHasFixedSize(true)
        recycler_view.layoutManager = LinearLayoutManager(context)
        recycler_view.adapter = RVAdapterAbilities(abilities, fragmentManager)
    }

}
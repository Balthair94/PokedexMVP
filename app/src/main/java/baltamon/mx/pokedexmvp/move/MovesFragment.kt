package baltamon.mx.pokedexmvp.move

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
 * Created by Baltazar Rodriguez on 02/07/2017.
 */

private const val MY_OBJECT_KEY = "moves_list"

class MovesFragment: Fragment(), MovesView {

    var presenter: MovesPresenter? = null

    companion object {
        fun newInstance(moves: ArrayList<NamedAPIResource>): MovesFragment {
            val fragment = MovesFragment()
            val bundle = Bundle()
            bundle.putParcelableArrayList(MY_OBJECT_KEY, moves)
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
        presenter = MovesPresenter(this, arguments)
        presenter?.onCreate()
    }

    override fun onPokemonMoves(moves: ArrayList<NamedAPIResource>) {
        recycler_view.setHasFixedSize(true)
        recycler_view.layoutManager = LinearLayoutManager(context)
        recycler_view.adapter = RVAdapterMoves(moves, fragmentManager)
    }

}
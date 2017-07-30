package baltamon.mx.pokedexmvp.about_pokemon

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import baltamon.mx.pokedexmvp.R
import baltamon.mx.pokedexmvp.models.Pokemon
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_about_pokemon.*

/**
 * Created by Baltazar Rodriguez on 02/07/2017.
 */

private const val MY_OBJECT_KEY = "pokemon"

class AboutPokemonFragment: Fragment(), AboutPokemonView {

    var presenter: AboutPokemonPresenter? = null

    companion object {
        fun newInstance(pokemon: Pokemon): AboutPokemonFragment {
            val fragment = AboutPokemonFragment()
            val bundle = Bundle()
            bundle.putParcelable(MY_OBJECT_KEY, pokemon)
            fragment.arguments = bundle
            return fragment
        }
    }

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_about_pokemon, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter = AboutPokemonPresenter(this, arguments)
        presenter?.onCreate()
    }

    override fun onPokemonInformation(pokemon: Pokemon) {
        tv_pokemon_name.text = pokemon.name
        tv_weight.text = "Weight: ${pokemon.weight}"
        tv_hight.text = "Hight: ${pokemon.height}"

        Picasso.with(context).load(pokemon.sprites.front_default).into(iv_pokemon_image)
        Picasso.with(context).load(pokemon.sprites.front_default).into(iv_form1)
        Picasso.with(context).load(pokemon.sprites.back_default).into(iv_form2)

        var textTypes = "Types: "
        for (item in pokemon.types) {
            textTypes += item.type.name + ", "
        }
        tv_types.text = textTypes
    }

}
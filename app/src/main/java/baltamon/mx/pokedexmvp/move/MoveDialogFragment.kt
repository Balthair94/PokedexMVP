package baltamon.mx.pokedexmvp.move

import android.os.Bundle
import android.support.v4.app.DialogFragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import baltamon.mx.pokedexmvp.R
import baltamon.mx.pokedexmvp.extensions.showToast
import baltamon.mx.pokedexmvp.models.Move
import baltamon.mx.pokedexmvp.models.NamedAPIResource
import baltamon.mx.pokedexmvp.presenters.Presenter
import kotlinx.android.synthetic.main.dialog_fragment_move.*

/**
 * Created by Baltazar Rodriguez on 04/07/2017.
 */

private const val MY_OBJECT_KEY = "pokemon_move"

class MoveDialogFragment: DialogFragment(), MoveView {

    var presenter: MovePresenter? = null

    companion object{
        fun newInstance(moveName: String): MoveDialogFragment{
            val dialog = MoveDialogFragment()
            val bundle = Bundle()
            bundle.putString(MY_OBJECT_KEY, moveName)
            dialog.arguments = bundle
            return dialog
        }
    }

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.dialog_fragment_move, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter = MovePresenter(this, arguments.getString(MY_OBJECT_KEY))
        presenter!!.onCreate()
    }

    override fun onPokemonMove(move: Move) {
        tv_loading_message.visibility = View.GONE
        layout_main.visibility = View.VISIBLE
        tv_move_name.text = move.name
        tv_move_pp.text = "PP: ${move.pp}"
        tv_move_power.text = "Power ${move.power}"
        tv_move_damage_class.text = "Damage class: ${move.damage_class.name}"
    }

    override fun onFailure(text: String) {
        context.showToast(text)
        dismiss()
    }

}
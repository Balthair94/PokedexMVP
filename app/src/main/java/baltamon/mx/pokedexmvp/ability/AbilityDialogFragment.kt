package baltamon.mx.pokedexmvp.ability

import android.os.Bundle
import android.support.v4.app.DialogFragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import baltamon.mx.pokedexmvp.R
import baltamon.mx.pokedexmvp.extensions.showToast
import baltamon.mx.pokedexmvp.models.Ability
import baltamon.mx.pokedexmvp.models.NamedAPIResource
import kotlinx.android.synthetic.main.dialog_fragment_ability.*

/**
 * Created by Baltazar Rodriguez on 04/07/2017.
 */

private const val MY_OBJECT_KEY = "pokemon_ability"

class AbilityDialogFragment: DialogFragment(), AbilityView {

    var presenter: AbilityPresenter? = null

    companion object {
        fun newInstance(abilityName: String): AbilityDialogFragment {
            val dialog = AbilityDialogFragment()
            val bundle = Bundle()
            bundle.putString(MY_OBJECT_KEY, abilityName)
            dialog.arguments = bundle
            return dialog
        }
    }

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.dialog_fragment_ability, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        tv_ability_name.text = arguments.getString(MY_OBJECT_KEY)
        tv_ability_description.text = getString(R.string.loading)

        presenter = AbilityPresenter(this, arguments.getString(MY_OBJECT_KEY))
        presenter!!.onCreate()
    }

    override fun onAbilityInformation(ability: Ability) {
        tv_ability_description.text = ability.effect_entries[0].effect
    }

    override fun onFailure(text: String) {
        context.showToast(text)
        dismiss()
    }

}
package baltamon.mx.pokedexmvp.main_activity

import android.support.v4.app.Fragment

/**
 * Created by Baltazar Rodriguez on 28/06/2017.
 */
interface MainActivityView {
    fun onFragmentSelected(fragment: Fragment)
    fun onFragmentFailure(text: String)
}
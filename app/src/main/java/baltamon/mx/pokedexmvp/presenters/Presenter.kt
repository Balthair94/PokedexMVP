package baltamon.mx.pokedexmvp.presenters

/**
 * Created by Baltazar Rodriguez on 28/06/2017.
 */
interface Presenter {
    fun onCreate()
    fun onPause(){}
    fun onResume(){}
    fun onDestroy(){}
}
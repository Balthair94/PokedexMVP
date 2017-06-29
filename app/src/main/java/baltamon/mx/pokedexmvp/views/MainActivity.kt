package baltamon.mx.pokedexmvp.views

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.view.GravityCompat
import android.view.MenuItem
import baltamon.mx.pokedexmvp.R
import baltamon.mx.pokedexmvp.extensions.showToast
import baltamon.mx.pokedexmvp.models.Generation
import baltamon.mx.pokedexmvp.presenters.MainActivityPresenter
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.toolbar_layout.*

class MainActivity : AppCompatActivity(), MainActivityView {

    val presenter: MainActivityPresenter = MainActivityPresenter(this, this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setUpToolbar()

        presenter.onCreate()
    }

    override fun loadFragment(fragmentId: Int, generation: Generation) {
        val replaceFragment = when (fragmentId){
            1 -> PokemonesFragment.newInstance(generation.pokemon_species)
            else -> showToast("No valid fragment")
        }

        if (replaceFragment is Fragment)
            supportFragmentManager.beginTransaction()
                    .replace(R.id.frame_layout, replaceFragment)
                    .commit()
    }

    override fun onBackPressed() {
        if (isDrawerOpen()) openCloseDrawer(false)
        else super.onBackPressed()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            android.R.id.home -> openCloseDrawer(true)
        }
        return super.onOptionsItemSelected(item)
    }

    fun setUpToolbar(){
        toolbar.setTitleTextColor(Color.WHITE)
        setSupportActionBar(toolbar)
        supportActionBar?.title = getString(R.string.title_main_pokedex)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeAsUpIndicator(R.drawable.ic_menu)
        supportActionBar?.setDisplayShowTitleEnabled(true)
    }

    fun openCloseDrawer(shouldOpen: Boolean){
        if (shouldOpen) drawer_layout.openDrawer(GravityCompat.START)
        else drawer_layout.closeDrawers()
    }

    fun isDrawerOpen(): Boolean = drawer_layout.isDrawerOpen(GravityCompat.START)
}

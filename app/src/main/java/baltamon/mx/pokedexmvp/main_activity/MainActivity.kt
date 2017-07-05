package baltamon.mx.pokedexmvp.main_activity

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.app.Fragment
import android.support.v4.view.GravityCompat
import android.view.MenuItem
import baltamon.mx.pokedexmvp.R
import baltamon.mx.pokedexmvp.extensions.showToast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.toolbar_layout.*

class MainActivity : AppCompatActivity(), MainActivityView, NavigationView.OnNavigationItemSelectedListener {

    val presenter: MainActivityPresenter = MainActivityPresenter(this, this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setUpToolbar()
        setUpNavigationView(this)
        presenter.onCreate()
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        val message = when(item.itemId){
            R.id.item_pokemons -> {
                presenter.loadFragment(1)
                "Pokemones"
            }
            R.id.item_moves -> {
                presenter.loadFragment(2)
                "Moves"
            }
            R.id.item_abilities -> {
                presenter.loadFragment(3)
                "Abilities"
            }
            R.id.item_types ->{
                presenter.loadFragment(4)
                "Types"
            }
            else -> "No item selected"
        }

        showToast(message)
        openCloseDrawer(false)
        return true
    }

    override fun onFragmentSelected(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
                .replace(R.id.frame_layout, fragment)
                .commit()
    }

    override fun onFragmentFailure(text: String) {
        showToast(text)
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

    fun setUpNavigationView(navigationListener: NavigationView.OnNavigationItemSelectedListener) =
            navigation_view.setNavigationItemSelectedListener(navigationListener)

    fun openCloseDrawer(shouldOpen: Boolean){
        if (shouldOpen) drawer_layout.openDrawer(GravityCompat.START)
        else drawer_layout.closeDrawers()
    }

    fun isDrawerOpen(): Boolean = drawer_layout.isDrawerOpen(GravityCompat.START)
}

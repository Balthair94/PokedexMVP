package baltamon.mx.pokedexmvp.pokemon_detail

import android.graphics.Color
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import baltamon.mx.pokedexmvp.R
import baltamon.mx.pokedexmvp.models.Pokemon
import kotlinx.android.synthetic.main.activity_pokemon_detail.*
import kotlinx.android.synthetic.main.toolbar_layout.*

/**
 * Created by Baltazar Rodriguez on 02/07/2017.
 */
class PokemonDetailActivity: AppCompatActivity(), PokemonDetailView {

    var presenter: PokemonDetailPresenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pokemon_detail)
        setUpToolbar()
        presenter = PokemonDetailPresenter(this, this, intent)
        presenter?.onCreate()
    }

    fun setUpToolbar(){
        toolbar.setTitleTextColor(Color.WHITE)
        setSupportActionBar(toolbar)
        supportActionBar?.title = getString(R.string.title_main_pokedex)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeAsUpIndicator(R.drawable.ic_arrow_back)
        supportActionBar?.setDisplayShowHomeEnabled(true)
    }

    override fun onLoadTabView(pokemon: Pokemon) {
        view_pager.adapter = TabPokemonFragmentAdapter(supportFragmentManager, pokemon)
        tab_layout.setupWithViewPager(view_pager)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId){
            android.R.id.home -> onBackPressed()
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onBackPressed() {
        finish()
        super.onBackPressed()
    }

}
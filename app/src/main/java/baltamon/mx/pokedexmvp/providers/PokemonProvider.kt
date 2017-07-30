package baltamon.mx.pokedexmvp.providers

import baltamon.mx.pokedexmvp.models.Pokemon
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * Created by Baltazar Rodriguez on 03/07/2017.
 */
class PokemonProvider(val presenter: PokemonProviderInterface) {

    fun loadPokemon(pokemonName: String){
        val restClient = buildRetrofit(buildGson()).create(PokeAPIClient::class.java)
        val call = restClient.getPokemon(pokemonName)

        call.enqueue(object : Callback<Pokemon>{
            override fun onResponse(call: Call<Pokemon>?, response: Response<Pokemon>) {
                when(response.code()){
                    200 -> response.body()?.let { presenter.onSuccess(it) }
                    else -> presenter.onFailure("NO DATA")
                }
            }

            override fun onFailure(call: Call<Pokemon>?, t: Throwable?) {
                presenter.onFailure(t.toString())
            }

        })
    }

}
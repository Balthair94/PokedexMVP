package baltamon.mx.pokedexmvp.providers

import baltamon.mx.pokedexmvp.models.Generation
import baltamon.mx.pokedexmvp.presenters.MainActivityPresenter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * Created by Baltazar Rodriguez on 28/06/2017.
 */
class GenerationProvider (val presenter: MainActivityPresenter){

    fun loadPokemonGeneration(){

        val inter: GenerationProviderInterface = presenter

        val restClient = buildRetrofit(buildGson()).create(PokeAPIClient::class.java)
        val call = restClient.generation

        call.enqueue(object : Callback<Generation>{
            override fun onFailure(call: Call<Generation>?, t: Throwable?) = inter.onFailure(t.toString())

            override fun onResponse(call: Call<Generation>?, response: Response<Generation>) {
                when (response.code()){
                    200 -> {
                        inter.onSuccess(response.body()!!)
                    }
                }
            }

        })
    }

}
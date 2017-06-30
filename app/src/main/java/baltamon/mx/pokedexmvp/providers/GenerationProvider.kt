package baltamon.mx.pokedexmvp.providers

import baltamon.mx.pokedexmvp.models.Generation
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * Created by Baltazar Rodriguez on 28/06/2017.
 */
class GenerationProvider (val presenter: GenerationProviderInterface){

    fun loadPokemonGeneration(){
        val restClient = buildRetrofit(buildGson()).create(PokeAPIClient::class.java)
        val call = restClient.generation

        call.enqueue(object : Callback<Generation>{
            override fun onFailure(call: Call<Generation>?, t: Throwable?) =
                    presenter.onFailure(t.toString())

            override fun onResponse(call: Call<Generation>?, response: Response<Generation>) {
                when (response.code()){
                    200 -> {
                        presenter.onSuccess(response.body()!!)
                    }
                }
            }

        })
    }

}
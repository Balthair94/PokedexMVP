package baltamon.mx.pokedexmvp.providers

import baltamon.mx.pokedexmvp.models.Move
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * Created by Baltazar Rodriguez on 04/07/2017.
 */
class MoveProvider(val presenter: MoveProviderInterface) {
    fun loadMove(moveName: String){
        val restClient = buildRetrofit(buildGson()).create(PokeAPIClient::class.java)
        val call = restClient.getMove(moveName)

        call.enqueue(object : Callback<Move>{
            override fun onResponse(call: Call<Move>?, response: Response<Move>) {
                when(response.code()){
                    200 -> response.body()?.let { presenter.onSuccess(it) }
                    else -> presenter.onFailure("NO DATA")
                }
            }

            override fun onFailure(call: Call<Move>?, t: Throwable?) =
                    presenter.onFailure(t.toString())

        })
    }
}
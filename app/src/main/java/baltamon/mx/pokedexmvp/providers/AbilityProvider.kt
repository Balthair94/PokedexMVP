package baltamon.mx.pokedexmvp.providers

import baltamon.mx.pokedexmvp.models.Ability
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * Created by Baltazar Rodriguez on 04/07/2017.
 */
class AbilityProvider(val presenter: AbilityProviderInterface) {
    fun loadAbility(name: String){
        val restClient = buildRetrofit(buildGson()).create(PokeAPIClient::class.java)
        val call = restClient.getAbility(name)

        call.enqueue(object : Callback<Ability>{
            override fun onFailure(call: Call<Ability>?, t: Throwable?) =
                    presenter.onFailure(t.toString())

            override fun onResponse(call: Call<Ability>?, response: Response<Ability>) {
                when(response.code()){
                    200 -> presenter.onSuccess(response.body()!!)
                }
            }
        })
    }
}
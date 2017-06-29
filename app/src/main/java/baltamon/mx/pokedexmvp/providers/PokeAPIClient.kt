package baltamon.mx.pokedexmvp.providers

import baltamon.mx.pokedexmvp.models.Ability
import baltamon.mx.pokedexmvp.models.Generation
import baltamon.mx.pokedexmvp.models.Move
import baltamon.mx.pokedexmvp.models.Pokemon
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * Created by Baltazar Rodriguez on 28/06/2017.
 */
interface PokeAPIClient {
    @get:GET("generation/1")
    val generation: Call<Generation>

    @GET("pokemon/{name}")
    fun getPokemon(@Path("name") pokemonName: String): Call<Pokemon>

    @GET("ability/{name}")
    fun getAbility(@Path("name") abilityName: String): Call<Ability>

    @GET("move/{name}")
    fun getMove(@Path("name") moveName: String): Call<Move>
}
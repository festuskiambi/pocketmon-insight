package com.feature.pokemon_list.data.remote

import com.feature.pokemon_list.data.remote.model.GetPokemonResponse
import retrofit2.http.GET
import retrofit2.http.Query

 interface PokemonApiInterface {
    @GET("pokemon")
    suspend fun getPokeMon(
        @Query("limit") limit: String? = "20",
    ): GetPokemonResponse
}